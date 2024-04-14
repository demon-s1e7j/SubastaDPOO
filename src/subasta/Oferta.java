package subasta;

import almacen.Pieza;
import usuarios.Comprador;

public class Oferta {
	private int dinero;
	private Comprador comprador;
	private Pieza pieza;
	
	public Oferta(Comprador comprador, Pieza pieza, int dinero) {
		this.comprador = comprador;
		this.pieza = pieza;
		this.dinero = dinero;
	}
	
	public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	public Comprador getComprador() {
		return comprador;
	}
	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	public Pieza getPieza() {
		return pieza;
	}
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
}
