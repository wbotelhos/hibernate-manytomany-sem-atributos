package br.com.wbotelhos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Washington Botelho
 * @article http://www.wbotelhos.com.br/2011/11/06/hibernate-relacionamento-manytomany-sem-atributos
 */

@Entity
public class Acesso {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}