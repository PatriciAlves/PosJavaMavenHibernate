package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
	@NamedQuery(name = "PersonUser.consultAll", query = "select u from PersonUser u")
})
public class PersonUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String lastName;
	private String email;
	private String login;
	private String password;
	private int age;

	@OneToMany(mappedBy = "personUser", fetch = FetchType.EAGER)
	private List<PhoneUser>phoneUser;
	
	public List<PhoneUser> getPhoneUser() {
		return phoneUser;
	}
	public void setPhoneUser(List<PhoneUser> phoneUser) {
		this.phoneUser = phoneUser;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "PersonUser [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", login="
				+ login + ", password=" + password + ", age=" + age + "]";
	}
	
	

}
