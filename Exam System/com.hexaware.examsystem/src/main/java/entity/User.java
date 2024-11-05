package entity;


import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	String userid;
	
	@Column
	String name;
	
	@Column
	String email;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(String userid, String name, String email, String password, String role) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column
	String password;
	
	@Column
	String role;

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + "]";
	}
	
	
	
	

}

