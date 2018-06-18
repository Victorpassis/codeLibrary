package br.ifsp.codeLibrary.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ifsp.codeLibrary.entities.User;

public class UserRepository {
	private EntityManager manager ;
	
	public UserRepository (EntityManager manager ) {
		this.manager = manager ;
	}
	
	public void adiciona (User user) {
		this.manager.persist(user);
	}
	
	public User busca (int id) {
		return this.manager.find (User.class, id);
	}
	
	public User busca (String apelido, String senha) {
		Query query = 
				this.manager.createQuery(" SELECT u FROM Usuario u "
						+ "WHERE u.apelido= :apelido AND u.senha= :senha");
	    query.setParameter("apelido",apelido); 
	    query.setParameter("senha",senha);
	    
	    if (query.getResultList() != null && 
	    		query.getResultList().size() != 0) {
	    	return (Usuario) query.getResultList().get(0);
	    } else {
	    	return null;
	    }
	}
	
	@SuppressWarnings("unchecked")
	public List <User> buscaTodas() {
		Query query = this.manager.createQuery(" SELECT user FROM User user");
		return query.getResultList();
	}

}
