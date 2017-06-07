package edu.mum.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Diana Yamaletdinova
 *
 *         May 21, 2017
 */
@Entity(name = "Usercredentials")
public class UserCredentials {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USERCRED_ID")
	private Long id = null;

	@NotEmpty
	@Size(min = 4, max = 19, message = "{Size.name}")
	@Column(name = "USER", nullable = false, unique = true, length = 127)
	String userName;
	
	@NotEmpty
	@Size(min = 4, max = 19, message = "{Size.name}")
	@Column(name = "PASSWORD", nullable = false)
	String password;

	Boolean enabled;
	
	@JsonIgnore
	@OneToOne(mappedBy = "userCredentials", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private User user;

	@OneToMany(mappedBy = "usercred", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Authority> authority = new ArrayList<Authority>();
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
