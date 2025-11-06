package main;

import java.util.concurrent.Semaphore;

public class Tortuga implements Runnable{
	
	private String nombre;
	private int velocidad;
	private int distanciaRecorrida;
	Semaphore semaphore;
	
	public Tortuga(String nombre, Semaphore semanphore) {
		this.nombre = nombre;
		this.distanciaRecorrida = 0;
		this.velocidad = 1;
		this.semaphore = semanphore;		
	}


	@Override
	public void run() {
		
		for (int i = 0; i<20; i++) {			
			if (i==10) {
					try {
						semaphore.acquire();
						System.out.println(nombre + " entro al tunel");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}else if(i==16) {
					semaphore.release();
					System.out.println(nombre + " salio del tunel");
			}
			correr();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
					
	}
			
	public void correr() {
		this.distanciaRecorrida = this.distanciaRecorrida + this.velocidad;
		System.out.println(nombre + " lleva recorridos " + distanciaRecorrida + " metros");
	}

}
