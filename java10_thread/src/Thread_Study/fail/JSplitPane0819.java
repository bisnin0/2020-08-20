package Thread_Study.fail;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class JSplitPane0819 extends JFrame implements Runnable { 
	CalendarSwing2 calendar = new CalendarSwing2();
	DigitalClockEX2 dc2;
	PackManEX2 pm;
	
	public JSplitPane0819() {
//		add(pm);

		JSplitPane sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pm, calendar);
		JSplitPane sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, dc2);
		add(sp1);
		
		sp1.setDividerLocation(500);
		sp2.setDividerLocation(300);
		
		sp1.setDividerSize(5); 
		sp2.setDividerSize(5); 
		
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		
	}
	
	public void run() {
		dc2 = new DigitalClockEX2();
		pm  = new PackManEX2();

	}


	public static void main(String[] args) {
//		PackManEX2 pm2 = new PackManEX2();
//		Thread d1 = new Thread(pm2);
//		d1.start();
		JSplitPane0819 pp = new JSplitPane0819();
		Thread t = new Thread(pp);
		t.start();
//		new JSplitPane0819();
		

	}
}
