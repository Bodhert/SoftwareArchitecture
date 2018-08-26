package carHandler;

public class FamilyCar extends Car 
{

	private int valorHora;
	private String seguro;
	
	public FamilyCar(String placa, String marca, String transmision, int cilindraje,
			int NroDePuestos, int valorHora, String seguro) 
	{
		super(placa, marca, transmision, cilindraje, NroDePuestos);
		this.valorHora = valorHora;
		this.seguro = seguro;
	}

	public int getValorHora() {
		return valorHora;
	}

	public String getSeguro() {
		return seguro;
	}

	public void setValorHora(int valorHora) {
		this.valorHora = valorHora;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

}
