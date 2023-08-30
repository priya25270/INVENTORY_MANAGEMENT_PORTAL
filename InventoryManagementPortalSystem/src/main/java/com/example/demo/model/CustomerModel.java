package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class CustomerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
private int custId;
private String custName;
private long aadharnum;
private String address;
private String city;
private String state;
private String email;
private String country;
private long mobnum;


@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="id")
private InventoryStorageArea idetail;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="id")
private List<OrderModel> odetail ;

public int getCustId() {
	return custId;
}

public void setCustId(int custId) {
	this.custId = custId;
}

public String getCustName() {
	return custName;
}

public void setCustName(String custName) {
	this.custName = custName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public long getMobnum() {
	return mobnum;
}

public void setMobnum(long mobnum) {
	this.mobnum = mobnum;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
public long getAadharnum() {
	return aadharnum;
}

public void setAadharnum(long aadharnum) {
	this.aadharnum = aadharnum;
}

public List<OrderModel> getOdetail() {
	return odetail;
}

public void setOdetail(List<OrderModel> odetail) {
	this.odetail = odetail;
}

public InventoryStorageArea getIdetail() {
	return idetail;
}

public void setIdetail(InventoryStorageArea idetail) {
	this.idetail=idetail;
}

}