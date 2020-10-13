package com.bridgelabz.hotelreservationsystem;

public class Hotel {

	private String hotelName;
	private int rateForRegularCustomer;

	//Constructor
	public Hotel(String hotelName, int rateForRegularCustomer) {
		this.hotelName = hotelName;
		this.rateForRegularCustomer = rateForRegularCustomer;
	}

	//Setters and Getters
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRateForRegularCustomer() {
		return rateForRegularCustomer;
	}

	public void setRateForRegularCustomer(int rateForRegularCustomer) {
		this.rateForRegularCustomer = rateForRegularCustomer;
	}

}
