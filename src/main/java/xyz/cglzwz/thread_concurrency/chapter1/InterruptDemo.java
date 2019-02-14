package xyz.cglzwz.thread_concurrency.chapter1;

public class InterruptDemo {

	public static void main(String[] args) throws InterruptedException {
		Runnable r = () -> {
			System.out.println("调用了业务逻辑部分");
			Thread.currentThread().interrupt();
			// isInterrupted()方法不会清除中断状态
			System.out.println(Thread.currentThread().isInterrupted());
			// interrupted()方法是静态类方法，会清除中断状态
			System.out.println(Thread.currentThread().interrupted());
			System.out.println(Thread.currentThread().interrupted());
		};
		
		Thread t1 = new Thread(r, "t1");
		t1.start();
	}
}
