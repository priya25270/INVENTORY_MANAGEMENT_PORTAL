package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int oId;
private String Status;
private String Date;
private String pordered;

public int getoId() {
	return oId;
}
public void setoId(int oId) {
	this.oId = oId;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
public String getPordered() {
	return pordered;
}
public void setPordered(String pordered) {
	this.pordered = pordered;
}

}