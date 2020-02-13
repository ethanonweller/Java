package num_array_search;
import java.util.Scanner;
import java.util.stream.IntStream;
public class search_array{
        public static void main (String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter 10 integers: ");
            int[] nums = new int [10];
            for (int i = 0; i <= 9; i++) {
                int number = input.nextInt();
                nums[i] = number;
            }
            int answer = indexOfSmallestElement(nums);
            System.out.println(answer + " is the smallest value at index " + findIndex(nums, 5)); 
        }

        public static int indexOfSmallestElement(int nums[]) {
            int lowest = 0;
            for(int i = 0; i < nums.length; i++) {  // bubble sort low - high
                for (int j = 0; j < nums.length; j++) {
                    if (nums[i] < nums[j]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
                lowest = nums[0];
            }
            return lowest;
        }
        public static int findIndex(int num[], int t) 
        { 
            int len = num.length; 
            return IntStream.range(0, len) 
                .filter(i -> t == num[i]) 
                .findFirst() // first occurrence 
                .orElse(-1); // No element found 
        } 
    }
