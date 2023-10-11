import java.util.Scanner;
public class TOA
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Start (Cebu City)");
		System.out.println("Landmark: South Bus Terminal(Emall)");
		
		System.out.print("Is Barili, Cebu obstructed? (Y/N)");
		char ch = scan.next().toUpperCase().charAt(0);
		
		switch(ch){
		    case 'N':
		        System.out.print("Enter your Speed in Kilometers: ");
		        int speed = scan.nextInt();
		        
		        double MoalboalDistance = 84.9;
		        int estHour = (int)MoalboalDistance/speed;
		        int estMinutes = (int)(MoalboalDistance%speed) * 60 / speed;
              		System.out.println("Cebu, City(Emall) - Start");
              		System.out.println("Route 1 - Minglanilla, Cebu");
              		System.out.println("Route 2 - San Fernando, Cebu");
              		System.out.println("Route 3 - Carcar, Cebu");
              		System.out.println("Route 4 - Barili, Cebu");
              		System.out.println("Route 5 - Dumanjug, Cebu");
              		System.out.println("Route 6 - Alcantara, Cebu");
              		System.out.println("End(Moalboal, Cebu)");
              		System.out.println("Speed: " + speed + " km/hr");
              		System.out.println("Total Distance: " + MoalboalDistance);
		        System.out.println("Estimated Time Arrival: " + estHour + " Hour/s " + estMinutes + " Minutes");
              		break;
		     case 'Y':
              		System.out.print("Enter your Speed in Kilometers: ");
		        speed = scan.nextInt();
              
              		System.out.print("Is Dumanjug, Cebu obstructed? (Y/N)");
		        char ch2 = scan.next().toUpperCase().charAt(0);
              
              switch(ch2){
                  case 'N':
                     double MoalboalDistance2 = 96.2;
                     int estHour2 = (int)MoalboalDistance2/speed;
		               int estMinutes2 = (int)(MoalboalDistance2%speed) * 60 / speed;
                     System.out.println("Cebu, City(Emall) - Start");
                     System.out.println("Route 1 - Minglanilla, Cebu");
                     System.out.println("Route 2 - San Fernando, Cebu");
                     System.out.println("Route 3 - Carcar, Cebu");
                     System.out.println("Route 4 - Sibonga, Cebu");
                     System.out.println("Route 5 - Dumanjug, Cebu");
                     System.out.println("Route 6 - Alcantara, Cebu");
                     System.out.println("End(Moalboal, Cebu)");
                     System.out.println("Speed: " + speed + " km/hr");
                     System.out.println("Total Distance: " + MoalboalDistance2);
		     System.out.println("Estimated Time Arrival: " + estHour2 + " Hour/s " + estMinutes2 + " Minutes");
                     break;
                     
                   case 'Y':
                     double MoalboalDistance3 = 131.6;
                     int estHour3 = (int)MoalboalDistance3/speed;
		     int estMinutes3 = (int)(MoalboalDistance3%speed) * 60 / speed;
                     System.out.println("Cebu, City(Emall) - Start");
                     System.out.println("Route 1 - Minglanilla, Cebu");
                     System.out.println("Route 2 - San Fernando, Cebu");
                     System.out.println("Route 3 - Carcar, Cebu");
                     System.out.println("Route 4 - Sibonga, Cebu");
                     System.out.println("Route 5 - Argao, Cebu");
                     System.out.println("Route 6 - Ronda, Cebu");
                     System.out.println("Route 7 - Alcantara, Cebu");
                     System.out.println("End(Moalboal, Cebu)");
                     System.out.println("Speed: " + speed + "km/hr");
                     System.out.println("Total Distance: " + MoalboalDistance3);
		     System.out.println("Estimated Time Arrival: " + estHour3 + " Hour/s " + estMinutes3 + " Minutes");
                     break;


              }
              break;
 		        
		}
	}
}
