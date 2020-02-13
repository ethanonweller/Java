package lab5;
import java.util.Scanner;

public class score {
public static void main (String args[]) {
	System.out.println("How many students are there?");
	Scanner input = new Scanner(System.in);
	int amt = input.nextInt();
	String names[] = new String[amt];
	double score[] = new double[amt];
	double check[] = new double [amt];
	int i = 0;
	int max = 0;
	int counter = 0;
	
	while (i < amt) {
	System.out.println("Enter the student's name: ");
	names[i] = input.next();
	System.out.println("Enter that student's score: ");
	score[i] = input.nextDouble();
	check[i] = score[i];
	i++;
	}
	
int n = score.length;
	 for (int w = 0; w < n-1; w++) // bubble sort
         for (int j = 0; j < n-w-1; j++)
             if (score[j] > score[j+1])
             {
                 double temp = score[j];
                 score[j] = score[j+1];
                 score[j+1] = temp;
             }
	 
	 for(int p = 0; p < n; p++) {
		 for (int x = 0; x < n; x++)
		 if (score[p] == check[x])
			 if (counter == 0) {
				 System.out.println(names[x - 1] + " had the highest score of: " + score[amt - 1]);
				 counter++;
			 }
		 
	 }
}
}
