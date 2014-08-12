package br.com.fucapi.tur;

/**
 * Classe destinada a montar o objeto Usuarios.
 * @author Familia Santos
 *
 */
public class Usuarios {
	private static String nome;
	private static String usuario;
	private static String senha;
	private static String email;
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		Usuarios.nome = nome;
	}
	public static String getUsuario() {
		return usuario;
	}
	public static void setUsuario(String usuario) {
		Usuarios.usuario = usuario;
	}
	public static String getSenha() {
		return senha;
	}
	public static void setSenha(String senha) {
		Usuarios.senha = senha;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		Usuarios.email = email;
	}
	

}
