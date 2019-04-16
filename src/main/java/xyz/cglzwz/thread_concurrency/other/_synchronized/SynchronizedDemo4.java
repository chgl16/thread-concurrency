package xyz.cglzwz.thread_concurrency.other._synchronized;

public class SynchronizedDemo4 implements Runnable {
	static SynchronizedDemo4 instance = new SynchronizedDemo4();
	
	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("t1"))
			method1();
		else 
			method2();
	}
	
	public synchronized void method1()  {
		System.out.println(Thread.currentThread().getName() + "开始访问1");
		try {
			// 休眠下，更好看结果
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + "结束访问1");
	}
	
	public void method2()  {
		System.out.println(Thread.currentThread().getName() + "开始访问2");
		try {
			// 休眠下，更好看结果
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + "结束访问2");
	}
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(instance, "t1");
		Thread t2 = new Thread(instance, "t2");
		
		t1.start();
		t2.start();

	}

}
