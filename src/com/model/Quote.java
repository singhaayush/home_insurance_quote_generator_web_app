package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Quote {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@Column(nullable=false)
private String monthlyPremium;
@Column(nullable=false)
private String dwellingCoverage;
@Column(nullable=false)
private String detachedStructures;
@Column(nullable=false)
private String personalProperty;
@Column(nullable=false)
private String medicalExpense;
@Column(nullable=false)
private String livingExpense;
@Column(nullable=false)
private String deductible;
@Column(nullable=false)
private String  email;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


public String getLivingExpense() {
	return livingExpense;
}
public void setLivingExpense(String livingExpense) {
	this.livingExpense = livingExpense;
}
public String getDeductible() {
	return deductible;
}
public void setDeductible(String deductible) {
	this.deductible = deductible;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getMonthlyPremium() {
	return monthlyPremium;
}
public void setMonthlyPremium(String monthlyPremium) {
	this.monthlyPremium = monthlyPremium;
}
public String getDwellingCoverage() {
	return dwellingCoverage;
}
public void setDwellingCoverage(String dwellingCoverage) {
	this.dwellingCoverage = dwellingCoverage;
}
public String getDetachedStructures() {
	return detachedStructures;
}
public void setDetachedStructures(String detachedStructures) {
	this.detachedStructures = detachedStructures;
}
public String getPersonalProperty() {
	return personalProperty;
}
public void setPersonalProperty(String personalProperty) {
	this.personalProperty = personalProperty;
}
public String getMedicalExpense() {
	return medicalExpense;
}
public void setMedicalExpense(String medicalExpense) {
	this.medicalExpense = medicalExpense;
}
@Override
public String toString() {
	return "<td>" + id + "</td> <td>" + monthlyPremium + "</td><td>" + dwellingCoverage
			+ "</td><td>" + detachedStructures + "</td><td>" + personalProperty
			+ "</td><td>" + medicalExpense + "</td><td>";
}
public Quote() {
	
}


}
