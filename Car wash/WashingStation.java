// roei lahav 315808469
// matam maman 21622149
package Exe2;

import java.util.concurrent.Semaphore;

public class WashingStation extends station 
{
	private Semaphore washingPositions;
	static int carId = 0;
	private String name; 
	private double washTime;
	
	
	
	public WashingStation(stationManager manager, int washingPositions, double washingTime)  
	{
		super(manager);
		carId++;
		name = "Washing station " + carId;
		this.washTime = washingTime;
		this.washingPositions = new Semaphore(washingPositions,true);
	}


	@Override
	public String getName() 
	{
		return name;
		
	}
	public String toString() 
	{
		return name;
		
	}
	
	public void EnterToPosition(car c) 
	{
		try {
			washingPositions.acquire();
			manager.MyEventOccured(new EventMessage(this,c.getName()+" is benn washed at "));
			Thread.sleep((long) washTime);
			washingPositions.release();
		} catch (Exception e) {
		}
		manager.MyEventOccured(new EventMessage(this,c.getName()+" ended his wash at "));
	}

	@Override
	public void getCars() {
		System.out.printf("cars in %s:\n", getName());
		for(car car : cars)
			System.out.println(car);
		
	}
}
