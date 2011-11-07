package br.com.wbotelhos.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author Washington Botelho
 * @article http://www.wbotelhos.com.br/2011/11/06/hibernate-relacionamento-manytomany-sem-atributos
 */

@Entity
public class Perfil {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(
		name = "AcessoPerfil",
		joinColumns = @JoinColumn(name = "perfil_id"), inverseJoinColumns = @JoinColumn(name = "acesso_id")
	)
	private Collection<Acesso> acessoList;

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

	public Collection<Acesso> getAcessoList() {
		return acessoList;
	}

	public void setAcessoList(Collection<Acesso> acessoList) {
		this.acessoList = acessoList;
	}

}