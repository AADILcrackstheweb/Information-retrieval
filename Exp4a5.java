import java.util.ArrayList;
import java.util.Scanner;

public class Exp4a5 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        boolean flag = true; // flag to keep the program iterating
        String temp; // stores user input to continue or quit
        int size; // stores the number of elements in the array

        while (flag) {
            try {
                System.out.println("Enter the size of the array: ");
                size = input.nextInt();
                int array[] = new int[size];

                System.out.println("Enter the elements of the array: ");
                for (int i = 0; i < size; i++) {
                    array[i] = input.nextInt();
                }

                // Find leaders in the array and store them
                ArrayList<Integer> leaders = new ArrayList<>();
                int maxFromRight = array[size - 1]; // initialize the rightmost element as a leader
                leaders.add(maxFromRight);

                // Traverse the array from right to left to find all leaders
                for (int i = size - 2; i >= 0; i--) {
                    if (array[i] > maxFromRight) {
                        leaders.add(array[i]);
                        maxFromRight = array[i];
                    }
                }

                // Display the leaders
                System.out.println("\nLeaders in the array: " + leaders);

                // Calculate the sum of leaders
                int sumOfLeaders = 0;
                for (int leader : leaders) {
                    sumOfLeaders += leader;
                }
                System.out.println("Sum of the leaders: " + sumOfLeaders);

                // Check for prime leaders
                System.out.println("\nPrime leaders in the array:");
                for (int leader : leaders) {
                    if (isPrime(leader)) {
                        System.out.println(leader + " is a prime number.");
                    }
                }

                // Ask user whether to quit or continue
                System.out.println("\nType 'quit' to quit the program or 'continue' to repeat.");
                temp = input.next();

                if (temp.equalsIgnoreCase("quit")) {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nInvalid input, please try again.");
                input.nextLine(); // clear buffer
            }
        }
        input.close();
    }

    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
