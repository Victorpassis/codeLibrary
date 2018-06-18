package br.ifsp.livraria.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ifsp.livraria.entities.Livro;

public class LivroRepository {
	
	private EntityManager manager ;
	
	public LivroRepository (EntityManager manager ) {
		this.manager = manager ;
	}
	
	public void adiciona (Livro l) {
		this.manager.persist(l);
	}
	
	public Livro busca (int id) {
		return this.manager.find (Livro.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List <Livro> buscaTodas() {
		Query query = this.manager.createQuery(" SELECT l FROM Livro l");
		return query . getResultList ();
	}

}
