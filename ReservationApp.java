import java.util.*;
import java.util.Scanner;
public class ReservationApp
{
 	public static void clrscr() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\n\n\t\t\t<< Press ENTER to continue >> ");
		sc.nextLine();
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}

	public static void startMenu()
	{
		System.out.println("\n\t\t\tIndah Raya Beach Resort Reservation System");
		System.out.println("\t\t\t------------------------------------------");
		System.out.println("\t\t\t1. Book a room");
		System.out.println("\t\t\t2. Room number");
		System.out.println("\t\t\t3. Updating customers information");
		System.out.println("\t\t\t4. Check room availability for booking");
		System.out.println("\t\t\t5. Display customers fee");
		System.out.println("\t\t\t6. Exit");
		System.out.print("\n\t\t\t PLEASE ENTER YOUR CHOICE>>");
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Declaring Linkedlist
		LinkedList ll = new LinkedList();
		//Declaring Queue
		Queue q = new Queue();

		Reservation reserve;

		for(;;)
		{
			startMenu();
			int cy = Integer.parseInt(sc.nextLine());

			if(cy == 1)
			{
				//Get information from customer
				int choice = 1;
				while(choice == 1)
				          {
				              System.out.println("\n\t\t\tFill the information below");
				                    System.out.println("\t\t\t----------------------------\n");
				                    System.out.print("\t\t\tEnter name: ");
				                    String n = sc.nextLine();
				                    System.out.print("\t\t\tEnter phone number: ");
				                    String pn = sc.nextLine();
				                    System.out.print("\t\t\tEnter date: ");
				                    String dt = sc.nextLine();
				                    System.out.print("\t\t\tEnter room type[S=Single, D=Double, T=Triple, Q=Quad]: ");
				                    char rt = sc.nextLine().charAt(0);
				                    System.out.print("\t\t\tEnter total guest: ");
				                    int gn = Integer.parseInt(sc.nextLine());
				                    System.out.print("\t\t\tEnter total day: ");
				                    int dn = Integer.parseInt(sc.nextLine());
				                    reserve = new Reservation(n, pn, dt, rt, gn, dn);
				                    ll.insertAtBack(reserve);
				                    q.enqueue(reserve);

				              System.out.print("\t\t\t Enter 1 to add a new reservation, 2 to go to main menu:");
				                    choice = sc.nextInt();
				                    sc.nextLine();
				          }
				 		clrscr();

			}

			//) QUEUE: to give the guest who made their reservation first the priority to have their room first.
			else if(cy == 2)
			{
				Queue roomS = new Queue();
				Queue roomD = new Queue();
				Queue roomT = new Queue();
				Queue roomQ = new Queue();
				Queue temp = new Queue();
				while(!q.isEmpty())
				{
						reserve = (Reservation)q.dequeue();
						temp.enqueue(reserve);

						if(reserve.getRoomType() == 'S'  )
						{
							roomS.enqueue(reserve);
						}
						else if(reserve.getRoomType() == 'D')
						{
							roomD.enqueue(reserve);
						}
						else if(reserve.getRoomType() == 'T')
						{
							roomT.enqueue(reserve);
						}
						else if(reserve.getRoomType() == 'Q')
						{
							roomQ.enqueue(reserve);
						}
				}//while ends
				Reservation room = new Reservation();
				int roomNumberS = room.getRoomNumberS();
				int roomNumberD = room.getRoomNumberD();
				int roomNumberT = room.getRoomNumberT();
				int roomNumberQ = room.getRoomNumberQ();

				int bil=01, bil2=11, bil3=21, bil4=31;
				while(!roomS.isEmpty())
				{
					reserve=(Reservation)roomS.dequeue();
					temp.enqueue(reserve);
					if(reserve.getRoomType()=='S')
					{
						System.out.println("\n\t\t\t" + reserve.getName() + " has been assigned to room S" + bil);
						bil++;
					}
				}

				while(!roomD.isEmpty())
				{
					reserve=(Reservation)roomD.dequeue();
					temp.enqueue(reserve);
					if(reserve.getRoomType() == 'D')
					{
						System.out.println("\n\t\t\t" + reserve.getName() + " has been assigned room D" + bil2);
						bil2++;
					}
				}

				while(!roomT.isEmpty())
				{
					reserve=(Reservation)roomT.dequeue();
					temp.enqueue(reserve);
					if(reserve.getRoomType() == 'T')
					{
						System.out.println("\n\t\t\t" + reserve.getName() + " has been assigned room T" + bil3);
						bil3++;
					}
				}

				while(!roomQ.isEmpty())
				{
					reserve=(Reservation)roomQ.dequeue();
					temp.enqueue(reserve);
					if(reserve.getRoomType()=='Q')
					{
						System.out.println("\n\t\t\t" + reserve.getName() + " has been assigned room Q" + bil4);
						bil4++;
					}
				}
				clrscr();
			}//option 2 ends

			//ii) SEARCHING: Search guests information and to update it
			else if(cy == 3)
			{

				if(ll.isEmpty())
				{
					System.out.print("\t\t\tNo data to be updated. Please store data first! ");
					clrscr();
				}
				else
				{
					System.out.print("\t\t\tEnter the name of the guest you want to update: ");
					String input = sc.nextLine();

					reserve =(Reservation)ll.getFirst();
					while(reserve!=null)
					{
						if(reserve.getName().equalsIgnoreCase (input))
						{
							System.out.print("\t\t\tWhat do you want to update[Room tpe:RT/Total guest:TG/Total day:TD]");
							String choice = sc.nextLine();

							if(choice.equalsIgnoreCase("RT"))
							{
								System.out.print("\t\t\tEnter the new room type for the guest[S=Single, D=Double, T=Triple, Q=Quad]: ");
						    	char newRoomType = sc.nextLine().charAt(0);
   								reserve.setRoomType(newRoomType);
							}
							else if(choice.equalsIgnoreCase("TG"))
							{
								System.out.print("\t\t\tEnter the new total guest: ");
						    	int newGuestNum = Integer.parseInt(sc.nextLine());
   								reserve.setGuestNum(newGuestNum);
							}
							else if(choice.equalsIgnoreCase("TD"))
							{
								System.out.print("\t\t\tEnter the new total day: ");
						    	int newTotalDay = Integer.parseInt(sc.nextLine());
   								reserve.setDayNum(newTotalDay);
							}
						}//while ends
						reserve =(Reservation)ll.getNext();
					}
				}
				clrscr();
			}//option 3 ends

			//iii) SORTING: Sort rooms according to the room list so it can be counted according to the classification.
			//Using LinkedList
			else if(cy == 4)
			{
				int bilRoomS=10, bilRoomD=10, bilRoomT=10, bilRoomQ=10;
				reserve = (Reservation)ll.getFirst();
				while(reserve!=null)
				{
					if(reserve.getRoomType()=='S')
					{
						bilRoomS--;
					}
					if(reserve.getRoomType()=='D')
					{
						bilRoomD--;
					}
					if(reserve.getRoomType()=='T')
					{
						bilRoomT--;
					}
					if(reserve.getRoomType()=='Q')
					{
						bilRoomQ--;
					}
					reserve = (Reservation)ll.getNext();
				}
				System.out.println("\t\t\tAvailable Single room to book:" + bilRoomS);
				System.out.println("\t\t\tAvailable Double room to book:" + bilRoomD);
				System.out.println("\t\t\tAvailable Triple room to book:" + bilRoomT);
				System.out.println("\t\t\tAvailable Quad room to book:" + bilRoomQ);
				clrscr();

			}//option 4 ends

			//iv)Count the charges of the guest according to their package
			//Using LinkedList
			else if(cy == 5)
			{
				if(ll.isEmpty())
				{
					System.out.print("\t\t\tNo data. Please store data first! ");
					clrscr();
				}
				else
				{
					System.out.print("\t\t\tEnter guest name: ");
					String nama = sc.nextLine();
					double calcS=0.0, calcD=0.0, calcT=0.0, calcQ=0.0;
					reserve = (Reservation)ll.getFirst();
					while(reserve!=null)
					{
						if(reserve.getName().equalsIgnoreCase(nama) && reserve.getRoomType() == 'S')
						{
							calcS = reserve.getGuestNum() * reserve.getDayNum() * 50.00;
							System.out.println(reserve.toString() + "\n\t\t\tThe charges for package S:" + calcS );
						}
						else if(reserve.getName().equalsIgnoreCase(nama) && reserve.getRoomType() == 'D')
						{
							calcD = reserve.getGuestNum() * reserve.getDayNum() * 100.00;
							System.out.println(reserve.toString() +"\n\t\t\tThe charges for package D:" + calcD );
						}
						else if(reserve.getName().equalsIgnoreCase(nama) && reserve.getRoomType() == 'T')
						{
							calcT = reserve.getGuestNum() * reserve.getDayNum() *  150.00;
							System.out.println(reserve.toString() +"\n\t\t\tThe charges for package T:" + calcT );
						}
						else if(reserve.getName().equalsIgnoreCase(nama) && reserve.getRoomType() == 'Q')
						{
							calcQ = reserve.getGuestNum() * reserve.getDayNum() * 200.00;
							System.out.println(reserve.toString() +"\n\t\t\tThe charges for package Q:" + calcQ );
						}
						reserve = (Reservation)ll.getNext();
					}
				}
				clrscr();
			}//option 5 ends

			else if(cy == 6)
			{
				System.out.println("\n\n\n\t\t\t!!! THANK YOU !!!");
				System.out.print("\n\n\nt\t\t\t\tTerminating.... ");
				clrscr();
				break;
			}
			else
			{
				System.out.println("\n\n\n\t\t\tWrong input! Please re-enter your choice!\n\n\n");
				 clrscr();
			}//option 6 ends

		}//for(;;) loop ends
	}//main end
}//Reservation end