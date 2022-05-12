
package Exe2;

public class stationManager implements Mylistener {

	private String msg;
	private long start;
	private double currentTime;
	
	@Override
	public synchronized void MyEventOccured(EventMessage event) 
	{
		currentTime = ((int)(System.currentTimeMillis() - start)/10)/100.0;
		if(currentTime==0)
			msg = "in 0 seconds "+event.getMessage() + event.getSource() + "\n";
		else
			msg = "in "+currentTime+" seconds "+event.getMessage() + event.getSource() + "\n";
		System.out.print(msg);
	}
	
	public synchronized void startTime() { start = System.currentTimeMillis(); }
	

}
