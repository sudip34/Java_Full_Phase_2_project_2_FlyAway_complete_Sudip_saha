package com.flyair;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="source_destination")
public class SourceDestination implements Serializable{
	@Id
	@Column(name="ID")
	private int ID;
	
	@Column(name="source_name")
	private String from;
	
	@Column(name="destiantion")
	private String destination;
	
	
	@OneToMany//(mappedBy="SourceDestination")
	@JoinColumn(name="flight_ID", referencedColumnName="ID")
	private List<Flight> flight;
	
	public SourceDestination() {}
	

	public SourceDestination(String from, String destination, List<Flight> flight) {
		super();
		this.from = from;
		this.destination = destination;
		this.flight = flight;
	}


	public SourceDestination(String from, String destination) {
		
		this.from = from;
		this.destination = destination;
	}


	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}


	public List<Flight> getFlight() {
		return flight;
	}


	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}
	
	

}
