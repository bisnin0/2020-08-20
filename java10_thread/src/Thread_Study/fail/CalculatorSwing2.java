package Thread_Study.fail;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//public class CalculatorSwing extends JFrame implements ActionListener {
										//�ٸ� Ŭ�������� �̺�Ʈ ó���� �Ҷ��� ���⼭ �������̽� ��ӹ��� �ʿ䰡����.
	public class CalculatorSwing2 extends JPanel {
	Font fnt = new Font("Arial", Font.PLAIN, 30);
	JTextField tf = new JTextField("0.0");
	
	
	//Button�� �󺧷� �������� �ؽ�Ʈ�� �迭�� �����
	String btnLbl[] = {"BackSpace", "Clear", "End", 
						"7", "8", "9", "+",
						"4", "5", "6", "-",
						"1", "2", "3", "*",
						"0", ".", "=", "/"};
	
	//centerbtn�� frmcenter�� ���Ϳ�, centernorth�� frmcenter�� ���ʿ�. frmcenter�� JFrameâ �߾ӿ� �ִ´�. 
	JPanel frmCenter = new JPanel(new BorderLayout()); //���� ��ư �� ��ü�г� ������
		JPanel centerNorth = new JPanel(new GridLayout(1,3));//�齺���̽�, Ŭ����, ���� �� �г�
		JPanel centerBtn = new JPanel(new GridLayout(4,4,5,5)); //����, ������ �� �ڸ�
		
	CalculatorEvent event = new CalculatorEvent(tf); //��ư 18���� �����Ҷ����� �̺�Ʈ ��������� �Ұ� �ƴ϶� �׳� �̰� �ϳ��� �ذ�����.
											//������ tf�� CalculatorEvent�� tf�� ���ƾ� �ϴϱ� CalculatorEvent�� ������ �޼ҵ带 ���� �������� �������� �������
	
	public CalculatorSwing2() {
		setLayout(new BorderLayout());
		tf.setFont(fnt);
		tf.setHorizontalAlignment(JTextField.RIGHT); //���������� "0.0" �̵�
		add("North", tf);
		
		//��ư��
		add("Center", frmCenter); //�����ӿ� frmCenter�� �߾ӿ� �߰��Ѵ�.
			frmCenter.add("North", centerNorth); //centerNorth�� frmCenter ���ʿ� �߰��Ѥ�,
			frmCenter.add("Center" ,centerBtn); // centerBtn�� frmCenter �߾ӿ� �߰��Ѥ�,
			
			//��ư �߰�
			for(int i=0; i<btnLbl.length; i++) {//0,1,2,3,4,...... 18
				JButton btn = new JButton(btnLbl[i]);//��ư ����
				btn.setFont(fnt);//���� ũ�� ����
				btn.setBackground(Color.lightGray); //����ĥ�ϱ�
				
//				btn.addActionListener(this);//��ư �̺�Ʈ ��� .. �̰� this�̱⶧���� �Ʒ� actionPerForme�� ���°�. 
											//�ٸ� Ŭ�������� ���� �� �ִ�. ���������.
				
				btn.addActionListener(event); //���� ��ü �������̷��� CaculatorEvent Ŭ������ ����� �����ü����ִ�.
				//��ư�� JPanel�� �߰�
				if(i<=2) { //index�� 0~2������ ���� �뽺�� ��ư �߰��ض�
					centerNorth.add(btn);
				}else {
					centerBtn.add(btn);//3�̻��̸� ���͹�ư�� �߰��ض�.
				}
				
			}
	
				
		
		
		
	}
	
//	public void actionPerformed(ActionEvent ae) { //API���� ���� �������̵� �ؾ� �ϴ��� ���´�.
//		�ٸ� Ŭ�������� �������.
//	}


}
//���� Ǯ��
//���� ���ĭ�� Jtextfield�� Jlabel�� ������ �ȴ�. Jlabel�� ���� ������ ĭ�� �������⶧���� ���� �־�����Ѵ�.
//Jtextfield
//�齺���̽�, Ŭ����, ����
//7 8 9 +
//4 5 6 -
//1 2 3 *
//0 . = /

//������ ���� ���� �ؽ�Ʈ�ʵ�
//�������̾ƿ� ������ �齺���̽� Ŭ���� ����
//�������̾ƿ� ���Ϳ��� �׸��巹�̾ƿ����� ����â �ֱ�.
//â�� �������̾ƿ� �����ӿ� ��������� �ȴ�.