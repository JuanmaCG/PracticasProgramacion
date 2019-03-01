package main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Clientes.Cliente;
import Clientes.GestionarClientes;
import bbddCliente.Conexion;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		Scanner sc = new Scanner(System.in);
		Scanner scn = new Scanner(System.in);
		File fichero = new File("fichero.txt");
		Conexion conexion = new Conexion();
		GestionarClientes gc = new GestionarClientes();
		/*
		 * Leo fichero y le añado la ultima linea a la lista
		 */
		try {
			gc.addAll(conexion.leer(fichero));
		}catch (Exception e) {
			System.out.println("Sin datos");
		}
		
		
		
		int menu = 0;
		boolean salida = false;
		String nombreYApellidos;
		String telefono;
		int id;
		String datos;
		
		while(menu != 5 && salida == false) {
			System.out.println("1- AÃ±adir nuevo cliente.");
			System.out.println("2- Modificar datos.");
			System.out.println("3- Dar de baja un cliente.");
			System.out.println("4- Listar los clientes.");
			System.out.println("5-Salir.\n");
			System.out.println("Introduzca una opcion");
			menu = scn.nextInt();
			switch(menu) {
			case 1:
				/*
				 * Anadimos a la lista
				 */
				System.out.println("Escribe el nombre y los apellidos del cliente");
				nombreYApellidos = sc.nextLine();
				System.out.println("Introduce su telefono");
				telefono = sc.nextLine();
				gc.anadirCliente(new Cliente(nombreYApellidos, telefono));
				break;
			case 2:
				/*
				 * Modificamos de la base de datos
				 */
				conexion.mostrarDatos();
				System.out.println("\nElige un id para modificar");
				id = scn.nextInt();
				System.out.println("Escribe el nombre y los apellidos del cliente");
				nombreYApellidos = sc.nextLine();
				System.out.println("Introduce su telefono");
				telefono = sc.nextLine();
				
				break;
			case 3: 
				/*
				 * Eliminamos de la base de datos
				 */
				System.out.println("\nElige un id para eliminar");
				id = scn.nextInt();
				conexion.eliminarDatos(id);
				break;
			case 4:
				/*
				 * Mostramos los clientes de la bbdd
				 */
				conexion.mostrarDatos();
				System.out.println(gc.toString());
				break;
			case 5:
				/*
				 * borro el fichero para que no me cree de manera exponencial los clientes anteriores
				 * Anadimos al fichero y a la bbdd
				 */
				fichero.delete();
				for (Cliente clientes : gc) {
					datos = clientes.getId() + "&" + clientes.getNombreApellidos() + "&" + clientes.getNumeroTelefono();
					conexion.mandarInformacionAFichero(datos,fichero);
				}
				conexion.insertarABBDD(gc);
				
				break;
			default: System.out.println("Introduce un numero correcto");
			}
		}
		sc.close();
		scn.close();
	}

}
