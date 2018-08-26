package app;
import carHandler.Car;
import carHandler.FamilyCar;
import carHandler.Garage;

public class ConsoleApp 
{

	
	public static void main(String[] args) 
	{
		Car test1 = new FamilyCar("213", "232", "dos", 1600, 4, 1, "regular");
		Car test2 = new FamilyCar("2133", "2332", "dofs", 1600, 4, 1, "regularpan");
		Garage garage = Garage.getGarage();
		
		garage.addCar(test1);
		garage.addCar(test2);		
//		garage.printGarage();
		garage.removeCar(test2);
		garage.removeCar(test2);
//		garage.printGarage();
	}

}
