package br.com.inatel.jersey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	private Long id = 0L;
	private static Connection connection;

	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public boolean checkUsuario(String usuario,String senha) throws SQLException {
		String sql = "Select * from usuario where usuario = (?) and senha = (?)";

		System.out.println("Primeiro passo");
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, usuario);
		stmt.setString(2, senha);
		ResultSet rs = stmt.executeQuery();
		int count = 0;
		while (rs.next())
		{
			count++;
			System.out.println(count);
		}
		rs.close();
		stmt.close();
		if(count>0) {
			return true;
		}else {
			return false;
		}
	


	}
}
