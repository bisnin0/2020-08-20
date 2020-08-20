package Thread_Study.fail;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarSwing2 extends JPanel implements ActionListener, ItemListener {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);//2020;
		int month = now.get(Calendar.MONTH)+1;//8;

		JButton leftBtn = new JButton("��");
		JButton rightBtn = new JButton("��");
		JLabel topLbl1 = new JLabel("��", 10);
		JLabel topLbl2 = new JLabel("��", 10);
		
		JComboBox<Integer> yearCombo = new JComboBox<Integer>(); //�⵵ ���� �޺��ڽ�
			DefaultComboBoxModel<Integer> ydcb = new DefaultComboBoxModel<Integer>(); 
		JComboBox<Integer> monthCombo = new JComboBox<Integer>(); //�� ���� �޺��ڽ�
			DefaultComboBoxModel<Integer> mdcb = new DefaultComboBoxModel<Integer>();
				
		Font fontSize = new Font("����ü", Font.BOLD, 20);
		
		JPanel frmTop = new JPanel(); //�¿� ��ư�� �޺��ڽ� ����ġ
		JPanel frmCenter = new JPanel(new BorderLayout()); //���ϰ� ��¥ ���κ�(����)
			JPanel centerNorth = new JPanel(new GridLayout(1,3, 2, 2)); //���Ϻκ�
			JPanel centerLbl = new JPanel(new GridLayout(0, 7, 5, 5)); //��¥ ���

		String weekLbl[] = {"��","��","ȭ","��","��","��","��"};
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
public CalendarSwing2() {
		setLayout(new BorderLayout());
		//�޺��ڽ��� ��� �ֱ�
		for(int i=1900; i<=2100; i++) { //�� 
			ydcb.addElement(i);
		}
		yearCombo.setModel(ydcb);
		yearCombo.setSelectedItem(year); //���� �⵵
		
		for(int i=1; i<=12; i++) {//�� 
			mdcb.addElement(i);
		}
		monthCombo.setModel(mdcb);
		monthCombo.setSelectedItem(month); //���� ��
		
		//��� ���� �޺��ڽ� ��ġ
		leftBtn.setPreferredSize(new Dimension(47, 22));
		rightBtn.setPreferredSize(new Dimension(47, 22));
		frmTop.add(leftBtn);
		frmTop.add(yearCombo);
		frmTop.add(topLbl1);
		frmTop.add(monthCombo);
		frmTop.add(topLbl2);
		frmTop.add(rightBtn);
		
		frmTop.setOpaque(true);
		frmTop.setBackground(Color.cyan);
		add(BorderLayout.NORTH, frmTop); //�޺��ڽ� �г� ��ġ
		
		/////////////////���� �г� ����
		centerNorth.setOpaque(true);
		centerNorth.setBackground(Color.WHITE);
		for(int i=0; i<7; i++) {
			JLabel lbl = new JLabel(weekLbl[i]);
			lbl.setFont(fontSize);
			lbl.setBackground(Color.lightGray);
			lbl.setHorizontalAlignment(JLabel.CENTER);
			lbl.setOpaque(true);
			if(i==0){ //��, �� ��Ʈ �� ����
				lbl.setForeground(Color.RED);
			}else if(i==6) {
				lbl.setForeground(Color.BLUE);
			}
			centerNorth.add(lbl);
		}
		/////////////////��¥ �г� ���
		frmCenter.add(BorderLayout.NORTH, centerNorth);
		frmCenter.add(BorderLayout.CENTER, centerLbl);
		add(BorderLayout.CENTER, frmCenter);
		
		//�̺�Ʈ ���
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		leftBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		calendar();
		
	}

	public void actionPerformed(ActionEvent ae) {
		String event = ae.getActionCommand();
//		centerLbl.removeAll();
////		centerLbl.revalidate(); //���ɸ�
//		centerLbl.repaint(); //������
		if(event.equals("��")) {
			if(month>1) {  /////1������ ������
				centerLbl.removeAll();
//				centerLbl.revalidate(); //���ɸ�
				centerLbl.repaint(); //������
			month--;
			monthCombo.setSelectedItem(month);
			}
//			calendar();
		}else if(event.equals("��")) {
			if(month<12) {
				centerLbl.removeAll();
//				centerLbl.revalidate(); //���ɸ�
				centerLbl.repaint(); //������
			month++;
			monthCombo.setSelectedItem(month);
			}
		}
		
	}
	public void itemStateChanged(ItemEvent ie) {
		centerLbl.removeAll(); ////�� ���� �ȵǳ�?
		centerLbl.revalidate(); ///////////�̰� �߿�.. 
//		centerLbl.repaint();
		year = (Integer)yearCombo.getSelectedItem(); 
		month = (Integer)monthCombo.getSelectedItem();
		calendar();
	}

	public void calendar() { 
		now.set(year,month-1,1); //�̰ɷ� ������ �ް� ���� ����
		int sDayNum = now.get(Calendar.DAY_OF_WEEK); // 1���� ���� 
		int endDate = now.getActualMaximum(Calendar.DATE); //���� �������� 
		int Size = sDayNum+endDate-1;
		String arr[] = new String[Size]; 
		
		//////// �迭�� ����, ��¥ �ֱ�
		int j=1;
	     for (int i=0; i<sDayNum-1;i++){ //����
	            arr[i]=" ";  
	        }
	     for (int i = sDayNum-1; i < Size ; i++) {  // ���� ���� 1���� �������ϱ���.        
	      	arr[i]=String.valueOf(j);
	       	j++;
	     }
	     

	     int k = 0; 	//�迭���� ���� �н�
        Calendar now2 = Calendar.getInstance(); //���� ���ϱ� �뵵   

        for(int i=0; i<arr.length; i++) {
	    	JLabel dayLbl = new JLabel(arr[i]);//�� ����
	    	dayLbl.setFont(fontSize);
	    	if(!arr[i].equals(" ")) { //��ư�� ���ֱ�
	    		k++;
	    		now2.set(year,month-1,k); //���� �ƴϸ� 1�Ϻ��� ����
	    		int dayNum = now2.get(Calendar.DAY_OF_WEEK); //���� 
	    		if(dayNum==1){ //��
	    			dayLbl.setForeground(Color.RED);
	    		}else if(dayNum==7) { //��
	    			dayLbl.setForeground(Color.BLUE);
	    		}
	    	}
	    	dayLbl.setHorizontalAlignment(JLabel.CENTER);
	    	centerLbl.setOpaque(true);
	    	centerLbl.setBackground(Color.WHITE);
	    	centerLbl.add(dayLbl);
	    	
	    }
	}
	
//
//	public static void main(String[] args) {
//		new CalendarSwing2();
//	}

}
