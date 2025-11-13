package main;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore a = new Semaphore(1);
		
		Thread b = new Thread(new Carrera (a ,"pajaro"));
		
		b.start();

	}

}
