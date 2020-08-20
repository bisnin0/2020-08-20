import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock extends JFrame implements Runnable{
	
//////////�� �ɹ������� �����Ǿ����� �����ϱ�.
//////////�Ʒ� setTime�޼ҵ忡�� ����� ���� ����ؼ� ���⿡ ������ �� �����Ͱ� digitalclock�޼ҵ忡�� ���Ǵϱ�
	//////�޼ҵ带 ������ ����Ǵ� �޼ҵ��� ���� �ǽð����� ����ؼ� ��������� �� �ִ�.
	
	JLabel lbl = new JLabel("11:50:10");
	Font ftn = new Font("Arial", Font.BOLD, 50);
	
	int a=0;
	
	public DigitalClock() {
	
	}
	public DigitalClock(int a) {
		this.a= a;
	}
	//�ð� ���� ����
	public void setTime() {
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
	
	public void run() {

			
			setTitle("Clock");
			
			Toolkit tk = Toolkit.getDefaultToolkit();
			Image icon = tk.getImage("img/k2.jpg");
			setIconImage(icon);  //�������� ����
		
			
			
			//JLabel ���ڿ� ��� ����.. 
			lbl.setHorizontalAlignment(JLabel.CENTER);  //��ġ�� ���� �������� ���ͷ� ����. 
			lbl.setFont(ftn);
			add(lbl);
			setBounds(a, 0, 300, 200);
			pack();//������ ���� ��ŭ â�� ũ�Ⱑ ��������. // setSize(400, 200); // setBounds(x,y,w,h);
			setVisible(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			setTime(); //�Ʒ� �ð� ���� ��������
	}


}
