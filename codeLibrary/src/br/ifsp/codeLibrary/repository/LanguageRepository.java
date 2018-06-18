package br.ifsp.codeLibrary.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ifsp.codeLibrary.entities.Code;
import br.ifsp.codeLibrary.entities.Language;

public class LanguageRepository {
	private EntityManager manager ;
	
	public LanguageRepository (EntityManager manager ) {
		this.manager = manager ;
	}
	
	public void adiciona (Language language) {
		this.manager.persist(language);
	}
	
	public Language busca (int id) {
		return this.manager.find (Language.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List <Language> buscaTodas() {
		Query query = this.manager.createQuery(" SELECT language FROM Language language");
		return query.getResultList();
	}
}
