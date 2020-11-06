package dao;

import posmavenhibernate.HibernateUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DaoGeneric <E>{
	
	private EntityManager entityManager= HibernateUtil.geEntityManager();
	
	public void salvar (E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
	}
	
	public E consult (E entidade) {
		
		Object id = HibernateUtil.getPrimaryKey(entidade);
		E e = (E) entityManager.find(entidade.getClass(), id);
		
		return e;
		
	}
	
	public E pesquisar (Long id, E entidade) {
		E e = (E) entityManager.find(entidade.getClass(), id );
		return e;
	}

}
