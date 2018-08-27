package app;
import java.util.ArrayList;
import java.util.List;
import transactionHelper.*;
import java.util.Scanner;

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
	
	public void ClientLogic(String id)
	{
		System.out.println("ingreseId:");
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
	}
	
	public void businnesLogic()
	{
		getCommand();
		while(!command.equalsIgnoreCase("F"))
		{
//			System.out.println("holiwis");
			if(!isValidCommand()) System.out.println("comando no reconocido");
			else
			{
				if(command.equalsIgnoreCase("C"))
				{
					System.out.println("ingrese el id del cliente");
					String id = scanner.next();
					ClientLogic(id);
				}
			}
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
