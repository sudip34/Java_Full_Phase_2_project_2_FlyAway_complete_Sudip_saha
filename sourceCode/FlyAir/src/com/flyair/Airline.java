package com.flyair;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="airline")
public class Airline implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id@GeneratedValue
	@Column(name="ID")
	private int ID;
	
	@Column(name="airline")
	private String airline;
	
	@OneToMany//(mappedBy="flight")
	private List<Flight> flight;
	
	public Airline() {}
	
	

	public Airline(String airline, List<Flight> flight) {
		super();
		this.airline = airline;
		this.flight = flight;
	}



	public Airline(String airline) {
		super();
		this.airline = airline;
	}
	
	



	public List<Flight> getFlight() {
		return flight;
	}



	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}



	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}
	

}
