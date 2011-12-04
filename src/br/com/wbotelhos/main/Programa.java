package br.com.wbotelhos.main;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.EntityManager;

import br.com.wbotelhos.helper.JPAHelper;
import br.com.wbotelhos.model.Acesso;
import br.com.wbotelhos.model.Perfil;

/**
 * @author Washington Botelho
 * @article http://www.wbotelhos.com.br/2011/11/06/hibernate-relacionamento-manytomany-sem-atributos
 */

public class Programa {

	public static void main(String[] args) {
		EntityManager manager = JPAHelper.getEntityManager();

		// Cria e salva o acesso 1.
		Acesso acesso1 = new Acesso();
		acesso1.setNome("acesso-1");
		acesso1 = manager.merge(acesso1);

		// Cria e salva o acesso 2.
		Acesso acesso2 = new Acesso();
		acesso2.setNome("acesso-2");
		acesso2 = manager.merge(acesso2);

		// Cria a lista dos acessos.
		Collection<Acesso> acessoList = Arrays.asList(acesso1, acesso2);

		// Cria e salva o perfil 1 com os dois acesso.
		Perfil perfil1 = new Perfil();
		perfil1.setNome("perfil-1");
		perfil1.setAcessoList(acessoList);
		manager.merge(perfil1);

		// Cria e salva o perfil 2 com os dois acesso.
		Perfil perfil2 = new Perfil();
		perfil2.setNome("perfil-2");
		perfil2.setAcessoList(acessoList);
		manager.merge(perfil2);

		JPAHelper.close();
	}

}