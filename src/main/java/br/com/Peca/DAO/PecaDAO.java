package br.com.Peca.DAO;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import br.com.Peca.Pojo.*;

public class PecaDAO {
	private EntityManager em;

	public PecaDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pecas");
		this.em = factory.createEntityManager();
	}
	public boolean alteraEstoque(int quantidade, Peca peca) {
		//Peca peca = em.find(Peca.class, codBarras);
		peca.setEstoque(quantidade);
		
		em.getTransaction().begin();
		em.merge(peca);
		em.getTransaction().commit();
		
		return true;
	}
	
	public  boolean inserePeca(Peca peca) {
		em.getTransaction().begin();
		em.persist(peca);
		em.getTransaction().commit();
		
		return true;
	}
	
	public Peca consultaPeca(int codBarras) {
		return em.find(Peca.class, codBarras);
	}
		
	public List<Peca> listarPecasEstoque() {
		
		Query query = em.createQuery("select p from Peca as p");
		return query.getResultList();
	}
	
	public List<Peca> listaPecasPorNome(String nome) {
		
		Query query = em.createQuery("select p from Peca as p Where lower(p.nome) like lower(concat('%', :nome,'%'))");
		query.setParameter("nome", nome);
		return query.getResultList();
	}
	
		public List<Peca> listaPecasPorModCarro(String modelo) {
			
			Query query = em.createQuery("select p from Peca as p Where p.modeloCarro = :modelo");
			query.setParameter("modelo", modelo);
			return query.getResultList();
		}
		
		public List<Peca> listaPecasPorCategoria(String categoria) {
			
			Query query = em.createQuery("select p from Peca as p Where p.categoria = :categoria");
			query.setParameter("categoria", categoria);
			return query.getResultList();
		}
		
		public boolean removePeca(int codBarras)  {
			
			Peca peca = em.find(Peca.class, codBarras);
			
			if (peca == null) {
				System.err.println("Peça não encontrada!");
				return false;
			}

			em.getTransaction().begin();
			em.remove(peca);
			em.getTransaction().commit();
			
			return true;
		}

		
	
}

	

