class ATM extends Thread{ //ATMŬ���� ����
	private int deposiMoney = 10000; //���ݾ�
	
//	 ����ȭ ��
//	public void run() {
//		for(int i=1; i<7; i++) {
//			try {
//				Thread.sleep(1000);
//			}catch(Exception e) {}
//			outputMoney();
//		}
//	}
	
	
	//1. run()�޼ҵ忡 ����ȭ
//	public synchronized void run() {
//		for(int i=1; i<7; i++) {
//			try {
//				Thread.sleep(1000);
//			}catch(Exception e) {}
//			outputMoney();
//		}
//	}//�̷��� �Ǹ� mother�� ���� ����� �� �ϰ� son�� ���߿� ����� �ϰԵȴ�. 

	
	//2. �޼ҵ� ������ ����ȭ����
	public void run() {
		synchronized(this) {
			for(int i=1; i<7; i++) {
				try {
					Thread.sleep(1000);
				}catch(Exception e) {}
				outputMoney();
			}
		}
	}//����� ���� ����. ������ �۾��� �� ������ �ٸ��� �۾��� ���۵ȴ�.
	
	public void outputMoney() {
		if(deposiMoney>0) {
			deposiMoney-=1000; 
			
			//�̺κж����� ��ũ�� �ʿ�. ��ü�ϳ��� �θ��� ���� ������ ó���� mother�� -1000�� �߰� �ܾ��� ��µǱ� ������ son�� ����� �ع����� �� �� ����� 8000�� �Ȱ�.
			//���� ����ϱ����� �ٸ� �����尡 �����°Ͷ����� ��°��� ���������� ǥ�ð� ���� �ʴ� ����߻�
			//���ʿ��� �������̸� �ٸ� ������� ���� ���ϰ�, ������ ������ �ٸ����� ����ǰԲ� �ϴ°� ����ȭ(��ũ�γ������)��� �Ѵ�.
			//����ȭ�� run()�� �����Ѵ�.
			
			//���� �������� ������ �̸� ���ϱ�
//			System.out.println("�ܾ�"+deposiMoney); //�̷����ϸ� ���� ����ߴ��� Ȯ�� ����
			System.out.println(Thread.currentThread().getName()+"�ܾ�"+deposiMoney); //������ �̸� ���
		}else {
			System.out.println(Thread.currentThread().getName()+"�ܾ��� �����մϴ�.");
		}
	}
}



public class SynchronizedTest {

	public SynchronizedTest() {
	}

	public static void main(String[] args) {
		ATM atm = new ATM(); //ATMŬ���� ��ü�θ���
		Thread mother = new Thread(atm, "mother"); //������ ���� ���� .. //�׳� ������ �ܾ׸� ������ ���� ����ߴ��� �𸥴�. �׷��� ������ �̸� ����
		Thread son = new Thread(atm, "son");
		
		mother.start();
		son.start();
		
	}

}
