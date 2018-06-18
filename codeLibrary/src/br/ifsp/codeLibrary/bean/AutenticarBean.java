package br.ifsp.codeLibrary.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import br.ifsp.codeLibrary.entities.User;
import br.ifsp.codeLibrary.repository.UserRepository;


@ManagedBean
public class AutenticarBean {
	
	private String user;
	private String senha;
	
	public String autenticar(){
	
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("codeLibrary");
		EntityManager manager = factory.createEntityManager();
		
		UserRepository userRepository = 
				new UserRepository(manager);
		
		manager.getTransaction().begin();
		
		User user = userRepository.busca(user, senha);
		
		factory.close();
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		if (usuario != null) {
			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession)ec.getSession(false);
			session.setAttribute("usuario", usuario);
			
			return "home";
		
		} else {
			
			FacesMessage fm = new FacesMessage("Usu�rio e/ou senha inv�lidos.");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(null,fm);
			
			return "login";
		}
		
	}
	
	public String registrarSaida(){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.removeAttribute("usuario");
		
		return "login";
	}

	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
