package xyz.cglzwz.thread_concurrency.chapter1;

public class JoinDemo {
	private static int count = 0;
	
	public static void main(String[] args) {
		Runnable r = () -> { 
			System.out.println("处理工作线程的业务");
			count ++;
		};
		Thread t1 = new Thread(r);
		t1.start();
	
		try {
			t1.join();
		} catch (InterruptedException e) {
			// 当这条工作线程被其他线程中断就会抛出InterruptedException异常
			e.printStackTrace();
		}
		
		System.out.println("主线程等待工作线程结束然后处理结果: " + count);

	}
}
