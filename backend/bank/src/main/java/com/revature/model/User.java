package com.revature.model;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="hash")
	private byte[] hash;
	
	@Column(name="salt")
	private byte[] salt;
	
	@Column(name="usertype")
	private String userType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userprofile")
	private UserProfile userProfile;
	
	@Transient
	private String password;
	
	public User() {
		super();
	}

	public User(int id, String userName, String password, String userType, UserProfile userProfile) {
		super();
		this.id = id;
		this.userName = userName;
		this.userType = userType;
		this.userProfile = userProfile;
		passwordToHash(password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public byte[] getHash() {
		return hash;
	}

	public void setHash(byte[] hash) {
		this.hash = hash;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	public void passwordToHash(String password) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		this.setSalt(salt);

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(salt);

			// This is stored in database in user
			byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
			this.setHash(hashedPassword);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
