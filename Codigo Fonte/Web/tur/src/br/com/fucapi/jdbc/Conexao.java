package br.com.fucapi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe destinada a abrir conexão com o banco de dados
 * através do drivermanager JDBC.
 * @author Jorenilson Lopes dos Santos
 *
 */
public class Conexao {
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver"); //Chama ao driver de conexão
			return DriverManager.getConnection("jdbc:mysql://localhost/manaustur","root","vertrigo"); //URL de Conexão e Usuário de acesso seguido da senha
		}catch(SQLException | ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}
}
