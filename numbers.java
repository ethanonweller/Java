package lab5;
import java.util.Scanner;
	
public class numbers {
public static void main (String args[]) {
	Scanner input = new Scanner(System.in);
	double sum = 0.0;
	double avg = 0.0;
	int neg = 0;
	int pos = 0;
	
	System.out.println("Enter each digit, input ends when there is a zero: ");
	String num = input.nextLine();
	if (num == "0")
		System.out.println("No numbers are entered except 0");
		
	String num_split = num.replaceAll("\\s+", "");
	int num_out[] = new int[num_split.length()];
	
	for (int i = 0; i <= num_split.length() - 1; i++) {
		num_out[i] = Character.getNumericValue(num_split.charAt(i));
		
		if (num_out[i] < 0)
			neg++;
		if (num_out[i] > 0 && num_out[i] != 0)
			pos++;
	
		sum += num_out[i];
		System.out.println(sum);
	}
	avg = sum / num_split.length();
	System.out.println("There was " + neg + " negative number(s).");
	System.out.println("There was " + pos + " positive number(s). ");
	System.out.println("There sum of the integers given is: " + sum);
	System.out.println("The average of the integers given is: " + avg);
}
}
