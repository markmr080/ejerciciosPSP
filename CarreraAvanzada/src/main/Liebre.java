package main;

public class Liebre extends Animal{

	
	public Liebre(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}



	private int velocidad = 5;
	private int duerme = 10;
	
	
	
	@Override
	public void correr() {
		// TODO Auto-generated method stub
		System.out.println("Liebre esta corriendo en el sitio");
	}
	
	
	
}
