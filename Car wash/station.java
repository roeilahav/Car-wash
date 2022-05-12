
package Exe2;

import java.util.ArrayList;

public abstract class station 
{
	
	protected ArrayList <car> cars;
	stationManager manager;
	
	
	public station(stationManager manager) 
	{
		cars = new ArrayList<>();
		this.manager = manager; 
	}
	
	public void addCar(car c)
	{
		cars.add(c);
		manager.MyEventOccured(new EventMessage(this,c.getName() + " has entered "));
		c.location = this;
		
	}
	public void removeCar(car c) 
	{
		cars.remove(c);
		manager.MyEventOccured(new EventMessage(this,c.getName() + " has left "));
	}
	
	public abstract String getName();
	public abstract void getCars();
}
