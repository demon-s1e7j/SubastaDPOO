package almacen;

import usuarios.Propietario;

public class Pieza {
	private boolean disponibleVenta;
	private int valorMinimo;
	private int valorInicial;
	private String piezaId;
	private Propietario propietario;
	
	public Pieza(boolean disponible, 
			int valorMinimo, 
			int valorInicial, 
			String piezaId, 
			Propietario propietario) {
		this.disponibleVenta = disponible;
		this.valorMinimo = valorMinimo;
		this.valorInicial = valorInicial;
		this.piezaId = piezaId;
		this.propietario = propietario;
	}

	public boolean isDisponibleVenta() {
		return disponibleVenta;
	}

	public void setDisponibleVenta(boolean disponibleVenta) {
		this.disponibleVenta = disponibleVenta;
	}

	public int getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(int valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public int getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(int valorInicial) {
		this.valorInicial = valorInicial;
	}

	public String getPiezaId() {
		return piezaId;
	}

	public void setPiezaId(String piezaId) {
		this.piezaId = piezaId;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	public boolean isMayorValorMinimo(int oferta) {
		return this.valorMinimo < oferta;
	}
}
