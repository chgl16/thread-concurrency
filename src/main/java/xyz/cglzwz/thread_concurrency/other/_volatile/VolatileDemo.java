package xyz.cglzwz.thread_concurrency.other._volatile;

/**
 * 验证volatile关键字的可见性
 * volatile只能保证他们操作的count是同一块内存，但依然可能出现写入脏数据的情况。
 * @author chgl16
 * @date 2019-04-16
 */
public class VolatileDemo {
	volatile static int count;
	
	public static void main(String[] args) throws InterruptedException {
		Runnable r = () -> {
			for (int i = 0; i < 10000; ++i)
				count++;
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
