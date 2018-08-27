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
	
	public void printCarsSpecs()
	{
		int index= 0;
		for(Car temp : garage)
		{
			System.out.println("item #: " + index++);
			System.out.println("Modelo: "+  temp.getMarca());
			System.out.println("cilindraje: " +  temp.getCilindraje());
			System.out.println("Puestos: " +  temp.getNroDePuestos());
			System.out.println("Precio por hora: " +  temp.getValorHora());
			
		}
	}
	
	public Car getCar(int index)
	{
		return garage.get(index);
	}
	
	public  int garageSize()
	{
		return garage.size();
	}
}
