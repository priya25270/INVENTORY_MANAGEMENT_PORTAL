package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StockMovement {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int stockid;
private String stocklocation;
private String destinationlocation;
private long deliveryamt;
public int getStockid() {
	return stockid;
}
public void setStockid(int stockid) {
	this.stockid = stockid;
}
public String getStocklocation() {
	return stocklocation;
}
public void setStocklocation(String stocklocation) {
	this.stocklocation = stocklocation;
}
public String getDestinationlocation() {
	return destinationlocation;
}
public void setDestinationlocation(String destinationlocation) {
	this.destinationlocation = destinationlocation;
}
public long getDeliveryamt() {
	return deliveryamt;
}
public void setDeliveryamt(long deliveryamt) {
	this.deliveryamt = deliveryamt;
}

}
