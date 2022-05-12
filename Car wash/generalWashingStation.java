// roei lahav 315808469
// matam maman 21622149
package Exe2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class generalWashingStation {
	
	private stationManager manager;
	private ArrayList<car> carsList;
	
	private WashingStation A,B;
	private WaitingStation C;
	
	private int numOfPositionsAtA;
	private int numOfPositionsAtB;
	private int carsAmount;
	
	private double arrivalDuration;
	private double washingDuration;
	
	
	
	public generalWashingStation()
	{
		manager = new stationManager();
		carsList = new ArrayList<>();
	}
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)
	{
		generalWashingStation gws = new generalWashingStation();
		
		System.out.print("Enter a number of Washing positions in Station A: ");
		gws.setNumOfPositionsAtA(sc.nextInt());
		
		System.out.print("Enter a number of Washing positions in Station B: ");
		gws.setNumOfPositionsAtB(sc.nextInt());
		
		System.out.print("Enter amount of cars:");
		gws.setCarsAmount(sc.nextInt());
		
		System.out.print("Enter an average arrival time in seconds:");
		gws.setarrivalDuration(sc.nextDouble());
		
		System.out.print("Enter an average washing time in seconds:");
		gws.setwashingDuration(sc.nextDouble());
		
		gws.wash();
		sc.close();			
	}
	
	public int getCarsAmount() {return carsAmount;}
	
	public void setCarsAmount(int carsAmount) {this.carsAmount = carsAmount;}
	
	private double PoissonDist(double lamda)
	{
		double poiss = -1*(Math.log(Math.random())/lamda);
		return poiss;	
	}
	public void setarrivalDuration(double arrivingTime)	{this.arrivalDuration = PoissonDist(arrivingTime)*1000;}
	
	public stationManager getManager() {return manager;}
	
	public ArrayList<car> getCarsList() {return carsList;}
	
	public void setNumOfPositionsAtA(int numOfPositionsAtA) {this.numOfPositionsAtA = numOfPositionsAtA;}
	
	public void setNumOfPositionsAtB(int numOfPositionsAtB) {this.numOfPositionsAtB = numOfPositionsAtB;}
	
	public void setwashingDuration(double washingDuration) {this.washingDuration = PoissonDist(washingDuration)*1000;}
	
	public WashingStation getA() {	
		return A;
	}
	
	public WashingStation getB() {
		return B;
	}
	
	public WaitingStation getC() {	
		return C;
	}
	
	public String toString() { 
		return "Washing station";
	}
	
	public void wash()
	{	
		A = new WashingStation(manager, numOfPositionsAtA,washingDuration );
		B = new WashingStation(manager, numOfPositionsAtB,washingDuration);		
		C = new WaitingStation(manager,carsAmount);
		manager.startTime();
		ExecutorService es = Executors.newFixedThreadPool(carsAmount);
		
		for(int i=0; i< carsAmount; i++)
		{
			car c = new car(this);
			try {
				Thread.sleep((long)arrivalDuration);
			} catch (Exception e) {
				e.printStackTrace();
			}
			carsList.add(c);
			A.addCar(c);
			es.execute(c);
		}
		es.shutdown();
		
		while (!es.isTerminated()) {}
		System.out.println();
		manager.MyEventOccured(new EventMessage(this,"All of the cars have finished the wash and left the washing station "));
		//manager.printLog();
	}
}
