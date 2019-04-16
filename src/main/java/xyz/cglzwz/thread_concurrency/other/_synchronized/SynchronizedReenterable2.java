package xyz.cglzwz.thread_concurrency.other._synchronized;

/**
 * 
 * @author chgl16
 * @date 2019-04-08
 * 
 * 判断可重入性的粒度： 调用同类其他方法
 */

public class SynchronizedReenterable2 {
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
				method4();
			}
		});
		
		t1.start();
		t2.start();

	}
	
	public static synchronized void method1() {
		System.out.println("method1");
		method2();
	}
	
	public static synchronized void method2() {
		System.out.println("method2");
		method3();
	}
	
	public static synchronized void method3() {
		System.out.println("method3");
	}
	
	public static synchronized void method4() {
		System.out.println("method4（独立对比的一个方法）");
	}
}
