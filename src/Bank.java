import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Account> accounts = new ArrayList<>();
    private double totalTransactionFeeAmount = 0.0;

    private double totalTransferAmount = 0.0;

    public static final double transactionFlatFeeAmount = 10;
    public static final double transactionPercentFeeValue = 0.05;


    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public Bank(String bankName, double totalTransactionFeeAmount) {
        this.bankName = bankName;
        this.totalTransactionFeeAmount = totalTransactionFeeAmount;
    }

    public String getBankName() {
        return bankName;
    }


    public void addAccount(Account t) {
        this.accounts.add(t);
    }

    public Account getByName(String nameToSearch) {
        Account toBeFound = null;
        for (int i = 0; i < this.accounts.size(); i++) {
            if (accounts.get(i).getUser().equals(nameToSearch)) {
                toBeFound = accounts.get(i);
                break;
            }
        }
        return toBeFound;
    }

    public double getTotalTransactionFeeAmount() {
        return totalTransactionFeeAmount;
    }

    public double getTotalTransferAmount() {
        return totalTransferAmount;
    }

    public void setTotalTransferAmount(double newAmount) {
        this.totalTransferAmount = newAmount;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }


    public void printAllAccounts() {
        for (var account : accounts) {
            System.out.println("----------------------------------------");
            System.out.println("\tAccount Name[" + account.getUser() + "]");
            System.out.println("\tAccount id[" + account.getId() + "]");
            System.out.println("\tAccount Transaction History:");
            for (var transaction : account.transactionsHistory) {
                System.out.println("\t" + transaction.toString());
            }
            System.out.println("-----------------------------------------");
        }
    }

    public void addAmountToTotalTransferAmount(double amount) {

        this.totalTransferAmount += amount;
    }


    public void setTotalTransactionFeeAmount(double totalTransactionFeeAmount) {
        this.totalTransactionFeeAmount = totalTransactionFeeAmount;
    }

    public void addFeeToTransactionAmount(double amount) {

        this.totalTransactionFeeAmount += amount;
    }
}
