package xyz.cglzwz.thread_concurrency.other._synchronized;

/**
 * 死锁
 * @author chgl16
 * @date 2019-04-05
 */

public class Deadlock {

	private static Object resourceA = new Object();
	private static Object resourceB = new Object();
	
	public static void main(String[] args) {
		Thread t1 = new Thread("t1") {
			@Override 
			public void run() {
				synchronized(resourceA) {
					System.out.println(Thread.currentThread().getName() + " 获取到了 resourceA");
					try {
						// 休眠一秒，以保证线程B获取到了resourceB
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized(resourceB) {
						System.out.println(Thread.currentThread().getName() + " 获取到了 resourceB");
					}
				}
			}
		};
		
		Thread t2 = new Thread("t2") {
			@Override 
			public void run() {
				synchronized(resourceB) {
					System.out.println(Thread.currentThread().getName() + " 获取到了 resourceB");
					try {
						// 休眠一秒，以保证线程A获取到了resourceA
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized(resourceA) {
						System.out.println(Thread.currentThread().getName() + " 获取到了 resourceA");
					}
				}
			}
		};

		t1.start();
		t2.start();
	}

}
