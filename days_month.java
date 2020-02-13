package lab5;
import java.util.Scanner;
public class days_month {
public static void main (String args[]) {
	System.out.println("Enter a year: ");
	Scanner input = new Scanner(System.in);
	int year = input.nextInt();
	char first = ' ';
	System.out.println("Enter a month, must have capital first letter: ");
	String month = input.next();
	first = month.charAt(0);
	int temp = 0;
	boolean flag = false;
		while (Character.isLowerCase(first)) { // checks if letter is lower case
		System.out.println("Your first letter is not capital, try again.");
		month = input.next();
		first = month.charAt(0);
		}
		
		if (month.equals("Sept") || month.equals("Apr") || month.equals("Jun") || month.equals("Nov")) {
			System.out.println("There are 30 days in the month of " + month + " in " + year);
			temp = 1;
			if (temp == 0) {
				System.out.println("There are 31 days in the month of " + month + " in " + year);
		}
		}
		if (month.contentEquals("Feb")) {
			if(year % 400 == 0)
	            flag = true;
	        else if (year % 100 == 0)
	            flag = false;
	      	else if(year % 4 == 0)
	            flag = true;
			if (flag)
				System.out.println("There are 29 days in the month of Feb in " + year);
			else
				System.out.println("There are 28 days in the month of Feb in " + year);
			}
						
}
}
