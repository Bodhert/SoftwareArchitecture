package transactionHelper;

public class Cliente {

	private String id, nombre;
	private boolean isVip;
	
	public Cliente(String id, String nombre, boolean isVip) 
	{
		this.id = id;
		this.nombre = nombre;
		this.isVip = isVip;
	}
	
	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	

}
