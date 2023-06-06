package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class AtualizandoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();

		Cliente cliente = em.find(Cliente.class, 1L);

		if (cliente != null) {

			em.getTransaction().begin();
			cliente.setIdade(27);
			em.persist(cliente);
			em.getTransaction().commit();
			System.out.println("Cliente Atualizado com sucesso.");
		} else {
			System.out.println("Cliente nao Encontrado!");
		}


		em.close();
	}

}
