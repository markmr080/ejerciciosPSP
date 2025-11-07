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
		
		for (int i = 0; i<35; i++) {			
			if (i==20) {
				if (semaphore.tryAcquire()==false) {
				     System.out.println(this.nombre + " está esperando para entrar al túnel...");
				       try {
				         semaphore.acquire(); 
				         System.out.println(this.nombre + " adquirió el ticket único y entró al túnel");			            
				        }catch (InterruptedException e) {
				           e.printStackTrace();
				        }
				} else 
				  System.out.println(this.nombre + " adquirió el ticket único y entró al túnel");
				}	
			
				if(i==30) {
					semaphore.release();
					System.out.println(this.nombre + " salio del tunel. ¡Se acerca la recta final!");
					System.out.println("");
			}
			correr(); 
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(this.nombre + " ha terminado la carrera");			
	}
			
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void correr() {
		this.distanciaRecorrida = this.distanciaRecorrida + this.velocidad;
		System.out.println(nombre + " lleva recorridos " + distanciaRecorrida + " metros");
	}

}
