package br.ifsp.codeLibrary.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Language")
public class Language {
	@Id
	@GeneratedValue
	int id;

	@Column (name="nome", nullable=false)
	String nome;

	@Column (name="descricao", nullable=false)
	double descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getDescricao() {
		return descricao;
	}

	public void setDescricao(double descricao) {
		this.descricao = descricao;
	}

}
