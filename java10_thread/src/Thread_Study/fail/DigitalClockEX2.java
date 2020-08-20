package Thread_Study.fail;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClockEX2 extends JPanel implements Runnable{
	
//////////�� �ɹ������� �����Ǿ����� �����ϱ�.
//////////�Ʒ� setTime�޼ҵ忡�� ����� ���� ����ؼ� ���⿡ ������ �� �����Ͱ� digitalclock�޼ҵ忡�� ���Ǵϱ�
	//////�޼ҵ带 ������ ����Ǵ� �޼ҵ��� ���� �ǽð����� ����ؼ� ��������� �� �ִ�.
	
	JLabel lbl = new JLabel("11:50:10");
	Font ftn = new Font("Arial", Font.BOLD, 100);
	int x=1;
	
	
	public DigitalClockEX2() {
		//setTitle("Clock");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image icon = tk.getImage("img/k2.jpg");
	
		
		
		//JLabel ���ڿ� ��� ����.. 
		lbl.setHorizontalAlignment(JLabel.CENTER);  //��ġ�� ���� �������� ���ͷ� ����. 
		lbl.setFont(ftn);
		add(lbl);
		
//		setBounds(x,1,450,150); // â ������ ����
//		pack();//������ ���� ��ŭ â�� ũ�Ⱑ ��������. // setSize(400, 200); // setBounds(x,y,w,h);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Thread t = new Thread(this);
		t.start();
//		setTime(); //�Ʒ� �ð� ���� ��������
	}
	
	public void run() {
		do {
			//���� �ð� ���ϱ�
			Calendar now = Calendar.getInstance();
			
			//���ڿ� ���ϱ�
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String clock = sdf.format(now.getTime()); //Calendar�� Date�� �������ִ°� getTime�̴�.
			
			
			//�󺧿� ����
			//���÷��� �Ǿ��ִ� ���ڸ� ��������ִ� �۾� setText
			lbl.setText(clock); //swing API�� ����
			
			//�Ͻ�����
			try { //Thread�� ������ ����ó���� �ؾ���.
			Thread.sleep(500);
			}catch(Exception e) {}
			
			
			
			
		}while(true);
	}
//	public static void main(String[] args) {
//		new DigitalClockEX2();
//		DigitalClockEX2 dc1 = new DigitalClockEX2(1);
//		DigitalClockEX2 dc2 = new DigitalClockEX2(451);
//		DigitalClockEX2 dc3 = new DigitalClockEX2(901);
//		
//		Thread t1 = new Thread(dc1);
//		Thread t2 = new Thread(dc2);
//		Thread t3 = new Thread(dc3);
//		
//		t1.start();
//		t2.start();
//		t3.start();
		
//	}
}
