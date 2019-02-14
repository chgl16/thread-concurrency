package xyz.cglzwz.thread_concurrency.chapter1;

public class SleepDemo {

	public static void main(String[] args) {
		Runnable r = () -> {
			String name = Thread.currentThread().getName();
			int count = 0;
			while (!Thread.interrupted()) {
				System.out.println(name + ":" + count++);
			}
			
		};
		
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");
		t1.start();
		t2.start();
		
		try {
			// 当前线程睡眠1millis
			Thread.sleep(1);
		} catch (InterruptedException e) {
			//
		}
		t1.interrupt();
		t2.interrupt();
	}
}
