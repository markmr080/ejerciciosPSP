package main;

public class Alumno implements Runnable {
	

	String mensaje;
	
	public Alumno (String nombre) {
		if (nombre.toLowerCase().startsWith("a")) {
			this.mensaje = "No quiero empezar con la letra A";
		}else {
			this.mensaje= "Hola soy " + nombre + " y este es mi mensaje numero: ";	
		}
	}

	@Override
	public void run() {				
		for(int i= 0; i<5; i++) {			
		  if (this.mensaje.equals("No quiero empezar con la letra A")) {
			  System.out.println(mensaje);
			  return;
		  }else {
			System.out.println(mensaje + (i+1));			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		}
		
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
