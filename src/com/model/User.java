package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="UserTable")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String email;
	@Column(length=250,nullable=false)
	private String password;
	@Column(length=250,nullable=false)
	private String residenceType;
	@Column(length=250,nullable=false)
	private String adress;
	@Column(length=250,nullable=false)
	private String city;
	@Column(length=250,nullable=false)
	private String zip;
	@Column(nullable=false)
	private String residenceUse;
	@Column(length=250,nullable=false)
	private String firstName;
	@Column(length=250,nullable=false)
	private String lastName;
	@Column(length=250,nullable=false)
    private String dob;
	@Column(length=9,nullable=false)
    private String socialSecurityNumber;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public String getRetirmentStatus() {
		return retirmentStatus;
	}
	public void setRetirmentStatus(String retirmentStatus) {
		this.retirmentStatus = retirmentStatus;
	}
	private String retirmentStatus;
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
	
	public String getResidenceType() {
		return residenceType;
	}
	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getResidenceUse() {
		return residenceUse;
	}
	public void setResidenceUse(String residenceUse) {
		this.residenceUse = residenceUse;
	}
	
	
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", residenceType=" + residenceType + ", adress="
				+ adress + ", city=" + city + ", zip=" + zip + ", residenceUse=" + residenceUse + ", firstName="
				+ firstName + ", lastName=" + lastName +  ", socialSecurityNumber="
				+ socialSecurityNumber + ", retirmentStatus=" + retirmentStatus + "]";
	}
	public User() {
		
	}
	
	

}
