package Thread_Study.fail;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class PackManEX2 extends JPanel implements Runnable{
	Image img;
	int x, y;
	int p=0;
	MyCanvas1 canvas;
	
	
	public PackManEX2() {
//		setSize(500,500);
		img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		canvas = new MyCanvas1();
		add(canvas);
		x = this.getWidth() / 2 -25;
		y = this.getHeight() / 2 - 25;
		
		
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//keyEvent
		addKeyListener(new KeyAdapter() {
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
		Thread t = new Thread(this);
		t.start();
	}
	
	
	class MyCanvas1 extends Canvas{
		
		MyCanvas1(){
		}
		public void paint(Graphics g) {
			//			canvas					      img
			g.drawImage(img, x, y, x+50, y+50, 		p*50, 0, p*50+50, 50, this);
		}
		
	}
	
	public void run() {
		while(true) {
			
			canvas.repaint(); //Canvas가 객체 안에 있으니까.
			if(p%2==0) p++; //0->1 //규칙이 있으니까 위에껄 계속해서 조건 식 안세우고 이렇게 바꾸면 간단하고 좋다. 이런걸 이해
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
	
	
//	public static void main(String[] args) {
//		PackManEX2 pp = new PackManEX2();
//		Thread p1 = new Thread(pp);
//		p1.start();
//	}

}
