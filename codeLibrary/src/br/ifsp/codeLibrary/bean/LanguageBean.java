package br.ifsp.codeLibrary.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ifsp.codeLibrary.entities.Language;
import br.ifsp.codeLibrary.repository.LanguageRepository;

public class LanguageBean {
	
	private static final long serialVersionUID = 1L;
	private String nome, descricao;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	


	public String cadastrarLanguage(){
		
		Language lg = new Language();
		lg.setNome(nome);
		lg.setDescricao(descricao);
		
		
		EntityManagerFactory factory =  
		  Persistence.createEntityManagerFactory("code_library");
		
		EntityManager manager = factory.createEntityManager();
		
		LanguageRepository languageRepository = 
			new LanguageRepository(manager);
		
		manager.getTransaction().begin();
		
		languageRepository.adiciona(lg);
		
		manager.getTransaction().commit(); 
		
		factory.close();
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		
		FacesMessage fm = new FacesMessage("Languagem Cadastrada com sucesso.");
		fm.setSeverity(FacesMessage.SEVERITY_INFO);
		fc.addMessage(null,fm);
		
		return "code";
	}
}
