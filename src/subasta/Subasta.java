package subasta;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import almacen.Pieza;
import usuarios.Comprador;

public class Subasta {
	private Map<String, Pieza> piezasDisponibles;
	private Map<String, List<Oferta>> ofertas;
	private List<Comprador> compradores;
	
	public Subasta(List<Pieza> piezas, List<Comprador> compradores) {
		this.piezasDisponibles = new HashMap<String, Pieza>();
		this.ofertas = new HashMap<String, List<Oferta>>();
		this.compradores = compradores;
		for (int i = 0; i < piezas.size(); i++) {
			Pieza pieza = piezas.get(i);
			String id = pieza.getPiezaId();
			this.piezasDisponibles.put(id, pieza);
			this.ofertas.put(id, new LinkedList<Oferta>());
		}
	}
	
	public void crearOferta(Comprador comprador, String piezaId, int dinero) {
		Pieza pieza = this.piezasDisponibles.get(piezaId);
		Oferta oferta = new Oferta(comprador, pieza, dinero);
		this.ofertas.get(piezaId).add(oferta);
	}
}
