package br.com.fucapi.tour;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe destinada a montar o objeto Usuarios.
 * 
 * @author Jorenilson Santos
 *
 */
@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private static long id;
	private static String nome;
	private static String usuario;
	private static String senha;
	private static String email;

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		Usuario.email = email;
	}

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		Usuario.nome = nome;
	}

	public static String getUsuario() {
		return usuario;
	}

	public static void setUsuario(String usuario) {
		Usuario.usuario = usuario;
	}

	public static String getSenha() {
		return senha;
	}

	public static void setSenha(String senha) {
		Usuario.senha = senha;
	}

	public static long getId() {
		return id;
	}

	public static void setId(long id) {
		Usuario.id = id;
	}
}
