
package Exe2;

public class car implements Runnable{
	public generalWashingStation gw;
	private String name;
	static int carId = 200;
	station location;

	
	
	public car(generalWashingStation gw)
	{
		this.gw = gw;
		this.name = "Car " + carId;
		carId++;
		location = null;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		if(location == null)
			return name + ", loc: not found";
		else 
			return name + ", location: " + location;	
	}
	public synchronized void moveCar(station source, station dest)
	{	
		source.removeCar(this);
		this.location= dest;
		dest.addCar(this);
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(100);
			((WashingStation)location).EnterToPosition(this);
			moveCar(location, gw.getB());
			Thread.sleep(100);
			((WashingStation)location).EnterToPosition(this);
			moveCar(location, gw.getC());
			Thread.sleep(100);
			((WaitingStation)location).stayInPlace(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
