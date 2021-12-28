
import java.util.Scanner;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int opt1, opt2, opt3;
		char option;
		System.out.println("\t\t\t*********WELCOME TO ONLINE DELIVERY SYSTEM*********");
		System.out.println("\t\t\t---------------customer is our number 1 priority!--");
		do {
			System.out.println("\n\n\nPLEASE ENTER 1 IF YOU ARE CUSTOMER !!");
			System.out.println("PLEASE ENTER 2 IF YOU ARE EMPLOYEE !!");

			opt1 = sc.nextInt();
			switch (opt1) {
			case 1:
				Customer c = new Customer();
				System.out.println("WELCOME DEAR CUSTOMER!!");
				do {
					System.out.println("\n-------MENU-------");
					System.out.println("Press 1 to place order");
					System.out.println("Press 2 to display order");
					System.out.println("Press 3 to track order");
					System.out.println("Press 4 to EXIT");
					opt2 = sc.nextInt();
					switch (opt2) {
					case 1:
						c.accept_order();
						System.out.println("ORDER ACCEPTED");
						break;
					case 2:
						c.display_order();
						break;
					case 3:
                        c.track_order();
						break;
					case 4:
						System.out.println("--THANK YOU!---");
						System.out.println("--DO VISIT AGAIN SOON!---");
						break;
					default:
						System.out.println("Please enter valid option");

					}
					System.out.println("\n---DEAR USER would you like to place or visit another order!!--");
					System.out.println("---IF YES,input y else input n!!---");

					option = sc.next().charAt(0);
				} while (option == 'y');
				break;
			case 2:
				System.out.println("WELCOME EMPLOYEE!!");
				Employee e = new Employee();
				do {
					System.out.println("\n-------MENU-------");
					System.out.println("Press 1 to DISPLAY LIST ");
					System.out.println("Press 2 to UPDATE DETAILS ");// list ,upd status
					System.out.println("Press 3 to VIEW TODAYS QUEUE");
					System.out.println("Press 4 to EXIT");
					opt2 = sc.nextInt();
					switch (opt2) {
					case 1:
						e.list_display();
						break;
					case 2:
						e.update_list();
						break;
					case 3:
						e.display_queue();
						break;
					case 4:
						System.out.println("--THANK YOU!---");
						break;
					default:
						System.out.println("Please enter valid option");
					}
					System.out.println("\nDEAR USER would you like to edit or visit another order");
					System.out.println("IF YES,input y else input n");

					option = sc.next().charAt(0);
				} while (option == 'y');
				break;
			default:
				System.out.println("Please enter valid option");
			}
			System.out.println("\n\n\t\t\tTO RETURN TO MAIN MENU PRESS 1,else PRESS 0");
			opt3 = sc.nextInt();
		} while (opt3 != 0);
		System.out.println("----THANKYOU!----");
	}
}

class details {
	String name, order;
	int price, size, id, time, weight;
	String end_des, status;

}

class Customer {

	static Scanner sc = new Scanner(System.in);
	int i=0,n=0,num=0,add=0;
	details user[] = new details[50];

	void accept_order() {
		int op, id = 0;
		num=n;
		System.out.println("Enter the number of orders you want to place");
		add = sc.nextInt();
		n = num + add;
		

		for (i = num; i < (n); i++)
		{
			user[i] = new details();
			System.out.println("\nEnter details for order no " + (i + 1) + " :");
			System.out.println("Please enter NAME:");
			user[i].id=i+1;
			user[i].name = sc.next();
			System.out.println("\nAVAILABLE BOUQUETS:");
			System.out.println("Please enter ORDER:");
			System.out.println("PRESS 1 FOR ROSE FLOWERS");
			System.out.println("PRESS 2 FOR LILY FLOWERS");
			System.out.println("PRESS 3 FOR ORCHID FLOWERS");
			op = sc.nextInt();
			if (op == 1) {
				user[i].order = "rose";
				System.out.println("ROSE FLOWERS BOUQUET BOOKED");
			}
			if (op == 2) {
				user[i].order = "lily";
				System.out.println("LILY FLOWERS BOUQUET BOOKED");
			}
			if (op == 3) {
				user[i].order = "orchid";
				System.out.println("ORCHID FLOWERS BOUQUET BOOKED");
			}
			System.out.println("\nEnter the size of Bouquet as per S-small, M-medium ,L-large:");
			user[i].size = sc.next().charAt(0);
//assign price according to size
			if (user[i].size == 'S' || user[i].size == 's') {
				user[i].price = 150;
				System.out.println("SIZE S BOOKED!(PRICE=150 ruppes)");
			} else if (user[i].size == 'M' || user[i].size == 'm') {
				user[i].price = 300;
				System.out.println("SIZE M BOOKED!(PRICE=300 ruppes)");
			} else if (user[i].size == 'L' || user[i].size == 'l') {
				user[i].price = 450;
				System.out.println("SIZE L BOOKED!(PRICE=450ruppes)");
			}

			System.out.println("\nAVAILABLE AREAS FOR DELIVERY:");
			System.out.println("Enter 1 for KARVENAGAR COLLECTION CENTRE");
			System.out.println("Enter 2 for DECCAN COLLECTION CENTRE");
			System.out.println("Enter 3 for BANER COLLECTION CENTRE");
			System.out.println("Enter 4 for AUNDH COLLECTION CENTRE");
			System.out.println("Enter 5 for WARJE COLLECTION CENTRE");
			int c = sc.nextInt();

			if (c == 1) {
				user[i].end_des = "KARVENAGAR";
				user[i].weight = 1;
			}
			if (c == 2) {
				user[i].end_des = "DECCAN";
				user[i].weight = 2;
			}
			if (c == 3) {
				user[i].end_des = "BANER";
				user[i].weight = 3;
			}
			if (c == 4) {
				user[i].end_des = "AUNDH";
				user[i].weight = 4;
			}
			if (c == 5) {
				user[i].end_des = "WARJE";
				user[i].weight = 5;
			}
			id = id + 1;
			user[i].id = id;
			
			
			System.out.println("PLease enter  time for delivery:");
			System.out.println("\nAVAILABLE TIME SLOT:");

			System.out.println("Please enter required time slot:");

			System.out.println("PRESS 1 FOR 8 am t0 10 am");

			System.out.println("PRESS 2 FOR 10 am to 12 am");

			System.out.println("PRESS 3 FOR 12 am to 2 pm");
			System.out.println("PRESS 4 FOR 2 pm to 4 pm");
			System.out.println("PRESS 5 FOR 4 pm to 6 pm");
			System.out.println("PRESS 6 FOR 6 am to 8 pm");
			
			int t = sc.nextInt();

			if (t == 1) {

				user[i].time = 8;

				System.out.println("8 am to 10 am time slot BOOKED");

			}

			if (t == 2) {

				user[i].time = 10;
				System.out.println("10 am to 12 pm time slot BOOKED");

			}

			if (t == 3) {

				user[i].time = 12;
				System.out.println("12  pm to 2 pm time slot BOOKED");

			}
			if (t== 4) {

				user[i].time = 2;
				System.out.println("2 pm to 4 pm time slot BOOKED");

			}
			if (t == 5) {

				user[i].time = 5;
				System.out.println("4 pm to 6 pm time slot BOOKED");
			}
			if (t == 6) {

				user[i].time = 6;
				System.out.println("6 pm to 8 pm time slot BOOKED");
			}
			System.out.println("DEAR USER,WE THANK YOU FOR YOUR COOPERATION!");
			user[i].status = "Pending";
			

		}
	
	}

