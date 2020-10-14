package com.bridgelabz.hotelreservationsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {
	static int noOfWeekDays = 0;
	static int noOfWeekEnds = 0;

	private List<Hotel> hotelList = new ArrayList<Hotel>();

	public void addHotel(String hotelName, int rateForRegularCustomerWeekDay, int rateForRegularCustomerWeekEnd,
			int rating, int rateForRewardCustomerWeekDay, int rateForRewardCustomerWeekEnd) {
		Hotel hotel = new Hotel(hotelName, rateForRegularCustomerWeekDay, rateForRegularCustomerWeekEnd, rating,
				rateForRewardCustomerWeekDay, rateForRewardCustomerWeekEnd);
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

	// To calculate total rate
	public long calculateTotalRate(Hotel hotel, String type) {
		long hotelRate = 0;
		if (type.equals("regular") || type.equals("Regular"))
			hotelRate = hotel.getRateForRegularCustomerWeekDay() * noOfWeekDays
					+ hotel.getRateForRegularCustomerWeekEnd() * noOfWeekEnds;
		else if (type.equals("reward") || type.equals("Reward"))
			hotelRate = hotel.getRateForRewardCustomerWeekDay() * noOfWeekDays
					+ hotel.getRateForRewardCustomerWeekEnd() * noOfWeekEnds;
		return hotelRate;
	}

	// To set total rates for hotels
	public void setTotalRatesForHotels(String type) {
		hotelList.stream().forEach(hotel -> hotel.setTotalRate(calculateTotalRate(hotel, type)));
	}

	// To find cheapest best rated hotel
	public Hotel cheapestBestHotel(String type) {
		setTotalRatesForHotels(type);
		long minimumRate = hotelList.stream().mapToLong(Hotel::getTotalRate).min().orElse(0);
		Hotel cheapHotel = hotelList.stream().filter(hotel -> (hotel.getTotalRate() == minimumRate))
				.max(Comparator.comparingInt(Hotel::getRating)).orElse(null);
		return cheapHotel;
	}

	// To find best rated hotel
	public Hotel bestRatedHotel(String type) {
		setTotalRatesForHotels(type);
		Hotel besthotel = hotelList.stream().max(Comparator.comparingInt(Hotel::getRating)).orElse(null);
		return besthotel;
	}

	// To add all the hotels to list
	public void addHotelstoList() {
		addHotel("Lakewood", 110, 90, 3, 80, 80);
		addHotel("Bridgewood", 150, 50, 4, 110, 50);
		addHotel("Ridgewood", 220, 150, 5, 100, 40);
	}

	// To get customer type
	public String getCustomerType(Scanner sc) {
		boolean isValidate = false;
		String type = "";
		while (true) {
			System.out.println("Enter customer type Regular/Reward");
			type = sc.nextLine();
			isValidate = type.matches("^regular|Regular|reward|Reward$");
			if (isValidate)
				break;
			else
				System.out.println("Invalid!!");
		}
		return type;
	}

	// To get start and end dates
	public void getDates(Scanner sc) {
		System.out.println("Enter the start date in ddMMMYYYY format");
		String startDate = sc.next();
		System.out.println("Enter the end date in ddMMMYYYY format");
		String endDate = sc.next();
		findDays(startDate, endDate);
	}

	// To print hotels
	public void print(Hotel cheapestBestHotel, Hotel bestRatedHotel) {

		System.out.println("Cheapest Best Rated Hotel name " + cheapestBestHotel.getHotelName() + "\n" + "Total Rate "
				+ cheapestBestHotel.getTotalRate());
		System.out.println("Rating " + cheapestBestHotel.getRating());
		System.out.println("Best Rated Hotel name " + bestRatedHotel.getHotelName() + "\n" + "Total Rate "
				+ bestRatedHotel.getTotalRate());
		System.out.println("Rating " + bestRatedHotel.getRating());

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Welcome Message
		System.out.println("Welcome to Hotel Reservation System");

		HotelReservation hotelReservation = new HotelReservation();

		// Add hotels
		hotelReservation.addHotelstoList();

		// get customer type
		String type = hotelReservation.getCustomerType(sc);

		// get dates
		hotelReservation.getDates(sc);

		// To find cheapest best rated hotel
		Hotel cheapestBestHotel = hotelReservation.cheapestBestHotel(type);

		// To find best rated hotel
		Hotel bestRatedHotel = hotelReservation.bestRatedHotel(type);

		// To print output
		hotelReservation.print(cheapestBestHotel, bestRatedHotel);

		sc.close();
	}

}
