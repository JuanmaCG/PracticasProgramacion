package bbddCliente;

import Clientes.Cliente;
import Clientes.GestionarClientes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import persistenciaDatos.Persistencia;

public class Conexion implements Persistencia{
	
	public Conexion() {}
	
	@Override
	public void insertarABBDD(LinkedList<Cliente> lista) throws ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.178:1521:xe";
			connection = DriverManager.getConnection(url, "clientes", "clientes");
			
			String query = "insert into clientes values(?, ?, ?)";
			try(PreparedStatement st = connection.prepareStatement(query)){
				for(Cliente clientes : lista) {
					st.setInt(1, clientes.getId());
					st.setString(2, clientes.getNombreApellidos());
					st.setString(3, clientes.getNumeroTelefono());
					st.executeQuery();
				}
			}
			connection.close();
		} catch(SQLException ex) {
			connection = null;
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	@Override
	public void mandarInformacionAFichero(String datos, File fichero) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bf = new BufferedWriter(new FileWriter(fichero, true));
		bf.write(datos);  
		bf.newLine();
		bf.close();
	}
	
	
	@Override
	public GestionarClientes leer(File fichero) {
		BufferedReader br;
		String linea = null;
		GestionarClientes gc = new GestionarClientes();
		try {
			br = new BufferedReader(new FileReader(fichero));
			while ((linea = br.readLine()) != null) {
	            String datos [] = linea.split("&");
	            String nombreApellidos = datos[1];
	            String telefono = datos[2];
	            gc.add((new Cliente(nombreApellidos, telefono)));
	         }
			br.close();
		} catch (IOException e) {
			e.getMessage();
		}
		return gc;
	}

	@Override
	public void eliminarDatos(int id) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.178:1521:xe";
			connection = DriverManager.getConnection(url, "clientes", "clientes");
			
			String query = "delete from clientes where id = ?";
			try(PreparedStatement st = connection.prepareStatement(query)){
				st.setInt(1, id);
				st.executeQuery();
			}
			connection.close();
		} catch(SQLException ex) {
			connection = null;
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	
	/*
	 * (non-Javadoc)
	 * @see persistenciaDatos.Persistencia#modificarDatos(int, java.lang.String, java.lang.String)
	 * Update de los datos - Cambia el menu 2 de modificar
	 */
	@Override
	public void modificarDatos(int id, String datos, String telefono) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.178:1521:xe";
			connection = DriverManager.getConnection(url, "clientes", "clientes");
			
			String query = "update clientes set datos = ?, telefono = ? where id = ?";
			try(PreparedStatement st = connection.prepareStatement(query)){
				st.setString(1, datos);
				st.setString(2, telefono);
				st.setInt(3, id);
				st.executeQuery();
			}
			connection.close();
		} catch(SQLException ex) {
			connection = null;
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}

	
	/*
	 * (non-Javadoc)
	 * @see persistenciaDatos.Persistencia#mostrarDatos()
	 * Select para mostrar clientes
	 */
	@Override
	public void mostrarDatos() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.178:1521:xe";
			connection = DriverManager.getConnection(url, "clientes", "clientes");
			
			String query = "select * from clientes";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String datos = rs.getString(2);
				String telefono = rs.getString(3);
				
				System.out.println("id: " + id + "| datos: " + datos + "| telefono: " + telefono);
			}
			connection.close();
		} catch(SQLException ex) {
			connection = null;
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

}
