package xyz.cglzwz.thread_concurrency.other._synchronized;

/**
 * 
 * @author chgl16
 * @date 2019-04-08
 * 
 * 判断可重入性的粒度： 递归调用
 */

public class SynchronizedReenterable1 {
	static int a;
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				method1();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				method2();
			}
		});
		
		t1.start();
		t2.start();

	}
	
	public static synchronized void method1() {
		if (a < 5) {
			System.out.println("method1 a = " + a++);
			method1();	
		}
	}
	
	public static synchronized void method2() {
		System.out.println("method2");
	}
	
}
