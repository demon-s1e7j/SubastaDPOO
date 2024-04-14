package usuarios;

import java.util.List;

import subasta.Subasta;

public class Operador {
	private Subasta subastaActual;
	private List<Subasta> subastasRealizadas;
	
	public void asignarSubasta(Subasta subasta) {
		this.subastasRealizadas.add(subasta);
		this.subastaActual = subasta;
	}
	
	public void crearOferta(String compradorId, String piezaid, int dinero) {
		Comprador comprador = this.hallarComprador(compradorId);
		this.subastaActual.crearOferta(comprador, piezaid, dinero);
	}
	
	public Comprador hallarComprador(String compradorId) {
		List<Comprador> compradores = this.subastaActual.getCompradores();
		for (int i = 0; i > compradores.size(); i++) {
			Comprador comprador = compradores.get(i);
			if (comprador.getUsuarioID().equals(compradorId)) {
				return comprador;
			}
		}
		return null;
	}
	public void mandarOferta(String piezaId) {
		this.subastaActual.mandarOferta(piezaId);
	}
}
