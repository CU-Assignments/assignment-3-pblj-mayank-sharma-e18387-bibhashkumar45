import java.util.Scanner;

class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMSystem {
    private static final int PIN = 1234;
    private static double balance = 3000; // Initial balance

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int enteredPIN = sc.nextInt();

            if (enteredPIN != PIN) {
                throw new InvalidPINException("Error: Invalid PIN.");
            }

            System.out.print("Withdraw Amount: ");
            double amount = sc.nextDouble();

            if (amount > balance) {
                throw new InsufficientBalanceException("Error: Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal successful! Remaining Balance: " + balance);

        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid amount.");
        } finally {
            System.out.println("Current Balance: " + balance);
            sc.close();
        }
    }
}
