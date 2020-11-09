package posmavenhibernate;

import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.PersonUser;
import model.PhoneUser;

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

	@Test
	public void testeBuscar2() {
		DaoGeneric<PersonUser> daoGeneric = new DaoGeneric<PersonUser>();

		PersonUser person = daoGeneric.consult(1L, PersonUser.class);
		System.out.println(person);
	}

	@Test
	public void testUpdate() {
		DaoGeneric<PersonUser> daoGeneric = new DaoGeneric<PersonUser>();

		PersonUser person = daoGeneric.consult(2L, PersonUser.class);
		person.setAge(50);
		person.setName("Name update with Merge");

		person = daoGeneric.updateMerge(person);
		System.out.println(person);
	}

	@Test
	public void testDelete() {
		DaoGeneric<PersonUser> daoGeneric = new DaoGeneric<PersonUser>();

		PersonUser person = daoGeneric.consult(11L, PersonUser.class);

		daoGeneric.deleteId(person);

	}

	@Test
	public void testListaConsulta() {
		DaoGeneric<PersonUser> daoGeneric = new DaoGeneric<PersonUser>();

		List<PersonUser> list = daoGeneric.listar(PersonUser.class);

		for (PersonUser personUser : list) {
			System.out.println(personUser);
			System.out.println("---------------------------------------------------");
		}

		}
		@Test
		public void testQueryList() {
			DaoGeneric<PersonUser> daoGeneric = new DaoGeneric<PersonUser>();

			List<PersonUser> list = daoGeneric.getEntityManager()
					.createQuery("from PersonUser")
					.getResultList();
			
			for (PersonUser personUser : list) {
				System.out.println(personUser);
				

			}
		}
		@Test
		public void testQueryListParameter() {
			DaoGeneric<PersonUser> daoGeneric = new DaoGeneric<PersonUser>();
			
			List<PersonUser> list = daoGeneric.getEntityManager()
					.createQuery("from PersonUser where name = :name")
					.setParameter("name", "Patricia")
					.getResultList();
			
			for (PersonUser personUser : list) {
				System.out.println(personUser);
			}
		}
		
		@Test
		public void testeNameQuery1() {
			DaoGeneric<PersonUser> daoGeneric = new DaoGeneric<PersonUser>();
			List<PersonUser> list = daoGeneric .getEntityManager().createNamedQuery("PersonUser.consultAll").getResultList();
			
			for (PersonUser personUser : list) {
				System.out.println(personUser);
				
			}
		
		}
		@Test
		public void  testSavePhone() {
			DaoGeneric daoGeneric = new DaoGeneric();
			PersonUser person = (PersonUser) daoGeneric.consult(11L, PersonUser.class);
			PhoneUser phoneuser = new PhoneUser();
			
			phoneuser.setType("Phone");
			phoneuser.setNumber("11948216150");
			phoneuser.setPersonUser(person);
			daoGeneric.salvar(phoneuser);
			
		}
}
