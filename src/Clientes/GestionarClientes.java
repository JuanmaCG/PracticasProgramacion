package Clientes;

import java.util.LinkedList;


public class GestionarClientes extends LinkedList<Cliente>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	public GestionarClientes() {}
	
	
	/*
	 * Anadimos clientes a la lista de clientes
	 */
	
	public void anadirCliente(Cliente cli) {
		add(cli);
	}
	
	
//	public void modificarDatos(int id, String nombreApellidos, String telefono) {
//		for(Cliente clientes : this) {
//			if(clientes.getId() == id) {
//				clientes.setNombreApellidos(nombreApellidos);
//				clientes.setNumeroTelefono(telefono);
//			}
//		}
//	}
	
	
//	public int darDeBajaCliente(int id) {
//		for(Cliente clientes : this) {
//			if(clientes.getId() == id) {
//				remove(clientes);
//				return 1;
//			}
//			
//		}
//		return 0;
//	}
	
	



	

	
	
	
}
