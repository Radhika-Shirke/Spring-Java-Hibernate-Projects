package com.hotelmanagement.HotelManagementProject;

import java.sql.SQLException;
import java.util.Scanner;

public class HotelUI {
	
	private static void orderFood()
	{
		
		Scanner sc = new Scanner(System.in);
		int totalAmount;
		
		System.out.println("Select Items from below menu: ");
		System.out.println("1. Maharashtrian Thali	350 INR \n2.South Indian Thali	270 INR"
				+ "\n3. Punjabi Thali	400 INR " + "\n4. Poha	30 INR" +
				"\n5. Upma	30 INR" + "\n6. Tea	15 INR" + "\n7. Coffee	20 INR"
				+ "\n8. Exit");
		
		
		int option = sc.nextInt();
		int foodBill = 0;
		
		while(true)
		{
			switch(option)
			{
				case 1:
					foodBill += 350;
					break;
				
				case 2:
					foodBill += 270;
					break;
					
				case 3:
					foodBill += 400;
					break;
					
				case 4:
					foodBill += 30;
					break;
				
				case 5:
					foodBill += 30;
					break;
					
				case 6:
					foodBill += 15;
					break;
					
				case 7:
					foodBill += 20;
					break;
					
				case 8:
					System.exit(0);
					
			}
		}
	}
	
	
	private static void bookRoom(Scanner scn) throws SQLException 
	{
		while(true) 
		{
			System.out.println("\n*****************************************");
			System.out.println("Select Operation to Perform: \n");
			//System.out.println("1. Show all Rooms.");
			System.out.println("1. Book a Room.");
			System.out.println("2. Go Back");
			System.out.print("\nEnter your Choice: ");
			int choice1 = scn.nextInt();
			
			if(choice1 == 2) {break;}
			switch(choice1) 
			{
			
			case 1:{
				System.out.println("\n*****************************************");
				System.out.println("DISPLAYING ALL ROOMS with Availability: ");
				System.out.println(DBHotel.getRoomDetailsWithAvailability());
				
				System.out.print("Enter Room Number you want to Book: ");
				int bookedRN = scn.nextInt();
				if(DBHotel.ifRoomNoIsValid(bookedRN))
				{
					if(DBHotel.isRoomAvailable(bookedRN) )
					{
						System.out.print("Number of Days you want to Book the Room: ");
						int bookedDays = scn.nextInt();
						
						System.out.print("Enter Your First Name: ");
						String firstName = scn.next();
						
						System.out.print("Enter Your Last Name: ");
						String lastName = scn.next();
						
						System.out.print("Enter Your Aadhar Number [Without Spaces]: ");
						int aadharNo = scn.nextInt();
						
						System.out.print("Do you want to confirm Your Booking? (Y/N): ");
						char bookingConfirm = scn.next().toLowerCase().charAt(0);
						
						if(bookingConfirm != 'n')
						{
							boolean isBookingConfirm = DBHotel.bookRoom(bookedRN,bookedDays,firstName,lastName,aadharNo);
							if(isBookingConfirm) {
								System.out.println("\nHi "+firstName+", Your Desired Room has been Successfully Booked!");
								return;
							}
							else {
								System.out.println("Sorry! Your Booking was Unsuccessful!");
							}
						}else {
							System.out.println("Booking Cancelled!");
						}
						
					}
					else {
						System.out.println("Room No "+bookedRN+" is Not Available.");
					}
				}
				else {
					System.out.println("Please Enter a Valid Room Number!");
				}
				
				break;
			}
			
			default:{
				System.out.println("Please give valid Input!");
			}
			
			}
		}
	}
	
	
	private static void checkout(int roomNo, int aadharNo, Scanner scn) throws SQLException{
		System.out.println(HotelDB.getFinalBill(roomNo,aadharNo));					
		int grantTotalAmount = HotelDB.grantTotalAmount(roomNo,aadharNo);
		
		System.out.println("Grand Total to be Paid before Checkout: Rs."+ grantTotalAmount );
		
		while(true)
		{
			System.out.print("Enter the Amount to Pay: ");
			int payment = scn.nextInt();
			if(payment == grantTotalAmount)
			{
				System.out.println("\n*****************************************");
				System.out.println("Thank you for you Payment!\nPlease visit us Again!");
				System.out.println("\n*****************************************");
				// method which will remove user details from all tables
				DBHotel.removeAllCustomerDetails(roomNo,aadharNo);
				System.exit(0);
				break;
			}						
			else {
				System.out.println("Please Enter Exact Amount that is Rs."+grantTotalAmount);
			}
		}
		
	}
	
	private static void startApp() throws Exception
	{
			System.out.println("******** WELCOME TO HOTEL AGODA *******");
			Scanner scn = new Scanner(System.in);

			while (true)
			{
				System.out.println("\n*****************************************");
				System.out.println("How may we help you?\n");
				System.out.println("1. I want to Book a Room.");
				System.out.println("2. I want to Order Food.");
				System.out.println("3. I want to avail Room Service.");
				System.out.println("4. Quit.");
				System.out.print("\nEnter your Choice: ");
				int choice = scn.nextInt();
				
				if(choice == 4) {break;}
				
				switch (choice)
				{

					case 1:
					{
						bookRoom(scn);
						break;
					}
					case 2:
					{
						orderFood();
						break;
					}
					
					default:{
						System.out.println("Please give valid Input!");
					}

				}
			}

	}
	
}
