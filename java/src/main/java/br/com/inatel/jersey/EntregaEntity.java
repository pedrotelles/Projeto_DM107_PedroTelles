package br.com.inatel.jersey;

public class EntregaEntity {
	public EntregaEntity() {
		
	}
	
	private Long id;
	private Long nPedido;
	private Long idCliente;
	private String nomeCliente;
	private String cpf;
	private String dataHoraEntrega;
	
	public EntregaEntity( Long nPedido, Long idCliente, String nomeCliente, String cpf,
			String dataHoraEntrega) {
		
		this.nPedido = nPedido;
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.dataHoraEntrega = dataHoraEntrega;
	}
	
	public EntregaEntity(Long id, Long nPedido, Long idCliente, String nomeCliente, String cpf,
			String dataHoraEntrega) {
		this.setId(id);
		this.nPedido = nPedido;
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.dataHoraEntrega = dataHoraEntrega;
	}
	
	/**
	 * @return the nPedido
	 */
	public Long getnPedido() {
		return nPedido;
	}
	/**
	 * @param nPedido the nPedido to set
	 */
	public void setnPedido(Long nPedido) {
		this.nPedido = nPedido;
	}
	/**
	 * @return the idCliente
	 */
	public Long getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}
	/**
	 * @param nomeCliente the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the dataHoraEntrega
	 */
	public String getDataHoraEntrega() {
		return dataHoraEntrega;
	}
	/**
	 * @param dataHoraEntrega the dataHoraEntrega to set
	 */
	public void setDataHoraEntrega(String dataHoraEntrega) {
		this.dataHoraEntrega = dataHoraEntrega;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
