package main;

import java.util.concurrent.Semaphore;

public class Main {
		
	//Carrera de tortugas, que avanzan 1 metro por segundo. Llegado cierto punto de la carrera hay un tunel al que solo puede acceder una tortuga a la vez. Se usa la clase que da java Semaphore y se usan los
	//metodos adquire() y release()	
	
	
	
	
	
	
	
	
	
	
	public static void main (String [] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore (1);
		Tortuga trotuga = new Tortuga("Trotuga", semaphore);
		Tortuga julian = new Tortuga("Julian", semaphore);
		Tortuga ramon = new Tortuga("Ramon", semaphore);
		
		Thread tortu1 =new Thread(trotuga);
		Thread tortu2 =new Thread(julian);
		Thread tortu3 =new Thread(ramon);
		
		tortu1.start();
		tortu2.start();
		tortu3.start();
		
		
			
		
	}

}
