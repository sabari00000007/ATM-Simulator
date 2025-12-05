import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.println("---- ATM Simulator ----");

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (!atm.login(userId, pin)) {
            System.out.println("Invalid User ID or PIN!");
            return;
        }

        System.out.println("Login Successful!");

        while (true) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose Option: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    int dep = sc.nextInt();
                    atm.deposit(dep);
                    break;
                case 3:
                    System.out.print("Enter amount: ");
                    int wd = sc.nextInt();
                    atm.withdraw(wd);
                    break;
                case 4:
                    System.out.println("Thank you for using ATM!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
