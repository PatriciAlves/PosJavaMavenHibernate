package posmavenhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	public static EntityManagerFactory factory = null;
	
	static {
		init();
	}
	
	private static void init() {
		
		try {
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory("pos-maven-hibernate");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static EntityManager geEntityManager() {
		return factory.createEntityManager();
	}
	public static Object getPrimaryKey(Object entity) { //Retorna a primary Key
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}
}
