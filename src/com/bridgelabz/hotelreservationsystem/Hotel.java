package com.bridgelabz.hotelreservationsystem;

public class Hotel {

	private String hotelName;
	private int rateForRegularCustomer;
	private long totalRate;

	// Constructor
	public Hotel(String hotelName, int rateForRegularCustomer) {
		this.hotelName = hotelName;
		this.rateForRegularCustomer = rateForRegularCustomer;
	}

	public Hotel() {
		
	}
	// Setters and Getters
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

	public long getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(long totalRate) {
		this.totalRate = totalRate;
	}

}
