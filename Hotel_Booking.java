package Hotel_Booking;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel_Booking {
	static Scanner scanner = new Scanner(System.in);
	public static int count = 1;
	static Hotel_Booking hotel = new Hotel_Booking();
	public static ArrayList<Guest> guests = new ArrayList<>();
	public static ArrayList<Room> rooms = new ArrayList<>();
	static ArrayList<Booking> bookings = new ArrayList<>();

	public static void main(String[] args) {


		System.out.println("-----------------------------------------------");
		System.out.println("------ Welcome to Hotel Bookings -------");
		System.out.println("-----------------------------------------------");
		System.out.println("Main Menu - please select an option:");

		int choice;
		do {
			System.out.println("1.) Add a guest");
			System.out.println("2.) Add a room");
			System.out.println("3.) Add a booking");
			System.out.println("4.) View bookings");
			System.out.println("5.) Quit");

			choice = Integer.parseInt(scanner.next());
			switch (choice) {
			case 1:
				hotel.Add_Guest();
				break;
			case 2:
				hotel.Add_Room();
				break;
			case 3:
				hotel.Add_Booking();
				break;
			case 4:
				hotel.View_Booking();
				break;
			case 5:
				System.out.println("Thanks for using Hotel Bookings!");
				System.exit(0);
				break;
			default:
				System.out
						.println("You have entered wrong choice. Please re-enter your choice!");
				break;
			}
		} while (true);
	}

	public void View_Booking() {
		String choice = "G";
		do {
			System.out
					.println("Would you like to view [G]uest bookings, [R]oom booking, or e[X]it?");
			choice = scanner.next();
			switch (choice) {
			case "G":
				int flag = 0;
				while (flag == 0) {
					System.out.println("Please enter guest ID:");
					int id;
					id = Integer.parseInt(scanner.next());
					String name = null;

					for (Booking booking : bookings) {
						if (id == booking.get_guest_id()) {
							for (Guest guest : guests) {
								if (id == guest.get_id()) {
									name = guest.get_name();
								}
							}
							System.out.println("Guest " + id + " : " + name);
							System.out.println("Booking : Room "
									+ booking.get_room_number() + ", "
									+ booking.get_number_of_guests()
									+ " guest(s) from "
									+ booking.get_checkin_month() + "/"
									+ booking.get_checkin_day() + " to "
									+ booking.get_checkout_month() + "/"
									+ booking.get_checkout_day() + ".");
							flag = 1;
						}
					}
					if (flag == 0) {
						System.out.print("Guest does not exist. ");
					}
				}
				break;
			case "R":
				int flag_R = 0;
				while (flag_R == 0) {
					System.out.println("Please enter room_number:");
					int room_number;
					room_number = Integer.parseInt(scanner.next());
					String name = null;
					int guest_id;

					for (Booking booking : bookings) {
						if (room_number == booking.get_room_number()) {
							guest_id = booking.get_guest_id();
							for (Guest guest : guests) {
								if (guest_id == guest.get_id()) {
									name = guest.get_name();
								}
							}
							System.out.println("Room " + room_number
									+ " bookings: ");
							System.out.println("Guest " + guest_id + " - "
									+ name + ", "
									+ booking.get_number_of_guests()
									+ " guest(s) from "
									+ booking.get_checkin_month() + "/"
									+ booking.get_checkin_day() + " to "
									+ booking.get_checkout_month() + "/"
									+ booking.get_checkout_day() + ".");
							flag_R = 1;
						}
					}
					if (flag_R == 0) {
						System.out.print("Room does not exist. ");
					}
				}
				break;
			}
		} while (!choice.equals("X"));
	}

	public void Add_Booking() {
		String choice = "A";
		int flag = 0;
		int checkin_number2 = 0;
		int checkout_number2 = 0;
		do {
			int checkin_flag = 0;
			System.out.println("Please enter guest id:");
			int guest_id = Integer.parseInt(scanner.next());
			for (Guest guest : guests) {
				if (guest_id == guest.get_id()) {
					flag = 1;
				}
			}
			if (flag == 1) {
				flag = 0;
				int capacity = 0;
				int checkin_number = 0;
				int checkout_number = 0;
				while (flag == 0) {
					System.out.println("Please enter room number:");
					int room_number = Integer.parseInt(scanner.next());
					for (Room room : rooms) {
						if (room_number == room.get_number()) {
							capacity = room.get_capacity();
							flag = 1;
						}
					}
					for (Booking booking_flag : bookings) {
						if (room_number == booking_flag.get_room_number()) {
							checkin_number = dateToDayNumber(
									booking_flag.get_checkin_month(),
									booking_flag.get_checkin_day());
							checkout_number = dateToDayNumber(
									booking_flag.get_checkout_month(),
									booking_flag.get_checkout_day());
						}
					}
					if (flag == 1) {
						System.out.println("Please enter number of guests:");
						int number_of_guests = Integer.parseInt(scanner.next());
						if (capacity >= number_of_guests) {
							int checkin_month = 0;
							int checkin_day = 0;
							int checkout_month = 0;
							int checkout_day = 0;
							flag = 2;
							while (flag == 2) {
								while (flag == 2) {
									System.out
											.println("Please enter check-in month:");
									checkin_month = Integer.parseInt(scanner
											.next());
									flag = 1;
									if (!(checkin_month >= 1 && checkin_month <= 12)) {
										System.out.print("Invalid month. ");
										flag = 2;
									}
								}
								flag = 2;
								while (flag == 2) {
									System.out
											.println("Please enter check-in day:");
									checkin_day = Integer.parseInt(scanner
											.next());
									flag = 1;
									if (!(checkin_day >= 1 && checkin_day <= 31)) {
										System.out.print("Invalid day. ");
										flag = 2;
									}
								}
								flag = 2;
								while (flag == 2) {
									System.out
											.println("Please enter check-out month:");
									checkout_month = Integer.parseInt(scanner
											.next());
									flag = 1;
									if (!(checkout_month >= 1 && checkout_month <= 12)) {
										System.out.print("Invalid month. ");
										flag = 2;
									}
								}
								flag = 2;
								while (flag == 2) {
									System.out
											.println("Please enter check-out day:");
									checkout_day = Integer.parseInt(scanner
											.next());
									flag = 1;
									if (!(checkout_day >= 1 && checkout_day <= 31)) {
										System.out.print("Invalid day. ");
										flag = 2;
									}
								}
								int check_checkin = dateToDayNumber(
										checkin_month, checkin_day);
								int check_checkout = dateToDayNumber(
										checkout_month, checkout_day);
								if (check_checkout < check_checkin) {
									System.out
											.println("Invalid checkin and checkout dates");
									flag = 2;
								}
							}
							for (Booking booking_flag : bookings) {
								if (room_number == booking_flag
										.get_room_number()) {
									checkin_number = dateToDayNumber(
											booking_flag.get_checkin_month(),
											booking_flag.get_checkin_day());
									checkout_number = dateToDayNumber(
											booking_flag.get_checkout_month(),
											booking_flag.get_checkout_day());
									checkin_number2 = dateToDayNumber(
											checkin_month, checkin_day);
									checkout_number2 = dateToDayNumber(
											checkout_month, checkout_day);
									if (((checkin_number2 >= checkin_number) && (checkin_number2 <= checkout_number))
											|| ((checkout_number2 >= checkin_number) && (checkout_number2 <= checkout_number))
											|| ((checkin_number2 < checkin_number) && (checkout_number2 > checkout_number))) {
										checkin_flag = 1;
									}
								}
							}
							if (checkin_flag == 1) {
								System.out
										.print("Room is not available during that period. ");
								checkin_flag = 0;

								while (checkin_flag == 0) {
									flag = 0;
									checkin_flag = 1;
									System.out
											.println("Please enter new room number:");
									int room_number1 = Integer.parseInt(scanner
											.next());
									for (Room room : rooms) {
										if (room_number1 == room.get_number()) {
											capacity = room.get_capacity();
											flag = 1;
										}
									}
									for (Booking booking_flag : bookings) {
										if (room_number1 == booking_flag
												.get_room_number()) {
											checkin_number = dateToDayNumber(
													booking_flag
															.get_checkin_month(),
													booking_flag
															.get_checkin_day());
											checkout_number = dateToDayNumber(
													booking_flag
															.get_checkout_month(),
													booking_flag
															.get_checkout_day());
											checkin_number2 = dateToDayNumber(
													checkin_month, checkin_day);
											checkout_number2 = dateToDayNumber(
													checkout_month,
													checkout_day);
											if (((checkin_number2 >= checkin_number) && (checkin_number2 <= checkout_number))
													|| ((checkout_number2 >= checkin_number) && (checkout_number2 <= checkout_number))
													|| ((checkin_number2 < checkin_number) && (checkout_number2 > checkout_number))) {
												checkin_flag = 0;
											}
										}
									}
									if (flag == 1) {
										if (number_of_guests < capacity) {
											if (checkin_flag == 0) {
												checkin_flag = 0;
												System.out
														.print("Room is not available during that period. ");
											} else {
												Booking booking = new Booking();
												booking.set_data(guest_id,
														number_of_guests,
														room_number1,
														checkin_day,
														checkin_month,
														checkout_day,
														checkout_month);
												bookings.add(booking);
												System.out
														.println("*** Booking successful! *** ");
												checkin_flag = 1;
												flag = 1;
											}
										} else {
											System.out
													.print("Guest count exceeds room capacity of:  "
															+ capacity + " ");
											checkin_flag = 0;
										}
									} else {
										System.out
												.print("Room does not exist. ");
										checkin_flag = 0;
									}
								}
							} else {
								Booking booking = new Booking();
								booking.set_data(guest_id, number_of_guests,
										room_number, checkin_day,
										checkin_month, checkout_day,
										checkout_month);
								bookings.add(booking);
								System.out
										.println("*** Booking successful! *** ");
								flag = 1;
							}
							System.out
									.println("Would you like to [A]dd a new booking or [R]eturn to the previous menu?");
							checkin_flag = 1;
							choice = scanner.next();
						} else {
							System.out
									.print("Guest count exceeds room capacity of:  "
											+ capacity + " ");
							flag = 0;
						}
					} else {
						System.out.print("Room does not exist. ");
						flag = 0;
					}
				}
			} else {
				System.out.println("Guest does not exist.");
				flag = 0;
			}
		} while (choice.equals("A"));

	}

	public int dateToDayNumber(int month, int day) {
		// Catch invalid input and return early
		if (month < 1 || month > 12 || day < 1 || day > 31)
			return 0;
		if (month == 1)
			return day;
		if (month == 2)
			return 31 + day;
		if (month == 3)
			return 59 + day;
		if (month == 4)
			return 90 + day;
		if (month == 5)
			return 120 + day;
		if (month == 6)
			return 151 + day;
		if (month == 7)
			return 181 + day;
		if (month == 8)
			return 212 + day;
		if (month == 9)
			return 243 + day;
		if (month == 10)
			return 273 + day;
		if (month == 11)
			return 304 + day;
		return 334 + day;
	}

	public void Add_Guest() {
		String choice;
		do {
			System.out.println("Please enter guest name:");
			String name = scanner.next();
			Guest guest = new Guest();
			guest.set_name(name);
			guests.add(guest);
			System.out.println("Guest " + name
					+ " has been created with guest ID: " + (count - 1));
			System.out
					.println("Would you like to [A]dd a new guest or [R]eturn to the previous menu?");
			choice = scanner.next();
		} while (choice.equals("A"));

	}

	public void Add_Room() {
		String choice = "A";
		int flag = 0;
		do {
			System.out.println("Please enter room number:");
			int number = Integer.parseInt(scanner.next());
			for (Room room : rooms) {
				if (number == room.get_number()) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println("Please enter room capacity:");
				int capacity = Integer.parseInt(scanner.next());
				Room room = new Room();
				room.set_data(number, capacity);
				rooms.add(room);
				System.out
						.println("Would you like to [A]dd a new guest or [R]eturn to the previous menu?");
				choice = scanner.next();
			} else {
				System.out.print("Room already exists. ");
				flag = 0;
				choice = "A";
			}
		} while (choice.equals("A"));

	}

	class Booking {
		public int guest_ID;
		public int room_Number;
		public int number_of_guests;
		public int checkin_day;
		public int checkin_month;
		public int checkout_day;
		public int checkout_month;

		public void set_data(int guest_ID, int number_of_guests,
				int room_Number, int checkin_day, int checkin_month,
				int checkout_day, int checkout_month) {
			this.guest_ID = guest_ID;
			this.room_Number = room_Number;
			this.checkin_day = checkin_day;
			this.checkin_month = checkin_month;
			this.checkout_day = checkout_day;
			this.checkout_month = checkout_month;
			this.number_of_guests = number_of_guests;
		}

		public int get_guest_id() {
			return guest_ID;
		}

		public int get_number_of_guests() {
			return number_of_guests;
		}

		public int get_room_number() {
			return room_Number;
		}

		public int get_checkin_day() {
			return checkin_day;
		}

		public int get_checkin_month() {
			return checkin_month;
		}

		public int get_checkout_day() {
			return checkout_day;
		}

		public int get_checkout_month() {
			return checkout_month;
		}
	}

	class Guest {
		public String guest_name;
		public int ID;

		public void set_name(String name) {
			guest_name = name;
			ID = count++;
		}

		public String get_name() {
			return guest_name;
		}

		public int get_id() {
			return ID;
		}
	}

	class Room {
		public int number;
		public int capacity;

		public void set_data(int number, int capacity) {
			this.number = number;
			this.capacity = capacity;
		}

		public int get_number() {
			return number;
		}

		public int get_capacity() {
			return capacity;
		}
	}

}
