

public class ThreadTest2Main {

	public ThreadTest2Main() {
	}

	public static void main(String[] args) {
		//Runnable �������̽� ��ӹ��� Ŭ������ ��ü�� �����ͼ� ����
		ThreadTest2 t3 = new ThreadTest2("first");
		ThreadTest2 t4 = new ThreadTest2("second");
		
		//Thread�� �־��ش�. Thread ��ü ����
		Thread tt3 = new Thread(t3);
		Thread tt4 = new Thread(t4);
		
		
		tt4.setPriority(Thread.MAX_PRIORITY);//�켱���� ���� .. �� Ŭ�������� ��������ʴµ�?
		
		tt3.start(); //Thread��ü�� start();�� ������ ����
		tt4.start();
		
	}

}
