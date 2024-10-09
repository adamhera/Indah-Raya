public class Reservation
{
	private String name;
	private String phoneNumber;
	private String date;
	private char roomType; // S=Single, D=Double, T=Triple, Q=Quad
	private int guestNum;
	private int dayNum;
	private int roomNumberS, roomNumberD, roomNumberT,roomNumberQ ;

	private static int nextRoomNumberS= 1;
	private static final int maxRoomS = 10;

	private static int nextRoomNumberD=11;
	private static final int maxRoomD = 20;

    private static int nextRoomNumberT=21;
    private static final int maxRoomT = 30;

    private static int nextRoomNumberQ=31;
    private static final int maxRoomQ = 40;


	public Reservation()
	{
		if(nextRoomNumberS > maxRoomS)
		{
			System.out.println("No more rooms available");
		}
		roomNumberS = nextRoomNumberS++;

		if(nextRoomNumberD > maxRoomD)
		{
			System.out.println("No more rooms available");
		}
		roomNumberD = nextRoomNumberD++;

		if(nextRoomNumberT > maxRoomT)
		{
			System.out.println("No more rooms available");
		}
		roomNumberT = nextRoomNumberT++;

		if(nextRoomNumberQ > maxRoomQ)
		{
			System.out.println("No more rooms available");
		}
		roomNumberQ = nextRoomNumberQ++;
	}

	//NORMAL CONSTRUCTOR
	public Reservation(String n, String pn, String dt, char rt, int gn, int dn )
	{
		name = n;
		phoneNumber = pn;
		date = dt;
		roomType = rt;
		guestNum = gn;
		dayNum = dn;
	}

	//GETTER
	public String getName(){return name;}
	public String getPhoneNumber(){return phoneNumber;}
	public String getDate(){return date;}
	public char getRoomType(){return roomType;}
	public int getGuestNum(){return guestNum;}
	public int getDayNum(){return dayNum;}
	public int getRoomNumberS(){return roomNumberS;}
	public int getRoomNumberD(){return roomNumberS;}
	public int getRoomNumberT(){return roomNumberS;}
	public int getRoomNumberQ(){return roomNumberS;}

	public void setName(String n)
	{
			name = n;
	}
	public void setPhoneNumber(String pn)
	{
			phoneNumber = pn;
	}
	public void setDate(String dt)
	{
			date = dt;
	}
	public void setRoomType(char rt)
	{
			roomType = rt;;
	}
	public void setGuestNum(int gn)
	{
			guestNum = gn;
			}
	public void setDayNum(int dn)
	{
			dayNum = dn;
	}

	public String toString()
	{
		return "\n\t\t\tName : " + name + "\n\t\t\tPhone Number : " + phoneNumber + "\n\t\t\tDate :" + date + "\n\t\t\tRoom Type:" + roomType +"\n\t\t\tTotal Guest :" + guestNum +"\n\t\t\tTotal Days : "+dayNum;
	}


}

