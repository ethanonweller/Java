package homework2_ch3;
import java.util.Scanner;
public class coord_plane {
public static void main (String args[]) {
	int exit = 0;
	while (exit == 0) {
	System.out.println("Enter your coordinate with a space between numbers: ");
	
	Scanner input = new Scanner(System.in);
	String coord_string = input.nextLine(); // reads whole line WITH space
	coord_string = coord_string.replaceAll("\\s+",""); // gets rid of space
	
	char num1 = coord_string.charAt(0);
	char num2 = coord_string.charAt(1);
	
	if (Character.isDigit(coord_string.charAt(0)) && num1 != '0' && num2 != '0' && Character.isDigit(coord_string.charAt(1))) // if num1 is positive and num2 is positive
		System.out.println("Your coordinate is in Quadrant I");
	else if (num1 == '-' && num1 != '0' && num2 != '0' && Character.isDigit(coord_string.charAt(2))) // if num1 is negative and num2 is positive
		System.out.println("Your coordinate is in Quadrant II");
		else if (num1 == '-' && num1 != '0' && num2 != '0' && Character.isDigit(coord_string.charAt(3))) // if num1 is negative and num2 is negative
			System.out.println("Your coordinate is in Quadrant III");
			else if (Character.isDigit(coord_string.charAt(0)) && num1 != '0' && num2 != '0' && num2 == '-') // if num1 is positive and num2 is negative
				System.out.println("Your coordinate is in Quadrant IV");
				else if (num1 == '0' && num2 != '0')	// if num1 is 0 and num2 is not 0
					System.out.println("Your coordinate is on the Y-Axis");
					else if (num2 == '0' && num1 != '0') // if num2 is 0 and num1 is not 0
						System.out.println("Your coordinate is on the X-Axis"); 
						else if (num2 == '0' && num1 == '0') // if both are 0
							System.out.println("Your coordinate is on the origin"); 
	}
					
}
}
