package br.com.fucapi.jdbc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class JPAUtuil {
	private static final EntityManagerFactory emf=Persistence.createEntityManagerFactory("manaustourapp");
	
	public static EntityManager getEm(){
		return emf.createEntityManager();
	}
}
