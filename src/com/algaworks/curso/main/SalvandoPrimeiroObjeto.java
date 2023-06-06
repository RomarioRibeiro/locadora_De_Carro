package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;
import com.algaworks.curso.modelo.ContaCorrete;

public class SalvandoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Mario");
		cliente.setIdade(60);
		cliente.setSexo("M");
		cliente.setProfissao("Aposentado");
		
		ContaCorrete contaCorrete = new ContaCorrete();
		contaCorrete.setSaldo(1150.00);
		contaCorrete.setCliente(cliente);
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.persist(contaCorrete);
		em.getTransaction().commit();
		
		System.out.println("Cliente Salvo com sucesso!");
		
		em.close();
	}

}
