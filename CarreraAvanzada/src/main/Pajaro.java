package main;

import java.util.concurrent.Semaphore;



//Pajaro no puede empezar volando al reves. Conseguir que si el pajaro esta volando al contrario si el viento sopla a favor le reste velocidad y si sopla el contra le sume. Vease que si se da la vuelta y viento
//esta a favor la velocidad sea -5 en vez menos 10, y si esta en contra sea -15

public class Pajaro implements Runnable{
	
	
	private int velocidad = 3;
	private boolean volar = false;
	Semaphore tunel;
	private boolean volarEnSentidoContrario;
	int distanciaRecorrida = 0;	
	
	
	public Pajaro(Semaphore tunel) {
		super();
		this.tunel = tunel;
	}

	public void volar () {		
		int iniciarVolar = (int) (Math.random() * 10) + 1;
		
		if (iniciarVolar > 3 ) {
			this.volar = true;
		}		
		if (volar == true) {
			this.velocidad = 10;
			System.out.println("Pajaro empezo a volar");
			
			int volarAlContrario = (int) (Math.random() * 10) + 1;
			
			if(volarAlContrario<4) {
				this.velocidad = -10;
				volarEnSentidoContrario = true;
				System.out.println("Oh no, pajaro esta volando en sentido contrario");
			}else {
				volarEnSentidoContrario = false;
			}
		}else {
			System.out.println("Pajaro sigue caminando");
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
		for (int i = 0; i < 100; i++) {			
			//Carrera general	
			volar();
			viento();
		//Si el viento esta a favor y el pajaro vuela se añade a la velocidad, si esta volando al contrario le resta 5	
			if (viento()==true && volar) {
				distanciaRecorrida += velocidad + 5;
				System.out.println("Pajaro lleva a" + distanciaRecorrida);
				
				if (volarEnSentidoContrario && volar) {
					distanciaRecorrida+=5;
					System.out.println("Pajaro lleva b" + distanciaRecorrida);
				}
		//Si el viento esta en contra y el pajaro vuelta se resta a la velocidad, si esta volando al contrario le suma velocidad 		
			}else if (viento()==false && volar) {
				distanciaRecorrida +=velocidad - 5;
				System.out.println("Pajaro lleva c" + distanciaRecorrida);
				
				if (!volarEnSentidoContrario && volar) {
					distanciaRecorrida-=5;
					System.out.println("Pajaro lleva d" + distanciaRecorrida);
				}
			}	
		//Tunel que empieza en el metro 20 y acaba en el 30	
			try {
				
			if (i == 20)	
				tunel.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			if (i == 30) {
				tunel.release();
			}
		}
		
	}
}
