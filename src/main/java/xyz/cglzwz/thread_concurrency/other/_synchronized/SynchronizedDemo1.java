package xyz.cglzwz.thread_concurrency.other._synchronized;

public class SynchronizedDemo1 implements Runnable {
	static SynchronizedDemo1 instance = new SynchronizedDemo1();
	
	@Override
	public void run() {
		method1();
	}
	
	public synchronized void method1()  {
		System.out.println(Thread.currentThread().getName() + "开始访问");
		try {
			// 休眠下，更好看结果
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + "结束访问");
	}
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(instance, "t1");
		Thread t2 = new Thread(instance, "t2");
		
		t1.start();
		t2.start();

	}

}
