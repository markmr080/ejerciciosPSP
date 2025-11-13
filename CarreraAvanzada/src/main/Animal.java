package main;

public abstract class Animal {
	private String nombre;
	public Animal(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public abstract void correr ();
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean viento () {
		int direccionViento = (int) (Math.random() * 2);
		boolean viento = false;
		if (direccionViento == 1) {
			viento = true;
			return viento;
		}else {
			return viento;
		}	
	}
}
