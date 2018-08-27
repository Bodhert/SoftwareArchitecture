package transactionHelper;

import java.util.Calendar;
import java.util.Date;

import carHandler.Car;

public class RentarTransaccion
{
	String id;
	Date OutDate;
	Date inDate;
	Car car;
	Cliente client;
	double total;
	
	
	public RentarTransaccion(String id, Date outDate, Date inDate,
							Car car, Cliente client, double total) 
	{
		this.id = id;
		this.OutDate = outDate;
		this.inDate = inDate;
		this.car = car;
		this.client = client;
		this.total = total;
	}
	
	

}
