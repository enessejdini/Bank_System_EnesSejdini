import java.util.ArrayList;
import java.util.Scanner;

public class Account {

    private int id;
    private String user;
    private double balance;

    public static int idCounter = 0;

    public ArrayList<Transaction> transactionsHistory;

    public Account() {
        this.transactionsHistory = new ArrayList<>();
    }

    public Account(int id, String user, double balance) {
        this.id = id;
        this.user = user;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void createAccount() {
        System.out.print("Enter you name for your account: ");
        Scanner userinput = new Scanner(System.in);
        this.setId(Account.idCounter);
        String normalizedName = userinput.next();
        this.setUser(normalizedName.toUpperCase());
        this.setBalance(0.0);
        Account.idCounter++;
    }

    public double withdraw(double amount, String reason, double feeType) {


        double finalAmount = 0.0;

        if (feeType == 10.0) {
            finalAmount = amount + feeType;
        } else if (feeType == 0.05) {
            finalAmount = amount + (amount * feeType);
        }

        this.balance -= finalAmount;

        Transaction temporary = new Transaction(finalAmount, this.id, this.id, reason);
        this.transactionsHistory.add(temporary);
        return this.balance;
    }

    public void deposit(double amount, String reason, double feeType) {
        this.balance += amount;
        Transaction temporary = new Transaction(amount, this.id, this.id, reason);
        this.transactionsHistory.add(temporary);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", balance=" + balance +
                '}';
    }
}
