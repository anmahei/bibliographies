package fi.heiniola.bibliographies.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity	
public class AppUser {
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(name = "username", nullable = false, unique = true)
	private String username; 
	@Column(name = "password", nullable = false)
	private String passwordHashed;
	@Column(name = "role", nullable = false)
	private String role;


	public AppUser() {
		super();
		
	}


	public AppUser(String username, String passwordHashed, String role) {
		super();
		this.username = username;
		this.passwordHashed = passwordHashed;
		this.role = role;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPasswordHashed() {
		return passwordHashed;
	}


	public void setPasswordHashed(String passwordHashed) {
		this.passwordHashed = passwordHashed;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	} 
}
