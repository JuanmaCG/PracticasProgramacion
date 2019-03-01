package persistenciaDatos;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import Clientes.Cliente;
import Clientes.GestionarClientes;

public interface Persistencia {

	public void mandarInformacionAFichero(String datos, File fichero) throws IOException;
	
	public void insertarABBDD(LinkedList<Cliente> lista) throws ClassNotFoundException;
	
	public void eliminarDatos(int id) throws ClassNotFoundException;
	
	public void modificarDatos(int id, String datos, String telefono) throws ClassNotFoundException;
	
	public void mostrarDatos() throws ClassNotFoundException;
	
	public GestionarClientes leer(File fichero);
	
}
