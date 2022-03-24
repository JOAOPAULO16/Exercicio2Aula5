package controller;

import java.util.concurrent.Semaphore;

public class ControleCarro extends Thread {
	
	private int CarroId;
	private String coordenadas;
	private double tempInicio, tempFinal, tempTotal;
	private Semaphore semaforo;
	
	public ControleCarro (String coordenadas, Semaphore semaforo){
		this.CarroId = (int) this.getId();
		this.coordenadas = coordenadas;
		this.semaforo = semaforo;
		}
	
	public void run () {
		CarroAndando();
		try {
			CarroEmEspera();
			semaforo.acquire();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		CarroCruzando();
	}
	
	private void CarroAndando() {
		int tempo = 1000;
		int distPercorrida = 0;
		
		while (distPercorrida < 100) {
			distPercorrida += (int)((Math.random()*5)+6);
			try {
				Thread.sleep(tempo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("O Carro #" + CarroId + " percorreu " + distPercorrida + " metros");
		}
	}
	
	private void CarroEmEspera() {
		System.out.println("O Carro #" + CarroId + " está parado no cruzamento");
		tempInicio = System.nanoTime();
	}
	
	private void CarroCruzando() {
		tempFinal = System.nanoTime();
		tempTotal = tempFinal - tempInicio;
		tempTotal = tempTotal / Math.pow(10, 9);
		System.out.println("O Carro #" + CarroId + " ficou esperando no cruzamento " + tempTotal + " segundos, e cruzou no sentido " + coordenadas);
	}
	
}
