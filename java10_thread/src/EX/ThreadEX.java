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
		sp1.setOrientation(JSplitPane.HORIZONTAL_SPLIT); //������ �ѹ��� ���ϰ� ���߿� �̰ɷ� �����ص��ȴ�.
		sp1.add(pm, JSplitPane.RIGHT); //�����ʿ� �Ѹ��� �߰��ض�.
		
		JSplitPane sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dc, cal); //���� �̰Ŷ� ���Ѵ�� �����ؼ� ���
		sp1.add(sp2, JSplitPane.LEFT); //JSpliPane�� ���ʿ� �߰��ض�.
		
		sp2.setDividerLocation(200);
		
		//������ ��ü �������� //�̰� �ؾ� �����带 �����Ҽ��ִ�.
		Thread dcThread = new Thread(dc);
		Thread pmThread = new Thread(pm);
		dcThread.start();
		pmThread.start();
		
		add(sp1); //�Ѹ��� ���� �߰��ǰ� ������ ����� ��������. ������� �ؼ� ����ϸ� �Ѹ� ��ǥ�� �̻���.
	
		
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		////////����� setSize�� �������⶧���� �� ���� �Ʒ��� �߰��ϸ� ��ǥ �̻��ϰԳ���.
		pm.y = pm.getHeight()/2+25;
		
	}

	public static void main(String[] args) {
		new ThreadEX();
	}

}
