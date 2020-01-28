package carreras;

import java.util.Random;

public class Coche {

	private String nombrepiloto;
	private int dorsal;
	private String estado;
	private int potencia;
	private int velocidad;
	private double kmrealizados;
	private int distanciaCarrera;
	private boolean bot;


	public Coche(String nombrepiloto, int dorsal, boolean bot) {
		this.nombrepiloto = nombrepiloto;
		this.dorsal = dorsal;
		this.estado = "parado";
		this.potencia = 50;
		this.velocidad = 0;
		this.kmrealizados = 0;
		this.bot = bot;
	}
	

	public Coche(String nombrepiloto, int dorsal,int distanciaCarrera, boolean bot) {
		this.nombrepiloto = nombrepiloto;
		this.dorsal = dorsal;
		this.estado = "parado";
		this.potencia = 50;
		this.velocidad = 0;
		this.kmrealizados = 0;
		this.distanciaCarrera = distanciaCarrera;
		this.bot = bot;
	}



	public int getDistanciaCarrera() {
		return distanciaCarrera;
	}


	public void setDistanciaCarrera(int distanciaCarrera) {
		this.distanciaCarrera = distanciaCarrera;
	}


	public String getNombrepiloto() {
		return nombrepiloto;
	}

	public void setBot(boolean bot) {
		this.bot = bot;
	}

	public boolean isBot() {
		return bot;
	}

	public void setNombrepiloto(String nombrepiloto) {
		this.nombrepiloto = nombrepiloto;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public double getKmrealizados() {
		return kmrealizados;
	}

	public void setKmrealizados(double kmrealizados) {
		this.kmrealizados = kmrealizados;
	}

	@Override
	public String toString() {
		return "coche [nombrepiloto=" + nombrepiloto + ", dorsal=" + dorsal + ", estado=" + estado + ", potencia="
				+ potencia + ", velocidad=" + velocidad + ", kmrealizados=" + kmrealizados + "]";
	}

	public void Arrcancar() {
		if(this.estado.equalsIgnoreCase("parado"))
		this.estado = "marcha";
		//System.out.println("El coche esta en marcha");
	}

	public void Acelerar() {
		int aceleron;

		if ((this.estado.equalsIgnoreCase("marcha")) && !(this.estado.equalsIgnoreCase("accidentado"))) {
			aceleron = (int) (Math.random() * potencia + 0);

			this.velocidad += aceleron;
		}

		if (this.velocidad > 200) {
			this.estado = "accidentado";
			this.velocidad=0;
		}
		
		this.kmrealizados=this.getVelocidad();
	}

	public void Frenar() {
		int frenazo;

		if ((this.estado.equalsIgnoreCase("marcha")) && !(this.estado.equalsIgnoreCase("accidentado"))) {
			frenazo = (int) (Math.random() * potencia + 0);
			this.velocidad -= frenazo;
		}

		if (this.velocidad < 0) {
			this.velocidad = 0;
		}
		this.kmrealizados=this.getVelocidad();
	}

	public void Rearrancar() {

		if (this.estado.equalsIgnoreCase("Accidentado") && !(this.estado.equalsIgnoreCase("Terminado"))) {
			this.estado = "marcha";
			//System.out.println("El coche vuelte a estar en marcha");
		}

	}

}
