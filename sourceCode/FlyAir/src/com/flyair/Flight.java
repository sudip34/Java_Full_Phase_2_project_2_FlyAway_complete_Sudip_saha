package com.flyair;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
@Entity
@Table(name="flight")
public class Flight implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="flight_ID")
	private int flightID;
	

	@Column(name="airline_ID")
	private int airlineID;
	
	@Column(name="travel_date")
	private String date;
	
	@Column(name="price")
	private int singleTicketPrice;
	

	public Flight() {}
	
	
	





	public Flight(int flightID, int airlineID, String date, int singleTicketPrice) {
		super();
		this.flightID = flightID;
		this.airlineID = airlineID;
		this.date = date;
		this.singleTicketPrice = singleTicketPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlightID() {
		return flightID;
	}
	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}
	public int getAirlineID() {
		return airlineID;
	}
	public void setAirlineID(int airlineID) {
		this.airlineID = airlineID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSingleTicketPrice() {
		return singleTicketPrice;
	}
	public void setSingleTicketPrice(int singleTicketPrice) {
		this.singleTicketPrice = singleTicketPrice;
	}

	
	

}
