

public class ThreadTest1Main {

	public ThreadTest1Main() {
	}

	public static void main(String[] args) {
		ThreadTest1 t1 = new ThreadTest1("ù��°");
//		t1.numOutput();
		t1.start(); // ������ ��� start();
		ThreadTest1 t2 = new ThreadTest1("�ι���");
//		t2.numOutput();
		t2.start();
		
	}

}
