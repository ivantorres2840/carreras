package carreras;

import java.util.Scanner;

public class Carrera {

	private String nombre;
	private double distanciaCarrera;
	private Coche [] vParticipantes;
	
	
	public Carrera(String nombre, double distanciaCarrera) {
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
		 String nombrepiloto="";
		 int dorsal=0;
		 boolean bot=false;
		 int opc=0;
		 do {
		 System.out.println("Introduce nombre piloto");
		 nombrepiloto=leer.nextLine();
		 System.out.println("Introduce su dorsal");
		 dorsal=leer.nextInt();
		 
		 System.out.println("Es Humano(1) Es Robot(2)");
		 
		 if(opc==1) {
			 bot=true;
		 }
		 if(opc==2) {
			 bot=false;
		 }
		 
		 for (int i = 0; i < vParticipantes.length; i++) {
			if(vParticipantes[i]==null) {
				Coche coches = new Coche(nombrepiloto,dorsal,bot);
				vParticipantes[i]=coches;
			}
			break;
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
			if(vParticipantes[i]!=null && vParticipantes[i].getEstado().equalsIgnoreCase("marcha") ) {
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
						opcion=menu.pintaMenuPrincipal();
						switch(opcion) {
						case 1:
							añadirCoche();
							break;
						case 2:
							jugar();
							break;
						case 3:
							System.out.println("Adios");
							break;
						}
						
						
					}else {
						//Maquina
						
						if(coche.getEstado().equalsIgnoreCase("accidentado")) {
							coche.Arrcancar();
						}else {
							int opcion2;
							opcion2=menu.
						}
						
					}
					
					
				}
			}
			
		}while(!partidaTerminada());
	}
	
	
	
	
}