	void display_order() {
		System.out.println("YOUR ORDERS ARE ACCEPTED!!");
		
		
		System.out.println("\n\n---ORDER DETAILS---");
		for (int i = num; i < n; i++) {
			System.out.println("\nDetails for Order number " + (i+ 1) + " :");

			System.out.println("CUSTOMER NAME:" + user[i].name);
			System.out.println("CUSTOMER ORDER:" + user[i].order);
			System.out.println("ORDER SIZE:" + user[i].size);
			System.out.println("ORDER PRICE:" + user[i].price);
			System.out.println("ORDER UNIQUE ID:" + user[i].id);
			System.out.println("ORDER DELIVERY time:" + user[i].time);
			System.out.println("ORDER END DESTINATION:" + user[i].end_des);
		}
	}

	void track_order() {
		System.out.println("Please enter your unique id : ");
		int id = sc.nextInt();
		int flag = 0;
		for (int i = 0; i < n; i++) {
			if (user[i].id == id) {
				flag = 1;
				System.out.println("Tracking order...");
				System.out.println("Status of your order : " + user[i].status);

			}
		}
		if (flag == 0) {
			System.out.println("Sorry ,No such with this id found!");

		}
	}

}

class Employee extends Customer {
    

	void list_display()
	{
	    super.display_order();
	    
		// display
		System.out.println("\n\n---ORDER DETAILS---");
		for (i = 0; i < (super.n); i++) {
			System.out.println("\nDetails for Order number " + (i+ 1) + " :");

			System.out.println("CUSTOMER NAME:" + user[i].name);
			System.out.println("CUSTOMER ORDER:" + user[i].order);
			System.out.println("ORDER SIZE:" + user[i].size);
			System.out.println("ORDER PRICE:" + user[i].price);
			System.out.println("ORDER UNIQUE ID:" + user[i].id);
			System.out.println("ORDER DELIVERY time:" + user[i].time);
			System.out.println("ORDER END DESTINATION:" + user[i].end_des);
		}
	}

	void update_list() {
		System.out.println("Enter the user unique id to uptime");
		int id = sc.nextInt();
		int flag = 0;
		for (int i = 0; i < n; i++) {
			if (user[i].id == id) {
				flag = 1;
				System.out.println("Enter the status to be updated : ");
				String status = sc.next();
				System.out.println("Status updated!");
			}
		}
		if (flag == 0) {
			System.out.println("Invalid user Id");
		}
	}

	void bubbleSort(details arr[]) {
		int n = arr.length;
		
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j].time > arr[j + 1].time) {
					// swap arr[j+1] and arr[j]
					details temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

	 void sort_time() {
		bubbleSort(user);
		
	}

	void display_queue() {
       sort_time();
       System.out.println("Displaying Queue");
       System.out.println("\n\n---ORDER DETAILS---");
		for (int i = 0; i < n; i++) {
			System.out.println("\nDetails for Order number " + (n + 1) + " :");
			System.out.println("CUSTOMER NAME:" + user[i].name);
			System.out.println("CUSTOMER ORDER:" + user[i].order);
			System.out.println("ORDER SIZE:" + user[i].size);
			System.out.println("ORDER PRICE:" + user[i].price);
			System.out.println("ORDER UNIQUE ID:" + user[i].id);
			System.out.println("ORDER DELIVERY time:" + user[i].time);
			System.out.println("ORDER END DESTINATION:" + user[i].end_des);
		}
	}

}
