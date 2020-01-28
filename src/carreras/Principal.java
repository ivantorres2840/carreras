package carreras;

public class Principal {

	public static void main(String[] args) {
		Menu menu= new Menu();
		Carrera c = new Carrera();
		int opc;
		
		
		do {
			opc=menu.pintaMenuPrincipal();
		switch(opc) {
			case 1:
				c.añadirCoche();
				break;
			case 2:
				c.configurarCarrera();
				break;
			case 3: 
				c.jugar();
				break;
			case 4:
				System.out.println("Adios");
				break;
				
		}
		}while(opc>1 || opc<4);
	}

}
