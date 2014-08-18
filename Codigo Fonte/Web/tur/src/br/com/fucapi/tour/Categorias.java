package br.com.fucapi.tour;

public class Categorias {
	private static String nome;
	private static String descricao;
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		Categorias.nome = nome;
	}
	public static String getDescricao() {
		return descricao;
	}
	public static void setDescricao(String descricao) {
		Categorias.descricao = descricao;
	}
}
