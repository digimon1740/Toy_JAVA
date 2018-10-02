/**
 * Created by devsh on 2016. 10. 15..
 */
public class CapsuleTest {

	private int count = 0;

	public void incrementCount() {
		this.count++;
		System.out.println(this.count);

		int localCount = 0;
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(10 * 1000);
					System.out.print(localCount);
					for (int i = 0; i < 10; i++)
						System.out.println("thread count = "+i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		th.start();
		System.out.println("메서드 끝남");

//		Thread th1 = new Thread(() -> System.out.print("안녕하세요"));
//		th1.start();
	}

//	public void incrementCount() {
//		int count = 0;
//		System.out.println(count++);
//	}


	public static void main(String[] args) {
		CapsuleTest capsuleTest = new CapsuleTest();
		for (int i = 0; i < 10; i++) {
			capsuleTest.incrementCount();
		}

	}
}
