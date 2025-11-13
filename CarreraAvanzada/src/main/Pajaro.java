package main;

import java.util.concurrent.Semaphore;



//Pajaro no puede empezar volando al reves. Conseguir que si el pajaro esta volando al contrario si el viento sopla a favor le reste velocidad y si sopla el contra le sume. Vease que si se da la vuelta y viento
//esta a favor la velocidad sea -5 en vez menos 10, y si esta en contra sea -15

public class Pajaro implements Runnable{
		
	private int velocidad = 3;
	private boolean volar = false;
	Semaphore tunel;
	private boolean volarARL;
	int distanciaRecorrida = 0;	
	
	
	public Pajaro() {
		super();
	}

	public void volar () {		
		int iniciarVolar = (int) (Math.random() * 10) + 1;
		
		if (iniciarVolar > 3 ) {
			this.volar = true;
			int volarAlContrario = (int) (Math.random() * 10) + 1;			
			if(volarAlContrario<4) {				
				this.velocidad = -10;
				this.distanciaRecorrida+=velocidad;
				volarARL = true;
				System.out.println("Oh no, pajaro esta volando en sentido contrario");
				System.out.println("Pajaro retrocedio a " + distanciaRecorrida + " metros");		
			}else {
				volarARL = false;
				this.velocidad = 10;
				System.out.println("Pajaro empezo a volar");
				this.distanciaRecorrida += velocidad;
				System.out.println("Avanzo " + distanciaRecorrida);
			}
			
		}else {
			System.out.println("Pajaro sigue caminando");
			this.velocidad = 3;
			this.distanciaRecorrida+=velocidad;
			System.out.println("Distancia recorrida " + distanciaRecorrida + " metros");
		}			
		
	}
	
	public boolean viento () {
		int direccionViento = (int) Math.random();
		boolean viento = false;
		if (direccionViento == 1) {
			viento = true;
			return viento;
		}else {
			return viento;
		}	
	}
	


	@Override
	public void run() {		
		for (int i = 0; i < 50; i++) {			
		
		//Tunel que empieza en el metro 20 y acaba en el 30	
			try {		
				
				if (i == 20)	{
					tunel.acquire();
					System.out.println("Pajaro entro en el tunel");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
				
			if (i == 30) {
				tunel.release();
				System.out.println("Pajaro salio del tunel");
			}
		//Carrera general	
			volar();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
