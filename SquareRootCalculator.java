import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        
        try {
            double num = sc.nextDouble();

            if (num < 0) {
                throw new IllegalArgumentException("Error: Cannot calculate the square root of a negative number.");
            }

            double result = Math.sqrt(num);
            System.out.println("Square root: " + result);
            
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } finally {
            sc.close();
        }
    }
}
