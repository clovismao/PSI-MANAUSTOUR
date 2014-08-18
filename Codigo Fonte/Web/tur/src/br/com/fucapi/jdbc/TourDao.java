package br.com.fucapi.jdbc;

import javax.persistence.EntityManager;

import br.com.fucapi.tour.Usuario;

public class TourDao {
	private EntityManager em;
	public TourDao(EntityManager e){
		this.em = em;
	}
	
	//Método de Persistência para Cadastrar Usuários
	public void cadastrar(Usuario usuario){
		em.persist(usuario);
	}
	
}
