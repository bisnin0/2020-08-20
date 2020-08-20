package Thread_Study.fail;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClockEX extends JFrame implements Runnable{
	
//////////�� �ɹ������� �����Ǿ����� �����ϱ�.
//////////�Ʒ� setTime�޼ҵ忡�� ����� ���� ����ؼ� ���⿡ ������ �� �����Ͱ� digitalclock�޼ҵ忡�� ���Ǵϱ�
	//////�޼ҵ带 ������ ����Ǵ� �޼ҵ��� ���� �ǽð����� ����ؼ� ��������� �� �ִ�.
	
	JLabel lbl = new JLabel("11:50:10");
	Font ftn = new Font("Arial", Font.BOLD, 100);
	int x=1;
	
	
	public DigitalClockEX() {
		super("Clock");
		//setTitle("Clock");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image icon = tk.getImage("img/k2.jpg");
		setIconImage(icon);  //�������� ����
	
		
		
		//JLabel ���ڿ� ��� ����.. 
		lbl.setHorizontalAlignment(JLabel.CENTER);  //��ġ�� ���� �������� ���ͷ� ����. 
		lbl.setFont(ftn);
		add(lbl);
		

		
		
//		setTime(); //�Ʒ� �ð� ���� ��������
	}
	public DigitalClockEX(int x) {
		this();
		this.x=x;
		setBounds(x,1,450,150);
//		pack();//������ ���� ��ŭ â�� ũ�Ⱑ ��������. // setSize(400, 200); // setBounds(x,y,w,h);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
	public static void main(String[] args) {
		DigitalClockEX dc1 = new DigitalClockEX(1);
		DigitalClockEX dc2 = new DigitalClockEX(451);
		DigitalClockEX dc3 = new DigitalClockEX(901);
		
		Thread t1 = new Thread(dc1);
		Thread t2 = new Thread(dc2);
		Thread t3 = new Thread(dc3);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
