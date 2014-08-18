package br.com.fucapi.jdbc;

import javax.persistence.EntityManager;

import br.com.fucapi.tour.Usuario;

public class TourDao {
	private EntityManager em;
	public TourDao(EntityManager e){
		this.em = em;
	}
	
	//M�todo de Persist�ncia para Cadastrar Usu�rios
	public void cadastrar(Usuario usuario){
		em.persist(usuario);
	}
	
}
