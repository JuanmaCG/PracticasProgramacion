package Clientes;

public class Cliente {
	
	static int contador = 1;
	private int id;
	private String nombreApellidos;
	private String numeroTelefono;
	/**
	 * @param nombreApellidos
	 * @param numeroTelefono
	 */
	public Cliente(String nombreApellidos, String numeroTelefono) {
		this.nombreApellidos = nombreApellidos;
		this.numeroTelefono = numeroTelefono;
		this.id = contador;
		contador += 1;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nombreApellidos
	 */
	public String getNombreApellidos() {
		return nombreApellidos;
	}
	/**
	 * @param nombreApellidos the nombreApellidos to set
	 */
	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}
	/**
	 * @return the numeroTelefono
	 */
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	/**
	 * @param numeroTelefono the numeroTelefono to set
	 */
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return id + "&" + nombreApellidos + "&" + numeroTelefono;
	}
	
	
	
	
}
