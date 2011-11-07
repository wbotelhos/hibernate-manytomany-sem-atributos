package br.com.wbotelhos.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Washington Botelho
 * @article http://www.wbotelhos.com.br/2011/11/06/hibernate-relacionamento-manytomany-sem-atributos
 */

public class JPAHelper {

	private static EntityManagerFactory emf;
	private static EntityManager manager;

	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("default");
		}

		manager = emf.createEntityManager();
		manager.getTransaction().begin();

		return manager;
	}

	public static void close() {
		manager.getTransaction().commit();
		manager.close();
		emf.close();
	}

}