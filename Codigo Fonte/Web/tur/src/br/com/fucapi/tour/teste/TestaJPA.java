package br.com.fucapi.tour.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fucapi.jdbc.JPAUtuil;
import br.com.fucapi.tour.Usuario;

@SuppressWarnings("unused")
public class TestaJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guiamanaus");
		EntityManager em=emf.createEntityManager();
		
		
		Usuario usuario = new Usuario();
		usuario.setNome("Jorenilson Santos");
		usuario.setEmail("jorenilsonlopes@gmail.com");
		usuario.setUsuario("jorenilson");
		usuario.setSenha("123456");
			
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}
}
