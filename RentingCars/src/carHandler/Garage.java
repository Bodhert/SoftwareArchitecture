package carHandler;
import java.util.ArrayList;
import java.util.List;

public class Garage 
{
	private static Garage garageInstance; 
	private List<Car> garage;
	
	private Garage()
	{
		garage = new ArrayList<>();
	}
	
	public static Garage getGarage()
	{
		if(garageInstance == null)
			garageInstance = new Garage();
		
		return garageInstance;
	}
	
	public void addCar(Car car)
	{
		garage.add(car);
	}
	
	public void removeCar(Car car)
	{
		garage.remove(car);
	}
	
	public  int garageSize()
	{
		return garage.size();
	}
}
