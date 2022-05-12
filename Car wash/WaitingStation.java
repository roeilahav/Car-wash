// roei lahav 315808469
// matam maman 21622149
package Exe2;

public class WaitingStation extends station {

	private String name;
	private int maxCars;
	
	public WaitingStation(stationManager manager, int maxCars)  
	{
		super(manager);
		name = "Waiting Station";
		this.maxCars = maxCars;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void getCars() {
		for(car car : cars)
			System.out.println(car);
		
	}
	public synchronized void stayInPlace(car c)
	{
		manager.MyEventOccured(new EventMessage(this,c.getName() + " is waiting at "));
		if(this.cars.size() == maxCars)
		{
			clear();
		}
	}
	public void clear()
	{
		try
		{
			Thread.sleep(500);
			while(this.cars.size()!=0)
			{
				Thread.sleep(100);
				removeCar(cars.get(0));
			}	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public String toString() 
	{
		return name;
	}

}
