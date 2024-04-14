package usuarios;

public abstract class Usuario {
	protected String usuarioId;
	
	public Usuario(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public String getUsuarioID() {
		return this.usuarioId;
	}
}
