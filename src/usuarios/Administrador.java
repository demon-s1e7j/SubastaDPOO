package usuarios;

import java.util.LinkedList;
import java.util.List;

import almacen.Pieza;
import subasta.Oferta;
import subasta.Subasta;

public class Administrador {
	private static List<Oferta> ofertasPendientes = new LinkedList<Oferta>();
	private static List<Oferta> ofertasAceptadas = new LinkedList<Oferta>();
	private static List<Oferta> ofertasRechazadas = new LinkedList<Oferta>();
	
	public void revisarOferta(Oferta oferta) {
		int dinero = oferta.getDinero();
		Comprador comprador = oferta.getComprador();
		Pieza pieza = oferta.getPieza();
		if (dinero < pieza.getValorMinimo() || !Comprador.isComprador(comprador)) {
			this.rechazarOferta(oferta);
		}
		this.aceptarOferta(oferta);
	}
	
	public void rechazarOferta(Oferta oferta) {
		Comprador comprador = oferta.getComprador();
		ofertasPendientes.remove(oferta);
		ofertasRechazadas.add(oferta);
		comprador.rechazarOferta(oferta);
	}
	
	public void aceptarOferta(Oferta oferta) {
		Pieza pieza = oferta.getPieza();
		Comprador comprador = oferta.getComprador();
		int dinero = oferta.getDinero();
		Propietario propietario = pieza.getPropietario();
		Propietario nuevoPropietario = null;
		
		if (Propietario.isPropietario(comprador.getUsuarioID())) {
			nuevoPropietario = Propietario.getPropietario(comprador.getUsuarioID());
		} else {
			nuevoPropietario = new Propietario(comprador.getUsuarioID());
		}
		propietario.agregarDinero(dinero);
		propietario.removerPieza(pieza);
		nuevoPropietario.agregarPieza(pieza);
		Administrador.ofertasPendientes.remove(oferta);
		Administrador.ofertasAceptadas.add(oferta);
	}
	
	public static void agregarOferta(Oferta oferta) {
		Administrador.ofertasPendientes.add(oferta);
	}
	
	public void crearSubasta(List<Pieza> piezas, List<Comprador> compradores, Operador operador) {
		List<Pieza> piezasValidas = piezas.stream().filter((a) -> a.isDisponibleVenta()).toList();
		List<Comprador> compradoresValidos = compradores
				.stream()
				.filter((a) -> Comprador.isComprador(a))
				.toList();
		Subasta subasta = new Subasta(piezasValidas, compradoresValidos);
		operador.asignarSubasta(subasta);
	}
}
