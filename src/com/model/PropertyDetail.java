package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="PropertyDetailTable")
public class PropertyDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	@Transient
	private User applicant;
	@Column(nullable=false)
	private String marketValue;
	@Column(nullable=false)
	private String yearOfOrigin;
	@Column(nullable=false)
	private String squareFootage;
	@Column(nullable=false)
	private String dwellingStyle;
	@Column(nullable=false)
	private String roofMaterial;
	@Column(nullable=false)
	private String typeOfGarage;
	@Column(nullable=false)
	private String numberFullBath;
	@Column(nullable=false)
	private String  numberHalfBath;
	@Column(nullable=false)
	private String swimmingPoolAvailability;
	@Column(nullable=false)
	private String  email;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User getApplicant() {
		return applicant;
	}
	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}
	public String getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}
	public String getYearOfOrigin() {
		return yearOfOrigin;
	}
	public void setYearOfOrigin(String yearOfOrigin) {
		this.yearOfOrigin = yearOfOrigin;
	}
	public String getSquareFootage() {
		return squareFootage;
	}
	public void setSquareFootage(String squareFootage) {
		this.squareFootage = squareFootage;
	}
	public String getDwellingStyle() {
		return dwellingStyle;
	}
	public void setDwellingStyle(String dwellingStyle) {
		this.dwellingStyle = dwellingStyle;
	}
	public String getRoofMaterial() {
		return roofMaterial;
	}
	public void setRoofMaterial(String roofMaterial) {
		this.roofMaterial = roofMaterial;
	}
	public String getTypeOfGarage() {
		return typeOfGarage;
	}
	public void setTypeOfGarage(String typeOfGarage) {
		this.typeOfGarage = typeOfGarage;
	}
	public String getNumberFullBath() {
		return numberFullBath;
	}
	public void setNumberFullBath(String numberFullBath) {
		this.numberFullBath = numberFullBath;
	}
	public String getNumberHalfBath() {
		return numberHalfBath;
	}
	public void setNumberHalfBath(String numberHalfBath) {
		this.numberHalfBath = numberHalfBath;
	}
	public String getSwimmingPoolAvailability() {
		return swimmingPoolAvailability;
	}
	public void setSwimmingPoolAvailability(String swimmingPoolAvailability) {
		this.swimmingPoolAvailability = swimmingPoolAvailability;
	}
	@Override
	public String toString() {
		return "PropertyDetail [applicant=" + applicant + ", marketValue=" + marketValue + ", yearOfOrigin="
				+ yearOfOrigin + ", squareFootage=" + squareFootage + ", dwellingStyle=" + dwellingStyle
				+ ", roofMaterial=" + roofMaterial + ", typeOfGarage=" + typeOfGarage + ", numberFullBath="
				+ numberFullBath + ", numberHalfBath=" + numberHalfBath + ", swimmingPoolAvailability="
				+ swimmingPoolAvailability + "]";
	}
	

}
