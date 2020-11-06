package posmavenhibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.PersonUser;

public class TestHibernate {
	
	@Test
	public void testHibernateUtil() {
		DaoGeneric<PersonUser> daoGeneric = new DaoGeneric<PersonUser>();
		
		PersonUser person = new PersonUser();
		
		person.setAge(26);
		person.setLogin("Test");
		person.setName("Patricia ");
		person.setLastName("Alves");
		person.setPassword("192168");
		person.setEmail("patricia.18_08@hotmail.com");
		
		daoGeneric.salvar(person);
		
	}
	
		@Test
		public void testeBuscar() {
			DaoGeneric<PersonUser> daoGeneric = new DaoGeneric<PersonUser>();
			PersonUser person = new PersonUser();
			person.setId(2L);
			person = daoGeneric.consult(person);
			System.out.println(person);
		}
}
