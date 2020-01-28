package carreras;

import java.util.Scanner;

public class Menu {
	
	public int pintaMenuPrincipal() {
		Scanner leer=new Scanner(System.in);
		int opc=0;
		do {
		System.out.println("**********Juego de Carreras**************");
		System.out.println("1. Añadir Jugador");
		System.out.println("2. Empezar el Juego");
		System.out.println("3. Salir");
		opc=leer.nextInt();
		}while(opc<1 || opc>3);
		return opc;
	}
	
	
	
	public int pintaMenuCarrera() {
		Scanner leer= new Scanner(System.in);
		int opc1=0;
				do {
					System.out.println("1. Acelerar");
					System.out.println("2. Frenar");
					System.out.println("3. Rearrancar");
					opc1=leer.nextInt();
				}while(opc1<1 || opc1>3);
				
	return opc1;			
	}
	
	
}
