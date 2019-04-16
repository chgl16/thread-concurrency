package xyz.cglzwz.thread_concurrency.other._synchronized;

/**
 * count++三步，并发条件不同步会有问题
 * synchronized(new Object())也是不行的，锁不一致
 * 
 * @author chgl16
 * @date 2019-04-05
 */
public class ConcurrentProblem {
	static int count = 0;
	
	static Object o = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		Runnable r = () -> {
			for (int i = 0; i < 10000; ++i) {
				synchronized (o) {
					count++;
				}	
			}	
			
		};
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(count);
	}
}
