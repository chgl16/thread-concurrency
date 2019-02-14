package xyz.cglzwz.thread_concurrency.chapter1;

public class DaemonDemo {

	public static void main(String[] args) {
		boolean isDaemon = args.length != 0;
		Runnable r = new Runnable() {
			@Override
			public void run() {
				Thread thd = Thread.currentThread();
			
				System.out.printf("%s is %salive and in %s "
							+ "state\n", thd.getName(), thd.isAlive() ? "" : "not ", thd.getState());
			}
		};
		
		Thread t1 = new Thread(r, "thd1");
		t1.setDaemon(isDaemon);
		System.out.printf("%s is %salive and in %s "
				+ "state\n", t1.getName(), t1.isAlive() ? "" : "not ", t1.getState());
		
		
		Thread t2 = new Thread(r, "thd2");
		t2.setDaemon(isDaemon);
		System.out.printf("%s is %salive and in %s "
				+ "state\n", t2.getName(), t2.isAlive() ? "" : "not ", t2.getState());
	
		t1.start();
		t2.start();
	}
}
