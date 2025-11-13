package main;

import java.util.concurrent.Semaphore;

public class Carrera implements Runnable{
	
	
	private Semaphore tunel;
	private Animal animal;
	
	public Carrera(Semaphore tunel, Animal animal) {
		this.tunel = tunel;
		this.animal = animal;
	}

	
	public void creadorRaza() {	
		
	}
	
	
	@Override
	public void run() {		
		for (int i=0; i<50; i++) {	
			try {					
				if (i == 20)	{
					tunel.acquire();
					synchronized(System.out) {
				        System.out.println(animal.getNombre() + " Entró en el túnel");
				    }
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
				
			if (i == 30) {
				tunel.release();
				synchronized(System.out) {
			        System.out.println(animal.getNombre() + " Salio de el túnel");
			    }
			}
			animal.correr();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
