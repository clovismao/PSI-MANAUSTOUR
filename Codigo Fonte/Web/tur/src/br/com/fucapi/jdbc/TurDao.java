package br.com.fucapi.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fucapi.tur.Categorias;
import br.com.fucapi.tur.Usuarios;

public class TurDao {
	// Variável de referência
	private Connection conexao;

	// Método construtor
	public TurDao() {
		this.conexao = new Conexao().getConnection();
	}

	/**
	 * Classe destinada a adicionar um novo usuário ao banco de dados.
	 * 
	 * @param usuario
	 */
	public boolean adicionarusuario(Usuarios usuario) {
		boolean retorno = false;
		
		String sql = "insert into tbcadusuarios (nomecompleto, email, usuario, senha) value (?,?,?,?)";
		try {
			Usuarios novousuario = new Usuarios();
			// PreparedStatement para inserção dos dados no banco
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, novousuario.getNome());
			stmt.setString(2, novousuario.getEmail());
			stmt.setString(3, novousuario.getUsuario());
			stmt.setString(4, novousuario.getSenha());
			stmt.execute();
			stmt.close();
			retorno = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return retorno;
	}
	
	/**
	 * Classe destinada a adicionar uma nova categoria ao banco de dados.
	 * @param categoria
	 * @return
	 */
	public boolean AdicionarCategoria(Categorias categoria){
		boolean retorno = false;
		
		String sql = "insert into tbcategorias (nome, descricao) value (?,?)";
		try{
			Categorias novacategoria = new Categorias();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, novacategoria.getNome());
			stmt.setString(2, novacategoria.getDescricao());
			stmt.execute();
			stmt.close();
			retorno = true;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return retorno;
	}
}
