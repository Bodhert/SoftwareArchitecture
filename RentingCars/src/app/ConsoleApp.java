package app;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import transactionHelper.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import carHandler.Car;
import carHandler.FamilyCar;
import carHandler.Garage;

public class ConsoleApp 
{
	private String command = "";
	private Scanner scanner = new Scanner(System.in);
	private List<Cliente> clientes;
	private List<RentarTransaccion> transacciones;
	private Cliente currentClient;
	private Garage garage;
	
	void storeCars()
	{
		Car test1 = new FamilyCar("123", "Renault", "mecanico", 1600, 4, 10, "completo");
		Car test2 = new FamilyCar("234", "Fiat", "automatico", 1200, 4, 10, "contra choques");
		Car test3 = new FamilyCar("456", "Lada", "mecanico", 2000, 4, 10, "completo");
		
		garage.addCar(test1);
		garage.addCar(test2);
		garage.addCar(test3);
	}
	
	void getCommand()
	{
		command = scanner.next();
	}
	
	void printOptions()
	{
		System.out.println("Presiona");
		System.out.println("c para ingresar o buscar cliente");
		System.out.println("t para Realizar Transaccion carro");
		System.out.println("f para finalizar");
		
		if(currentClient != null)System.out.println("Transando con: " + currentClient.getNombre());
		else System.out.println("cliente por asignar"); 
	}
	
	
	public Cliente getClient(String id)
	{
		 for(Cliente temp : clientes)
		 {
	        if(temp.getId() != null && temp.getId().equals(id))
	        {
	        	return temp;
	        }
		 }
		 return null;
	}
	
	
	public void TransactionLogic(Cliente client, Car car)
	{
		
		System.out.println("Ingrese la fecha de devolucion");
		
		// no estoy validando que la fecha este un rango

		int anioDevoulcio, mes, dia;
		System.out.println("ingrese el anio");
		anioDevoulcio = scanner.nextInt();
		System.out.println("ingrese el mes");
		mes = scanner.nextInt();
		System.out.println("ingrese el dia");
		dia = scanner.nextInt();
		
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		String out_date = dia + " " + mes + " " + anioDevoulcio;

		try {
		    Date date1 = new Date();
		    Date date2 = myFormat.parse(out_date);
		    long diff = date2.getTime() - date1.getTime();
		    int horas = (int) TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
		    System.out.println ("Horas: " + horas);
		    transacciones.add(new RentarTransaccion(client.getId(),date1, date2, 
		    					car, client, horas*car.getValorHora()));
		    
		    System.out.println("Transanccion exitosa ");
		    System.out.println("Precio$: " + horas*car.getValorHora() );
		} catch (ParseException e) {
			System.out.println("fecha en mal formato");
		    e.printStackTrace();
		}
		
		
		
	}
	
	public void ClientLogic(String id)
	{
		String nombre;
		boolean is_vip;
		currentClient = getClient(id);
		if(currentClient == null)
		{
			System.out.println("cliente no encontrado");
			System.out.println("ingrese nombre");
			nombre = scanner.next();
			currentClient = new Cliente(id, nombre, true); // for now everyone is vip
			clientes.add(currentClient);
		}
		
		System.out.println("cual desea rentar: ");
		garage.printCarsSpecs();
		int numCar = scanner.nextInt();
		// no esta checkeando si existe el carro o no 
		Car toRent = garage.getCar(numCar);
		garage.removeCar(toRent);
		TransactionLogic(currentClient, toRent);
		
	}
	
	public void businnesLogic()
	{
		getCommand();
		int i = 0;
		while(!command.equalsIgnoreCase("F"))
		{
			if(!isValidCommand()) System.out.println("comando no reconocido");
			else
			{
				if(command.equalsIgnoreCase("C"))
				{
					System.out.println("ingrese el id del cliente");
					String id = scanner.next();
					ClientLogic(id);
				}
				else if(command.equalsIgnoreCase("T") && currentClient != null)
				{
					garage.printCarsSpecs();
					int index = 0;
					index = scanner.nextInt();
					Car temp = garage.getCar(index);
					TransactionLogic(currentClient, temp);
					garage.removeCar(temp);
				}
			}
			printOptions();
			getCommand();
		}
	}
	
	boolean isValidCommand()
	{
		return command.equalsIgnoreCase("C")|| command.equalsIgnoreCase("T") ||
				command.equalsIgnoreCase("F");
	}
	
	public ConsoleApp()
	{
		clientes = new ArrayList<>();
		transacciones = new ArrayList<>();
 		garage = Garage.getGarage();
		storeCars();
		printOptions();
	}
	

}
