package xyz.cglzwz.thread_concurrency.chapter2;

public class SynchronizedDemo {

	private static ID id = new ID(); 
	
	public static void main(String[] args) {
		Runnable r = new Runnable() {
	
			@Override
			public void run() {
				for (int i = 0; i < 10; ++i) {
					System.out.println(Thread.currentThread().getName() + ":" +  SynchronizedDemo.id.getID());
				}
			}
		};
		
		Thread t1 = new Thread(r, "t1");     
		Thread t2 = new Thread(r, "t2");
		
		t1.start();
		t2.start();
		
		
		for (int i = 0; i < 10; ++i) {
			System.out.println("main:" + id.getID());
		}
	}
}

class ID {
	private int count;
	
	public synchronized int getID() {
		return count++;
	}
}