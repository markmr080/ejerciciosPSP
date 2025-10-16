package main;

import java.util.Scanner;

public class Main {
	
	
	public static void main (String [] args) {
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Introduce un Alumno 1");
		String nombre = sc.nextLine();
		Thread a = new Thread(new Alumno(nombre));
	
		System.out.println("Introduce un Alumno 2");
		nombre = sc.nextLine();
		Thread b = new Thread(new Alumno(nombre));
				
		System.out.println("Introduce un Alumno 3");
		nombre = sc.nextLine();
		Thread c = new Thread(new Alumno(nombre));
		
		try {
			
			a.start();
			a.join();
			b.start();
			b.join();
			c.start();
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}

}
