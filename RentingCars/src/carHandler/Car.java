package carHandler;

public abstract class Car 
{
	private int cilindraje, NroDePuestos;
	private String placa, marca, color, transmision;
	
	public Car(String placa, String marca, String transmision, int cilindraje,
				int NroDePuestos)
	{
		this.placa =  placa;
		this.marca = marca;
		this.transmision = transmision;
		this.cilindraje = cilindraje;
		this.NroDePuestos = NroDePuestos;
	}
	
	abstract public int getValorHora();
	
	public String getPlaca() 
	{
		return placa;
	}

	public String getMarca() 
	{
		return marca;
	}

	public String getColor() 
	{
		return color;
	}

	public String getTransmision() 
	{
		return transmision;
	}

	public int getCilindraje() 
	{
		return cilindraje;
	}

	public int getNroDePuestos() 
	{
		return NroDePuestos;
	}

	public void setPlaca(String placa) 
	{
		this.placa = placa;
	}

	public void setMarca(String marca) 
	{
		this.marca = marca;
	}

	public void setColor(String color) 
	{
		this.color = color;
	}

	public void setTransmision(String transmision) 
	{
		this.transmision = transmision;
	}

	public void setCilindraje(int cilindraje) 
	{
		this.cilindraje = cilindraje;
	}

	public void setNroDePuestos(int nroDePuestos) 
	{
		NroDePuestos = nroDePuestos;
	}


}
