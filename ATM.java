import java.util.*;

public class ATM {
    private HashMap<String, User> users; 
    private User currentUser;

    public ATM() {
        users = new HashMap<>();

        users.put("user101", new User("user101", 1234, 5000));
        users.put("user102", new User("user102", 4321, 8000));
        users.put("user103", new User("user103", 1111, 10000));
    }

    public boolean login(String userId, int pin) {
        if (users.containsKey(userId)) {
            User u = users.get(userId);
            if (u.getPin() == pin) {
                currentUser = u;
                return true;
            }
        }
        return false;
    }

    public void checkBalance() {
        System.out.println("Your balance: " + currentUser.getBalance());
    }

    public void deposit(int amount) {
        currentUser.setBalance(currentUser.getBalance() + amount);
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(int amount) {
        if (amount > currentUser.getBalance()) {
            System.out.println("Insufficient balance");
        } else {
            currentUser.setBalance(currentUser.getBalance() - amount);
            System.out.println("Withdrawn: " + amount);
        }
    }
}

class User {
    private String userId;
    private int pin;
    private int balance;

    public User(String userId, int pin, int balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
