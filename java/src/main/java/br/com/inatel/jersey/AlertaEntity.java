package br.com.inatel.jersey;

public class AlertaEntity {
	private String Aviso;

	/**
	 * @param aviso
	 */
	public AlertaEntity(String aviso) {
		
		Aviso = aviso;
	}

	/**
	 * @return the aviso
	 */
	public String getAviso() {
		return Aviso;
	}

	/**
	 * @param aviso the aviso to set
	 */
	public void setAviso(String aviso) {
		Aviso = aviso;
	}
	
}
