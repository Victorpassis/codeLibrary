package br.ifsp.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ifsp.livraria.entities.Editora;
import br.ifsp.livraria.repository.EditoraRepository;

@ManagedBean
public class EditoraBean {
	private String nome;
	private String email;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String cadastrarEditora() {
		Editora ed = new Editora();
		ed.setNome(this.nome);
		ed.setEmail(this.email);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");
		
		EntityManager manager = factory.createEntityManager();
		
		EditoraRepository er = new EditoraRepository(manager);
		
		manager.getTransaction().begin();
		er.adiciona(ed);
		manager.getTransaction().commit();
		factory.close();
		
		return "Sucesso";
	}

}
