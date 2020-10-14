package com.bridgelabz.hotelreservationsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {
	static int noOfWeekDays = 0;
	static int noOfWeekEnds = 0;

	private List<Hotel> hotelList = new ArrayList<Hotel>();

	public void addHotel(String hotelName, int rateForRegularCustomerWeekDay, int rateForRegularCustomerWeekEnd,
			int rating) {
		Hotel hotel = new Hotel(hotelName, rateForRegularCustomerWeekDay, rateForRegularCustomerWeekEnd, rating);
		hotelList.add(hotel);
	}

	// To find number of weekends and weekdays
	public void findDays(String startDate, String endDate) {

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
		while (!nextDate.after(dateEnd)) {
			if (nextDate.getDay() == 0 || nextDate.getDay() == 6)
				noOfWeekEnds++;
			else
				noOfWeekDays++;
			nextDate.setTime(nextDate.getTime() + (1000 * 60 * 60 * 24));
		}
	}

	// To find cheapest best rated hotel
	public Hotel cheapestBestHotel() {
		Hotel cheapHotel = new Hotel();
		long totalRate = Long.MAX_VALUE;
		String hotelName = "";
		for (Hotel hotel : hotelList) {
			long hotelRate = hotel.getRateForRegularCustomerWeekDay() * noOfWeekDays
					+ hotel.getRateForRegularCustomerWeekEnd() * noOfWeekEnds;
			if (hotelRate < totalRate || (hotelRate == totalRate && hotel.getRating() > cheapHotel.getRating())) {
				totalRate = hotelRate;
				hotelName = hotel.getHotelName();
				cheapHotel.setRating(hotel.getRating());
			}
		}
		cheapHotel.setHotelName(hotelName);
		cheapHotel.setTotalRate(totalRate);
		return cheapHotel;
	}

	// To find best rated hotel
	public Hotel bestRatedHotel() {
		Hotel bestHotel = new Hotel();
		long totalRate = Long.MAX_VALUE;
		String hotelName = "";
		for (Hotel hotel : hotelList) {
			long hotelRate = hotel.getRateForRegularCustomerWeekDay() * noOfWeekDays
					+ hotel.getRateForRegularCustomerWeekEnd() * noOfWeekEnds;
			if (hotel.getRating() > bestHotel.getRating()) {
				totalRate = hotelRate;
				hotelName = hotel.getHotelName();
				bestHotel.setRating(hotel.getRating());
			}
		}
		bestHotel.setHotelName(hotelName);
		bestHotel.setTotalRate(totalRate);
		return bestHotel;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Welcome Message
		System.out.println("Welcome to Hotel Reservation System");

		HotelReservation hotelReservation = new HotelReservation();

		// Add hotels
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 150, 50, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);

		System.out.println("Enter the start date in ddMMMYYYY format");
		String startDate = sc.next();
		System.out.println("Enter the end date in ddMMMYYYY format");
		String endDate = sc.next();

		// To find cheapest best rated hotel
		hotelReservation.findDays(startDate, endDate);
		Hotel cheapHotel = hotelReservation.cheapestBestHotel();
		System.out.println(
				"Cheapest Hotel name " + cheapHotel.getHotelName() + "\n" + "Total Rate " + cheapHotel.getTotalRate());
		System.out.println("Rating " + cheapHotel.getRating());

		// To find best rated hotel
		Hotel bestHotel = hotelReservation.bestRatedHotel();
		System.out.println(
				"Best Rated Hotel name " + bestHotel.getHotelName() + "\n" + "Total Rate " + bestHotel.getTotalRate());
		System.out.println("Rating " + bestHotel.getRating());

		sc.close();
	}

}
