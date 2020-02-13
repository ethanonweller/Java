package num_array_search;
import java.util.ArrayList;
import java.util.Scanner;
public class check_repeats {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int num = 0;
		int[] result = new int[50];
	    int counter = 0, count = 0;
		ArrayList<Integer> nums = new ArrayList<>();
		System.out.println("Enter in a series of integers, -1 to exit: ");
		while(num != -1) {
		num = input.nextInt();
		if (num != -1) 
		nums.add(num);
		}

		for (int i = 0; i < nums.size(); i++) {
	        boolean isDistinct = false;
	        for (int j = 0; j < i; j++) {
	            if (nums.get(i) == nums.get(j)) {
	                isDistinct = true;
	                break;
	            }
	        }
	        if (!isDistinct) {
	            result[counter++] = nums.get(i);
	        }
	    }
	    for (int i = 0; i < counter; i++) {
	        count = 0;
	        for (int j = 0; j < nums.size(); j++) {
	            if (result[i] == nums.get(j)) {
	                count++;
	            }

	        }
	       if (count > 1)
	        System.out.println(result[i] + " repeated = " + count + " times. ");
	       else
	    	   System.out.println(result[i] + " repeated = " + count + " time. ");

	    }
		
		
	}
	}