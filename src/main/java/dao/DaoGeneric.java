package dao;

import posmavenhibernate.HibernateUtil;

import java.util.List;

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
	
	public E updateMerge (E entidade) { //salva ou atualiza 
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();
		
		return entidadeSalva;
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
	public E consult( Long id, Class<E> entidade) {
		
		E e = (E) entityManager.find(entidade, id);
		
		return e;
	}
	public void deleteId(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.createNativeQuery(
				"delete from " + entidade.getClass().getSimpleName().toLowerCase() +
				" where id = " + id).executeUpdate();
		
		transaction.commit(); // grava as alterações no banco de dados
	}
	
	public List<E> listar(Class<E> entidade){
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		List<E> list = entityManager.createQuery("from  " + entidade.getName()).getResultList();
		
		transaction.commit();
		return list;
	}
	
}
