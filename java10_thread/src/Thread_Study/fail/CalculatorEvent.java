package Thread_Study.fail;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;

public class CalculatorEvent implements ActionListener {
	JTextField tf;
	String oper = "";//������ ������ ����
	double result = 0.0; //ù��° ���������� ���
	
	public CalculatorEvent() {
		
	}
	
	public CalculatorEvent(JTextField tf) {
		this.tf = tf; //tf�� �ּҸ� ���� ������ش�. CalculatorSwing��... ���� ���� ������
	}
	public void actionPerformed(ActionEvent ae) {
		String eventTxt = ae.getActionCommand(); //9������ 9 ���ְ�, 7 ������ 7 ���ִ� ����
		switch(eventTxt){ 
			//��� event�� ���� �ְ� End��?
			case "End":
				System.exit(0); break; //���α׷��� ������
			
				
			//BackSpaceó��
			case "BackSpace":
				setBackSpace();
				break;
				
			//��� �̺�Ʈ�� ����ְ� .�̸� �Ҽ��� ó���� �ؾ���
			case ".":
				setPoint();
				break;
				
			//������ó��   == ���̽��� ������ �����Ÿ� �Ʒ�ó�� ó���ص� �ȴ�.
			case "+":
			case "-":
			case "*":
			case "/":
				setOperator(eventTxt);
				break;
				
			//=�� ������
			case "=":
				setCalculator();
				break;
			
			case "Clear":
				setClear();
				break;
				
			//evetTxt�� ����ִ� ���� Ȥ�� ���ڳ�? 
			default://���ڹ�ư�ϰ��
				setNumber(eventTxt);//���ڰ� ������ setNumber�� ȣ���ؼ� �̺�Ʈ�� ���� ���ڸ� �Ѱ��ش�.
				
		}
	}
	public void setClear() {
		result = 0.0;
		oper = "";
		tf.setText("0.0");
	}
	public void setCalculator() {
		//ó�� ����� �����ʹ� result�� �ְ� �����ڴ� oper�� ����ִ�.
		//���߿� �Է��� �����ʹ� tf�� ����ִ�.
		double secondNum = Double.parseDouble(tf.getText());
		//tf���� �����͸� �����ͼ� �Ǽ��� �ٲٰ� secondNum�� �ִ´�.
		switch(oper) {
			case "+": result = result + secondNum; break; //���ϱ�
			case "-": result = result - secondNum; break; //����
			case "*": result = result * secondNum; break; //���ϱ�
			case "/": result = result / secondNum; break; //������
		//result�� ����� �־��.
		
		}
		tf.setText(Double.toString(result));//����� tfǥ�� double�� result�� ���ڿ��� �ٲ���
		//		   String.valueOf(result)�� �����ϴ�.
		
		//������ �����
		oper = "";
	}
	
	public void setOperator(String eventTxt) {
		//��� �߻��� �̺�Ʈ�� �����ڰ� ����.
		//������� ��������� �����Ѵ�.
		oper = eventTxt;//������ //' 789 + ' �� �Է��ϸ� + �� oper�� ���ְ�
		result = Double.parseDouble(tf.getText()); //789�� result�� ���ִ�.
		// tf�ʱ�ȭ .. ���� ���ڸ� �޾ƾ� �ϴϱ�
		tf.setText("");
	}
	
	public void setPoint() { //�Ҽ����� �ִ��� ������ Ȯ�θ��� �ؾ��Ѵ�.
		String txt = tf.getText(); //Ư�������� index��ġ�� ���ϴ°�. 
		if(txt.indexOf(".") == -1){//indexOf// -1�� ������ ã�°� ���ܰŰ�. ��� ���ڰ� ������ ã�°� �ִٴ°�.
			tf.setText(txt+"."); //�Ҽ����� �Ѱ��� ����.
			//�̷����ϸ� �Ҽ����� �ϳ� ������ ���� ���� ������ ������ �ʴ´�.
		}
		
	}
	
	public void setNumber(String eventTxt) { //��� �̺�Ʈ�� ���� ��ư�� ���� ���� �޴´�.
		String tfTxt = tf.getText();
		if(tfTxt.equals("0.0")){
			tf.setText(eventTxt); //���� ��� tf�� �ؽ�Ʈ�� 0.0�̸� ��� �̺�Ʈ ����� �ִ´�.
		}else {
			tf.setText(tfTxt+eventTxt); //0.0�� �ƴϸ� ���� ���� ��� ���� ���� �߰��ؼ� ȣ��
		}
		
	}
	
	//BackSpace ��ɱ���.. ���ڿ����� ���°�� ���� �ִ��� ã�°�. subString
	//52623
	//01234 ==subString(0,4) == ���̰� 5���ε� 4������ ���ϸ� ������ 3��°�� ������ϱ�
	// sbuString(0, txt.length()-1); 

	public void setBackSpace() {
		try {
		String txt = tf.getText();
		String cutTxt = txt.substring(0, txt.length()-1); //������ 0��°����.(���� ��) ������ ���̿��� -1����
		tf.setText(cutTxt);
		}catch(StringIndexOutOfBoundsException sioobe) {
			System.out.println("�����߻���. ���ڿ� ���� 0�ε� ���̸� -1��ŭ ������ ����");
		}
		//����ó��  StringIndexOutOfBoundsException .. ������ ���̰� 0�ε�("") -1��ŭ ������ �ϴϱ� �����߻�
		//String�� -1�̶�� index�� ����.
		//���� ���̸� Ȯ���ؼ� ���ڱ��̰� 0�϶� �� ���ϴ°ɷ� �ٲ��ָ� �ǰڴ�.
		//�̷��� �ϸ� ������ ������ �ִ°����� ����ó���� �޽����� �ȶߴ°Ŵ�.
	}
}
