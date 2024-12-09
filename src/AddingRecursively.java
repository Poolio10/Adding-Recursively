import java.util.Scanner;
public class AddingRecursively {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        boolean again = true;
        boolean done;

        //Run again loop
        while(again) {
            //num1 input fail proofing
            done = false;
            while (!done) {
                try {
                    System.out.print("Please enter an integer >> ");
                    num1 = input.nextInt();
                    done = true;
                } catch (Exception InputMismatchException) {
                    System.out.println("Please enter a valid integer.");
                } finally {
                    //clears return stroke
                    input.nextLine();
                }
            }

            //num2 input fail proofing and checking that num2 is bigger than num1
            done = false;
            while (!done) {
                try {
                    System.out.print("Please enter an integer >> ");
                    num2 = input.nextInt();
                    done = true;
                } catch (Exception InputMismatchException) {
                    System.out.println("Please enter a valid integer.");
                } finally {
                    //clears return stroke
                    input.nextLine();
                }
                if (num1 >= num2) {
                    done = false;
                    System.out.println("Please enter an integer larger than the first.");
                }
            }

            int total = adding(num1, num2, 0);
            System.out.println("The total of all integers inclusive between " + num1 + " and " + num2 + " is " + total + ".");

            System.out.println("Would you like to begin again? y/n");
            String temp = input.nextLine();

            if(temp.equals("n") || temp.equals("N")) {
                again = false;
            }
        }
    }

    /* Recursive addition method
     * Adds the larger variable to itself - 1, then calls itself with larger lowered by 1.
     * Upon return, ads that value to the previous value.
     * Returns the middle variable.*/
    public static int adding(int small, int large, int middle) {
        if(large > small) {
            middle = large;
            middle = middle + adding(small, large-1, middle);
        } else if(large == small) {
            return large;
        }
        return middle;
    }
}