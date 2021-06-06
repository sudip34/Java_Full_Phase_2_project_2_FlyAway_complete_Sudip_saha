package com.flyair;

public class BookedAirline  {
	private int id;
	private String airlineName;
	private int price;
	private String date;
	public BookedAirline(int id, String airlineName, int price, String date) {
		this.id=id;
		this.airlineName = airlineName;
		this.price = price;
		this.date = date;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "BookedAirline [id=" + id + ", airlineName=" + airlineName + ", price=" + price + ", date=" + date + "]";
	}
	
	

}
