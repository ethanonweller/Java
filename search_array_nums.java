import java.util.Scanner;
public class search_array_nums {
        public static void main (String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter 10 integers: ");
            int[] nums = new int [10];
            for (int i = 0; i <= 9; i++) {
                int number = input.nextInt();
                nums[i] = number;
            }
            int answer = indexOfSmallestElement(nums);
            System.out.println(answer + " is the smallest value at index 0");
        }

        public static int indexOfSmallestElement(int nums[]) {
            int index = 0;
            for(int i = 0; i < nums.length; i++) {  // bubble sort low - high
                for (int j = 0; j < nums.length; j++) {
                    if (nums[i] < nums[j]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
                index = nums[0];
            }
            return index;
        }
    }
