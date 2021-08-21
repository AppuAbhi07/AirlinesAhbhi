package com.ngairlines.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Home {

	private static int noOfTicketAvailabe;
	private static int counter;

	public List<Flight> getFlightList() {

		List<Flight> list = new ArrayList<>();

		Flight flight = new Flight();
		flight.setCode("BAM");
		flight.setDest("Mumbai");
		flight.setOrgin("Bengaluru");
		flight.setTicketAvailable(noOfTicketAvailabe);

		list.add(flight);
		return list;
	}

	public static void main(String[] args) {
		Home home = new Home();
		Map<String, String> ticketLayout = new LinkedHashMap<>();
		ticketLayout = home.ticketList(3, 3, 30);
		getMenu(ticketLayout, counter);

	}

	public String bookTicket(String code, int numberOfTicketBooked, Map<String, String> ticketLayout, int counter) {

		if (noOfTicketAvailabe == 0) {
			System.out.println("No Tickets are AVAILABLE");
			getMenu(ticketLayout, counter);
		}
		noOfTicketAvailabe = noOfTicketAvailabe - numberOfTicketBooked;

		Character[] series = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		List<String> list = new LinkedList<>();

		for (String name : ticketLayout.keySet()) {
			list.add(name);
		}
		System.out.println(
				"-----------------------------TICKET BOOKED BY USER------------------------------------------------");
		System.out.printf("%10s %20s", "TICKET NO ", "STATUS");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------");
		String line = System.lineSeparator();
		for (int i = 0; i < numberOfTicketBooked; i++) {

			System.out.printf("%10s %20s", list.get(counter), "BOOKED" + line);
			if (!ticketLayout.get(list.get(counter)).equals("BOOKED")) {
				ticketLayout.replace(list.get(counter), "BOOKED(*)");

			}

			counter++;
		}
		layoutDisplay(ticketLayout);

		if ("BAM".equals(code)) {
			getMenu(ticketLayout, counter);
			return "Tickets are Booked  for Bengaluru to Mumbai and Ticket Count is " + numberOfTicketBooked;

		} else if ("DEC".equals(code)) {
			getMenu(ticketLayout, counter);
			return "Tickets are Booked  for December to Chennai and Ticket Count is " + numberOfTicketBooked;

		} else {
			getMenu(ticketLayout, counter);
			return "Tickets are Booked  for Hyderbad to Mumbai and Ticket Count is " + numberOfTicketBooked;

		}

	}

	public static Map<String, String> ticketList(int rows, int col, int totalRows) {

		noOfTicketAvailabe = (rows + col) * totalRows;
		int seriesCount = rows + col;
		Map<String, String> map = new LinkedHashMap<>();

		Character[] series = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		for (int i = 1; i <= totalRows; i++) {

			for (int j = 0; j < seriesCount; j++) {
				map.put(i + "" + series[j], "AVAILABLE");
			}

		}
		return map;
	}

	public static void getMenu(Map<String, String> ticketLayout, int counter) {

		System.out.println("-----------------------------------------------------------------------------");
		System.out.printf("NG AIRLINES");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------");

		Home home = new Home();
		int bookedCount;
		String msg;

		List<Flight> listOfFlights = new ArrayList<>();
		listOfFlights = home.getFlightList();
		int enteredValue;
		String code;

		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		Scanner scan4 = new Scanner(System.in);
		System.out.println("Enter 1 For availabe Flights with Ticket Count ");
		System.out.println("Enter 2 For Booking the Ticket, only 5 Tickets max can be booked");
		System.out.println("Enter 3 For Designing Flight");
		enteredValue = scan1.nextInt();
		System.out.println("Entered Value is  " + enteredValue);
		if (enteredValue == 1) {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.printf("%10s %20s %20s %5s", "CODE", "ORGIN", "DESTINATION", "TICKET AVAILABLE");
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------");
			for (Flight f : listOfFlights) {
				System.out.format("%10s %20s %20s %5s", f.getCode(), f.getOrgin(), f.getDest(), noOfTicketAvailabe);
				System.out.println();
			}

			System.out.println("-----------------------------------------------------------------------------");

			getMenu(ticketLayout, counter);
		} else if (enteredValue == 2) {

			System.out.println("Enter Number of Tickets to be booked");
			bookedCount = scan2.nextInt();
			if (bookedCount > 5) {
				System.out.println("Only 5 Tickets can be booked !!!");
				getMenu(ticketLayout, counter);
			} else {

				System.out.printf("%10s %20s %20s %5s", "CODE", "ORGIN", "DESTINATION", "TICKET AVAILABLE");
				System.out.println();
				System.out.println("-----------------------------------------------------------------------------");
				for (Flight f : listOfFlights) {
					System.out.format("%10s %20s %20s %5s", f.getCode(), f.getOrgin(), f.getDest(),
							f.getTicketAvailable());
					System.out.println();
				}

				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("Enter the Code number for Ticket Booking");
				code = scan3.nextLine();
				if ("BAM".equals(code)) {
					System.out.println("Orgin is Bengaluru and Destination is Mumbai , Booked count is" + bookedCount);
					msg = home.bookTicket(code, bookedCount, ticketLayout, counter);

				} else {
					System.out.println("Invalid Code");
					getMenu(ticketLayout, counter);
				}

			}

		} else if (enteredValue == 3) {
			System.out.println("Design Flight");
			int column;
			int row;
			int totalRows;
			Map<String, String> map;

			System.out.println("Enter Column Count");
			column = scan4.nextInt();
			System.out.println("Enter row Count");
			row = scan4.nextInt();
			System.out.println("Enter total Rows Count");
			totalRows = scan4.nextInt();
			map = ticketList(row, column, totalRows);
			System.out.println(map);
			getMenu(ticketLayout, counter);
		}

	}

	public static void layoutDisplay(Map<String, String> map) {

		Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.printf("%10s %20s", "TICKET NO ", "STATUS");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------");
		String line = System.lineSeparator();
		while (itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			System.out.printf("%10s %20s", entry.getKey(), entry.getValue() + line);

		}

	}

}
