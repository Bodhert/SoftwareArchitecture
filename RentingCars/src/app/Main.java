package app;

import it.sauronsoftware.junique.AlreadyLockedException;
import it.sauronsoftware.junique.JUnique;

public class Main {
	
	static ConsoleApp app = new ConsoleApp();
	public static void main(String[] args) {
		final String name = "aplication_Unica";
		boolean alreadyRuning;
		try
		{
			JUnique.acquireLock(name);
			alreadyRuning = false;
		}
		catch (AlreadyLockedException e) 
		{
			alreadyRuning = true;
		}
		if (!alreadyRuning) 
		{
			app.businnesLogic();
			System.out.println("Programa Terminado");
		}
		else
		{
			System.out.println("ya esta corriendo el programa ");
		}
		

	}

}
