package EX;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class ThreadEX extends JFrame {
	DigitalClockEX3 dc = new DigitalClockEX3();
	CalendarSwing2 cal = new CalendarSwing2();
	PackManEX pm = new PackManEX();
	
	/*
	


	 */
	
	public ThreadEX() {
	
		JSplitPane sp1 = new JSplitPane();
		sp1.setOrientation(JSplitPane.HORIZONTAL_SPLIT); //위에서 한문장 안하고 나중에 이걸로 셋팅해도된다.
		sp1.add(pm, JSplitPane.RIGHT); //오른쪽에 팩맨을 추가해라.
		
		JSplitPane sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dc, cal); //위랑 이거랑 편한대로 선택해서 사용
		sp1.add(sp2, JSplitPane.LEFT); //JSpliPane의 왼쪽에 추가해라.
		
		sp2.setDividerLocation(200);
		
		//스레드 객체 만들어야함 //이걸 해야 스레드를 시작할수있다.
		Thread dcThread = new Thread(dc);
		Thread pmThread = new Thread(pm);
		dcThread.start();
		pmThread.start();
		
		add(sp1); //팩맨은 여기 추가되고 나서야 사이즈가 정해진다. 여기까지 해서 출력하면 팩맨 좌표가 이상함.
	
		
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		////////사이즈가 setSize로 정해지기때문에 이 전에 아래를 추가하면 좌표 이상하게나옴.
		pm.y = pm.getHeight()/2+25;
		
	}

	public static void main(String[] args) {
		new ThreadEX();
	}

}
