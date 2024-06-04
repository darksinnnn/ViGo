package com.ex.vigo.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USER_PROFILE")
public class UserProfile {
	
	@Id
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "USER_CREDS")
	private String password;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "REGISTRATION_NUMBER")
	private String registrationNumber;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TMSTMP")
	private Date createdTmstmp;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UDPATED_TMSTMP")
	private Date lastUpdatedTmstmp;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreatedTmstmp() {
		return createdTmstmp;
	}

	public void setCreatedTmstmp(Date createdTmstmp) {
		this.createdTmstmp = createdTmstmp;
	}

	public Date getLastUpdatedTmstmp() {
		return lastUpdatedTmstmp;
	}

	public void setLastUpdatedTmstmp(Date lastUpdatedTmstmp) {
		this.lastUpdatedTmstmp = lastUpdatedTmstmp;
	}

	@Override
	public String toString() {
		return "UserProfile [userId=" + userId + ", password=" + password + ", userName=" + userName
				+ ", registrationNumber=" + registrationNumber + ", phoneNumber=" + phoneNumber + ", createdTmstmp="
				+ createdTmstmp + ", lastUpdatedTmstmp=" + lastUpdatedTmstmp + "]";
	}
	
	
}
