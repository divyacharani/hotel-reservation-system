package com.bridgelabz.hotelreservationsystem;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {

	private List<Hotel> hotelList = new ArrayList<Hotel>();

	public void addHotel(String hotelName, int rateForRegularCustomer) {
		Hotel hotel = new Hotel(hotelName, rateForRegularCustomer);
		hotelList.add(hotel);
	}

	public static void main(String[] args) {

		// Welcome Message
		System.out.println("Welcome to Hotel Reservation System");
		
		HotelReservation hotelReservation = new HotelReservation();

		// Add hotels
		hotelReservation.addHotel("Lakewood", 110);
		hotelReservation.addHotel("Bridgewood", 160);
		hotelReservation.addHotel("Ridgewood", 220);

	}

}
