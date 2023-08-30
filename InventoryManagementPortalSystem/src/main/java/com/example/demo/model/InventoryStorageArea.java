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

@Entity
public class InventoryStorageArea {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="iid")
private int iId;
private String iName;
private String address;
private String city;
private String country;
private String Storagearea;
@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="iid")
private List<StockMovement> smdetail ;
public int getiId() {
	return iId;
}
public void setiId(int iId) {
	this.iId = iId;
}
public String getiName() {
	return iName;
}
public void setiName(String iName) {
	this.iName = iName;
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
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getStoragearea() {
	return Storagearea;
}
public void setStoragearea(String storagearea) {
	Storagearea = storagearea;
}
public List<StockMovement> getSmdetail() {
	return smdetail;
}
public void setSmdetail(List<StockMovement> smdetail) {
	this.smdetail = smdetail;
}


}