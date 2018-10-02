package thread;

/**
 * Created by devsh on 2016. 11. 10..
 */
public class WaitNotifyExample {

	public static void main(String[] args) {
		DataBox dataBox = new DataBox();

		ProducerThread producerThread = new ProducerThread(dataBox);
		ConsumerThread consumerThread = new ConsumerThread(dataBox);

		producerThread.start();
		consumerThread.start();
	}
}
