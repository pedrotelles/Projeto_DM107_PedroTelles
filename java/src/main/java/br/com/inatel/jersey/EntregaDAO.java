package br.com.inatel.jersey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntregaDAO {
	
	private Long id = 0L;
	private static Connection connection;

    public EntregaDAO() {
      this.connection = new ConnectionFactory().getConnection();
    }
	
	public void createEntrega(EntregaEntity entrega) throws SQLException {
		String sql =  "Insert into entregas" +
					  "(nPedido, idCliente, nome, cpf,"
					  + "dataHoraEntrega) "+
					  "values (?,?,?,?,?)";
		
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, entrega.getnPedido());
			stmt.setLong(2, entrega.getIdCliente());
			stmt.setString(3, entrega.getNomeCliente());
			stmt.setString(4, entrega.getCpf());
			stmt.setString(5, entrega.getDataHoraEntrega());
			stmt.execute();
			stmt.close();
	
	}
	
	public EntregaEntity getEntregaByNPedido(Long nPedido) throws SQLException {
		String sql = "Select * from entregas where nPedido = (?)";
		
		System.out.println("Primeiro passo");
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(1, nPedido);
		ResultSet rs = stmt.executeQuery();
		EntregaEntity entrega = null;
		entrega = new EntregaEntity();
		while (rs.next())
		{
			System.out.println(rs.getString("cpf"));
			entrega.setId(rs.getLong("id"));
			entrega.setCpf(rs.getString("cpf"));
			entrega.setIdCliente(rs.getLong("idCliente"));
			entrega.setnPedido(rs.getLong("nPedido"));
			entrega.setDataHoraEntrega(rs.getString("dataHoraEntrega"));
			entrega.setNomeCliente(rs.getString("nome"));
		}
		rs.close();
		stmt.close();
		
		return entrega;
		
		
	}
}
