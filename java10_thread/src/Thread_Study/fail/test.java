package Thread_Study.fail;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;



public class test {
	JPanel pp = new JPanel();
	CalendarSwing2 calendar = new CalendarSwing2();
	RGBEX2 rgb = new RGBEX2();
	CalculatorSwing2 calculator = new CalculatorSwing2();
	public test() {
	}
	public static void main(String[] args) {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JSplitPane split = new JSplitPane();
	split.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
	
	frame.getContentPane().add(split);
	frame.setSize(350,350);
	frame.setVisible(true);
	}

}
