
package Exe2;

public class MyThread implements Runnable {
	private String name;
	public MyThread(String name)
	{
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.printf("Thread %s started\n", name);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.printf("Thread %s crush\n", name);
		}
		System.out.printf("Thread %s ended\n", name);

		
	}

}
