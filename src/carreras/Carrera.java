package carreras;

import java.util.Arrays;
import java.util.Scanner;

public class Carrera {

	private String nombre;
	private int distanciaCarrera;
	private Coche [] vParticipantes;
	
	
	
	public Carrera() {
		
	}


	public Carrera(String nombre, int distanciaCarrera) {
		this.nombre = nombre;
		this.distanciaCarrera = distanciaCarrera;
		this.vParticipantes = new Coche[5];
}
	
	
	
	
	private boolean comprobarDorsal(int dorsal) {
			
			for (int i = 0; i < vParticipantes.length; i++) {
				if (vParticipantes[i]!=null && vParticipantes[i].getDorsal()==dorsal) {
					return true;
				}
			}
		
			return false;
	}
	
	
	
	public void añadirCoche(){
		Scanner leer=new Scanner(System.in);
		Scanner leernum=new Scanner(System.in);
		 String nombrepiloto="";
		 int dorsal=0;
		 boolean bot=false;
		 int opc=0;
		 
		 do {
		 System.out.println("Introduce nombre piloto");
		 nombrepiloto=leer.nextLine();
		 System.out.println("Introduce su dorsal");
		 dorsal=leernum.nextInt();
		 
		 System.out.println("Es Humano(1) Es Robot(2)");
		 opc=leernum.nextInt();
		 if(opc==1) {
			 bot=true;
		 }else if(opc==2) {
				bot=false;
			}
		 
		 for (int i = 0; i < vParticipantes.length ; i++) {
			if(vParticipantes[i]==null) {
				Coche coche = new Coche(nombrepiloto,dorsal,distanciaCarrera,bot);
				vParticipantes[i]=coche;
				break;
			}
		}
		 
		 }while(!comprobarDorsal(dorsal)); 
		
	}
	
	
	public void Ganador() {
		for (int i = 0; i < vParticipantes.length; i++) {
			if(vParticipantes[i]!=null && vParticipantes[i].getKmrealizados()==distanciaCarrera ) {
				vParticipantes[i].setEstado("terminado");
			}
		}
	}
	
	
	
	public boolean partidaTerminada() {
		for (int i = 0; i < vParticipantes.length; i++) {
			if((vParticipantes[i]!=null) && !(vParticipantes[i].getEstado().equalsIgnoreCase("marcha")) ) {
				return true;
			}
		}
		return false;
	}
	
	
	public void imprimirSituacionCarrera() {
		for (int i = 0; i < vParticipantes.length; i++) {
			if(vParticipantes!=null)
			vParticipantes[i].toString();
		}
	}
	
	
	public void arrancarTodosCoches() {
		for (int i = 0; i < vParticipantes.length; i++) {
			if(vParticipantes!=null)
			vParticipantes[i].setEstado("marcha");
		}
	}
	
	
	public void configurarCarrera() {
		Scanner leer= new Scanner(System.in);
		Scanner leernum=new Scanner(System.in);
		String nombrecarrera="";
		int distanciacarrera=0;
		System.out.println("Introduce el nombre de la carrera");
		nombrecarrera=leer.nextLine();
		System.out.println("Introduce la distancia en KM de la carrera");
		distanciacarrera=leernum.nextInt();
		
		Carrera c = new Carrera(nombrecarrera,distanciacarrera);
		
		
	}
	
	
	

	public void jugar() {
		
		arrancarTodosCoches();
		do {
			imprimirSituacionCarrera();
			for (int i = 0; i < vParticipantes.length; i++) {
				if (vParticipantes[i]!=null) {
					Coche coche = vParticipantes[i];
					
					if (!coche.isBot()) {
						//Humano
						Menu menu = new Menu();
						int opcion;
						opcion=menu.pintaMenuCarrera();
						switch(opcion) {
						case 1:
							coche.Acelerar();
							break;
						case 2:
							coche.Frenar();
							break;
						case 3:
							coche.Rearrancar();
							break;
						}
						
						
					}else {
						//Maquina
						
						if(coche.getEstado().equalsIgnoreCase("accidentado")) {
							coche.Arrcancar();
						}else {
							int opc;
							opc= (int) Math.random()*2+1;
							switch(opc) {
							case 1:
								coche.Acelerar();
								break;
							case 2:
								coche.Frenar();
								break;
							}
							
							
						}
						
					}
					
					
				}
			}
			
		}while(!partidaTerminada());
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getDistanciaCarrera() {
		return distanciaCarrera;
	}


	public void setDistanciaCarrera(int distanciaCarrera) {
		this.distanciaCarrera = distanciaCarrera;
	}


	public Coche[] getvParticipantes() {
		return vParticipantes;
	}


	public void setvParticipantes(Coche[] vParticipantes) {
		this.vParticipantes = vParticipantes;
	}
	
	@Override
	public String toString() {
		return "Carrera [nombre=" + nombre + ", distanciaCarrera=" + distanciaCarrera + ", vParticipantes="
				+ Arrays.toString(vParticipantes) + "]";
	}

	
	
}
