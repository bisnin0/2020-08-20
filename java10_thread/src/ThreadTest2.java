//�����带 ��ӹ��� ���ϸ� Runnable�������̽��� ��ӹ޾Ƽ� Ȱ���϶�.
public class ThreadTest2 implements Runnable{
	int i=0;
	String title;
	public ThreadTest2() {
	}
	
	public ThreadTest2(String title) {
		this.title = title;
	}
	
	//¦���� ���
	public void run() {
		for(int i=2; i<=Integer.MAX_VALUE; i+=2) //Int�� ���� ū��������
			System.out.println(title+"="+i);
	}
	
}
