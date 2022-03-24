package view;

import java.util.concurrent.Semaphore;

import controller.ControleCarro;

public class Main {
	
	public static  void main (String [] args) {
		
		String[] coordenadas = {"Norte p/Sul", "Leste p/Oeste", "Oeste p/Leste", "Sul p/Norte"};
		Semaphore semaforo = new Semaphore(1);
		
		for (int i = 1; i < 5; i++) {
			ControleCarro carro = new ControleCarro(coordenadas[i - 1], semaforo);
			carro.start();
		}
		
	}

}
