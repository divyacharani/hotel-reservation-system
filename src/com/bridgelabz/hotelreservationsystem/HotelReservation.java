package com.bridgelabz.hotelreservationsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {

	private List<Hotel> hotelList = new ArrayList<Hotel>();

	public void addHotel(String hotelName, int rateForRegularCustomerWeekDay, int rateForRegularCustomerWeekEnd) {
		Hotel hotel = new Hotel(hotelName, rateForRegularCustomerWeekDay, rateForRegularCustomerWeekEnd);
		hotelList.add(hotel);
	}

	// To find cheapest hotel
	public Hotel cheapestHotel(String startDate, String endDate) {

		SimpleDateFormat format = new SimpleDateFormat("ddMMMyyyy");
		Date dateStart = null;
		Date dateEnd = null;
		try {
			dateStart = format.parse(startDate);
			dateEnd = format.parse(endDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date nextDate = dateStart;
		long noOfWeekDays = 0;
		long noOfWeekEnds = 0;
		while (!nextDate.after(dateEnd)) {
			if (nextDate.getDay() == 0 || nextDate.getDay() == 6)
				noOfWeekEnds++;
			else
				noOfWeekDays++;
			nextDate.setTime(nextDate.getTime()+(1000*60*60*24));
		}
		Hotel cheapHotel = new Hotel();
		long totalRate = Long.MAX_VALUE;
		String hotelName = "";
		for (Hotel hotel : hotelList) {
			long hotelRate = hotel.getRateForRegularCustomerWeekDay() * noOfWeekDays + hotel.getRateForRegularCustomerWeekEnd() * noOfWeekEnds ;
			if (hotelRate < totalRate) {
				totalRate = hotelRate;
				hotelName = hotel.getHotelName();
			}
		}
		cheapHotel.setHotelName(hotelName);
		cheapHotel.setTotalRate(totalRate);
		return cheapHotel;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Welcome Message
		System.out.println("Welcome to Hotel Reservation System");

		HotelReservation hotelReservation = new HotelReservation();

		// Add hotels
		hotelReservation.addHotel("Lakewood", 110, 90);
		hotelReservation.addHotel("Bridgewood", 160, 60);
		hotelReservation.addHotel("Ridgewood", 220, 150);

		System.out.println("Enter the start date in ddMMMYYYY format");
		String startDate = sc.next();
		System.out.println("Enter the end date in ddMMMYYYY format");
		String endDate = sc.next();

		// To find cheapest hotel
		Hotel cheapHotel = hotelReservation.cheapestHotel(startDate, endDate);
		System.out.println(
				"Cheapest Hotel name " + cheapHotel.getHotelName() + "\n" + "Total Rate " + cheapHotel.getTotalRate());

		sc.close();
	}

}
