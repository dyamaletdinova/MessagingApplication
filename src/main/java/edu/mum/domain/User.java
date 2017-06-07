package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Diana Yamaletdinova
 *
 *         May 21, 2017
 */
@Entity(name = "User")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long id = null;

	@NotEmpty
	@Size(min = 4, max = 19, message = "{Size.name}")
	@Column(name = "FIRSTNAME", nullable = false)
	private String firstName;

	@NotEmpty
	@Size(min = 4, max = 19, message = "{Size.name}")
	@Column(name = "LASTNAME", nullable = false)
	private String lastName;

	@NotEmpty
	@Email(message = "{Email}")
	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Valid
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usercred_id")
	private UserCredentials userCredentials;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Messages> messageList = new ArrayList<Messages>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	public List<Messages> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Messages> messageList) {
		this.messageList = messageList;
	}

}