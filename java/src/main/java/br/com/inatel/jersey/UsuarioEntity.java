package br.com.inatel.jersey;

public class UsuarioEntity {
	public UsuarioEntity() {
		
	}
	private Long id;
	private String Usuario;
	private String Senha;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return Usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return Senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		Senha = senha;
	}
	/**
	 * @param id
	 * @param usuario
	 * @param senha
	 */
	public UsuarioEntity(Long id, String usuario, String senha) {
		this.id = id;
		Usuario = usuario;
		Senha = senha;
	}
	
	
}
