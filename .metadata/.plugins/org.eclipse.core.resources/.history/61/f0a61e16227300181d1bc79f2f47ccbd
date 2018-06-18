package br.ifsp.codeLibrary.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="Code")
public class Code {
	@Id
	@GeneratedValue
	int id;
	
	@Column (name="titulo", nullable=false)
	String titulo;
	
	@Column (name="codigo", nullable=false)
	double codigo;
	
	@Column (name="descricao", nullable=false)
	double descricao;
	
	@Column (name="views", nullable=false)
	double views;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn( name="user_id")  
	User user;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn( name="language_id")  
	Language language;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public double getDescricao() {
		return descricao;
	}

	public void setDescricao(double descricao) {
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

}
