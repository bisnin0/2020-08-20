package EX;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class PackManEX extends JPanel implements Runnable{
	Image img;
	int x, y;
	int p=0;
	MyCanvas1 canvas;
	
	/*
	//////////프레임은 다른 컨테이너에 안들어감. 패널로 변경
	보더레이아웃으로 설정 = 이유. ////JFrame을 JPanel로 바꿀때는 기본 레이아웃이 다르기때문에 JFrame의 기본 레이아웃으로 변경해줘야한다.
	사이즈 설정 불가능
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	삭제
	메인메소드 삭제
	
	반복문 속에 repaint가 있으니까 . 그부분이 run으로 들어가면 실행이된다.
	while문을 run으로 이동
	//앞에 canvas를 붙여서 이벤트가 돌아가게 수정함
	*/
	public PackManEX() {
		setLayout(new BorderLayout());
		img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		
		canvas = new MyCanvas1();
		add(canvas);
		x = this.getWidth() / 2 -25;
		y = this.getHeight() / 2 - 25;
		
		System.out.println(this.getWidth()+","+this.getHeight() ); //좌표적용이 this라서 제대로 안됐던것. 여기엔 setSize가 없다.
		//창 크기는 TreadEX에서 설정하고 있다.
		/////////이 좌표를 새로 ThreadEX에 설정해준다.
		
		
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		/////////////////////////생성된 창을 마우스로 클릭하면 방향키전환 안먹힘. 캔버스 객체가 다른게 선택되어서? 아무튼 주의할것.
		//keyEvent
		canvas.addKeyListener(new KeyAdapter() { //앞에 canvas를 붙여서 이벤트가 돌아가게 수정함. 이걸 안하면 canvas에서 이벤트가 실행되지 않는다.
												//처음만들때 이걸 안붙여서 클릭하면 움직이지 않았었다. 
			public void keyReleased(KeyEvent ke) {
				int key = ke.getKeyCode();
				if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
					p=0; 
				}else if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
					p=2;
				}else if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
					p=4;
				}else if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
					p=6;
				}
			}
		});
		
		
		
		
	}
	public void run() {
		while(true) {
			
			canvas.repaint(); //Canvas가 객체 안에 있으니까.
			
			if(p%2==0) p++; //0->1 
			else p--; //1->0
			
			
			
			//좌표이동
			if(p==0 || p==1) { //왼쪽으로
				x-=5;
				if(x<=-50) {
					x=canvas.getWidth(); //캔버스 폭만큼
				}
			}else if(p==2 || p==3) { //오른쪽으로
				x+=5;
				if(x>=canvas.getWidth()) {
					x=-50;
				}
			}else if(p==4 || p==5) {
				y-=5;
				if(y<=-5) {
					y=canvas.getHeight();
				}
			}else if(p==6 || p==7) {
				y+=5;
				if(y>=canvas.getHeight()) {
					y=-50;
				}
			}
			
			
			try {
				Thread.sleep(150);
			}catch(Exception e) {}
		}
	}
	
	
	class MyCanvas1 extends Canvas{
		
		MyCanvas1(){
		}
		public void paint(Graphics g) {
			//			canvas					      img
			g.drawImage(img, x, y, x+50, y+50, 		p*50, 0, p*50+50, 50, this);
		}
		
	}
	

}
