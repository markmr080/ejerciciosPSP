package main;

import java.util.concurrent.Semaphore;

public class Main {
		
	//Carrera de tortugas, que avanzan 1 metro por segundo. Llegado cierto punto de la carrera hay un tunel al que solo puede acceder una tortuga a la vez. Se usa la clase que da java Semaphore y se usan los
	//metodos adquire() y release()	
	
	public static void main (String [] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore (1);
		
		Thread tortu1 =new Thread(new Tortuga("Ramon", semaphore));
		Thread tortu2 =new Thread(new Tortuga("Julian", semaphore));
		Thread tortu3 =new Thread(new Tortuga("Trotuga", semaphore));
		
		tortu1.start();
		tortu2.start();
		tortu3.start();
		
		
			
		
	}

}
