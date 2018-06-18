package br.ifsp.codeLibrary.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ifsp.codeLibrary.entities.Code;

public class CodeRepository {
	private EntityManager manager ;
	
	public CodeRepository (EntityManager manager ) {
		this.manager = manager ;
	}
	
	public void adiciona (Code code) {
		this.manager.persist(code);
	}
	
	public Code busca (int id) {
		return this.manager.find (Code.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List <Code> buscaTodas() {
		Query query = this.manager.createQuery(" SELECT code FROM Code code");
		return query.getResultList();
	}
}
