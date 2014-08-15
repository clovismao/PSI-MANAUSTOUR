package br.com.fucapi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe destinada a abrir conex�o com o banco de dados
 * atrav�s do drivermanager JDBC.
 * @author Jorenilson Lopes dos Santos
 *
 */
public class Conexao {
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver"); //Chama ao driver de conex�o
			return DriverManager.getConnection("jdbc:mysql://localhost/manaustur","root","vertrigo"); //URL de Conex�o e Usu�rio de acesso seguido da senha
		}catch(SQLException | ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}
}
