package com.bridgelabz.hotelreservationsystem;

public class Hotel {

	private String hotelName;
	private int rateForRegularCustomerWeekDay;
	private int rateForRegularCustomerWeekEnd;
	private long totalRate;
	private int rating;
	private int rateForRewardCustomerWeekDay;
	private int rateForRewardCustomerWeekEnd;

	// Constructor
	public Hotel(String hotelName, int rateForRegularCustomerWeekDay, int rateForRegularCustomerWeekEnd, int rating,
			int rateForRewardCustomerWeekDay, int rateForRewardCustomerWeekEnd) {
		this.hotelName = hotelName;
		this.rateForRegularCustomerWeekDay = rateForRegularCustomerWeekDay;
		this.rateForRegularCustomerWeekEnd = rateForRegularCustomerWeekEnd;
		this.rating = rating;
		this.rateForRewardCustomerWeekDay = rateForRegularCustomerWeekDay;
		this.rateForRegularCustomerWeekEnd = rateForRegularCustomerWeekEnd;
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

	public int getRateForRegularCustomerWeekDay() {
		return rateForRegularCustomerWeekDay;
	}

	public void setRateForRegularCustomerWeekDay(int rateForRegularCustomerWeekDay) {
		this.rateForRegularCustomerWeekDay = rateForRegularCustomerWeekDay;
	}

	public int getRateForRegularCustomerWeekEnd() {
		return rateForRegularCustomerWeekEnd;
	}

	public void setRateForRegularCustomerWeekEnd(int rateForRegularCustomerWeekEnd) {
		this.rateForRegularCustomerWeekEnd = rateForRegularCustomerWeekEnd;
	}

	public long getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(long totalRate) {
		this.totalRate = totalRate;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRateForRewardCustomerWeekDay() {
		return rateForRewardCustomerWeekDay;
	}

	public void setRateForRewardCustomerWeekDay(int rateForRewardCustomerWeekDay) {
		this.rateForRewardCustomerWeekDay = rateForRewardCustomerWeekDay;
	}

	public int getRateForRewardCustomerWeekEnd() {
		return rateForRewardCustomerWeekEnd;
	}

	public void setRateForRewardCustomerWeekEnd(int rateForRewardCustomerWeekEnd) {
		this.rateForRewardCustomerWeekEnd = rateForRewardCustomerWeekEnd;
	}

}
