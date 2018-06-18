package br.ifsp.codeLibrary.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ifsp.codeLibrary.entities.Code;
import br.ifsp.codeLibrary.entities.Language;
import br.ifsp.codeLibrary.entities.User;
import br.ifsp.codeLibrary.repository.CodeRepository;

public class CodeBean {
	
	private static final long serialVersionUID = 1L;
	private String titulo, descricao;
	private double codigo, views;	
	private User user = new User();
	private Language language = new Language();
	
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getCodigo() {
		return codigo;
	}

	public void setCodigo(double codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getViews() {
		return views;
	}

	public void setViews(double views) {
		this.views = views;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	


	public String cadastrarCode(){
		
		Code cd = new Code();
		
		
		EntityManagerFactory factory =  
		  Persistence.createEntityManagerFactory("code_library");
		
		EntityManager manager = factory.createEntityManager();
		
		CodeRepository codeRepository = 
			new CodeRepository(manager);
		
		manager.getTransaction().begin();
		
		codeRepository.adiciona(cd);
		
		manager.getTransaction().commit(); 
		
		factory.close();
		
		
		return "home";
	}
}
