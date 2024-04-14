package usuarios;

import java.util.ArrayList;
import java.util.List;

import almacen.Pieza;

public class Propietario extends Usuario {
	private int dineroDeuda;
	private List<Pieza> piezas;
	private static List<Propietario> propietarios = new ArrayList<Propietario>();
	
	public Propietario(String usuarioID, List<Pieza> piezas) {
		super(usuarioID);
		this.dineroDeuda = 0;
		this.piezas = piezas;
		propietarios.add(this);
	}
	
	public Propietario(String usuarioID) {
		super(usuarioID);
		this.dineroDeuda = 0;
		this.piezas = new ArrayList<Pieza>();
		propietarios.add(this);
	}
	
	public void removerPieza(Pieza pieza) {
		this.piezas.remove(pieza);
	}
	
	public void agregarPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}
	
	public void agregarDinero(int dinero) {
		this.dineroDeuda = this.dineroDeuda + dinero;
	}
	
	public int removerDinero(int dinero) {
		int diferencia = this.dineroDeuda - dinero;
		if (diferencia < 0) {
			this.dineroDeuda = 0;
			return -1*diferencia;
		}
		this.dineroDeuda = diferencia;
		return diferencia;
	}
	public static boolean isPropietario(Propietario comprador) {
		for (int i = 0; i < Propietario.propietarios.size(); i++) {
			Propietario local = Propietario.propietarios.get(i);
			if (local == comprador) {
				return true;
			}
		}
		return false;
	}
	
	public static Propietario getPropietario(String idPropietario) {
		for (int i = 0; i < Propietario.propietarios.size(); i++) {
			Propietario local = Propietario.propietarios.get(i);
			if (local.getUsuarioID().equals(idPropietario)) {
				return local;
			}
		}
		return null;
	}

	public static boolean isPropietario(String idPropietario) {
		for (int i = 0; i < Propietario.propietarios.size(); i++) {
			Propietario local = Propietario.propietarios.get(i);
			if (local.getUsuarioID().equals(idPropietario)) {
				return true;
			}
		}
		return false;
	}
}
