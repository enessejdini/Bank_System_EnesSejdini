import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static final DecimalFormat decfor = new DecimalFormat("0.00");

    public static void main(String[] args) throws InterruptedException {

        boolean isApplicationActive = true;
        Bank bank = new Bank("Dino's Bank");//TODO
        int memberType;


        Scanner userInput = new Scanner(System.in);

        while (isApplicationActive) {//TODO this is Main event for the application which handles user inputs
            System.out.println("Welcome To Dino's Bank");
            System.out.println("Press 1 To Access Admin Functions");
            System.out.println("Press 2 To Access User Functions");

            System.out.println("Press 0 To Exit");
            System.out.print("\tYour input: ");
            memberType = userInput.nextInt();
            if (memberType == 1) {//TODO admins of the systems is handled in this part

                System.out.println("Welcome to admin panel");
                System.out.println("Press 1 For List Of All Accounts");
                System.out.println("Press 2 For Total Transaction Fee Amount");
                System.out.println("Press 3 For Total Transfer Amount");

                System.out.print("\tYour Input: ");
                Scanner adminScanner = new Scanner(System.in);
                int adminchoice = adminScanner.nextInt();

                if (adminchoice == 1) {
                    bank.printAllAccounts();
                } else if (adminchoice == 2) {
                    System.out.println("Total Transaction Amount: " + decfor.format(bank.getTotalTransactionFeeAmount()));
                } else if (adminchoice == 3) {
                    System.out.println("Total Transfer Amount: " + decfor.format(bank.getTotalTransferAmount()));
                }


            } else if (memberType == 2) {//TODO users of the system is handled in this part

                boolean isUserActive = true;

                while (isUserActive) {

                    System.out.println("\tPress 1 To Create An Account!");
                    System.out.println("\tPress 2 To Access An Existing One!");
                    System.out.println("\tPress 0 to exit");
                    System.out.print("\t\tYour Input: ");
                    int userChoice = userInput.nextInt();

                    if (userChoice == 1) {//create account

                        Account newUserAccount = new Account();
                        newUserAccount.createAccount();
                        bank.addAccount(newUserAccount);
                        //TODO give access to more functions once the user has created an account
                    } else if (userChoice == 2) {//see existing one

                        Scanner nameScanner = new Scanner(System.in);
                        System.out.print("\tEnter name of the account: ");
                        Account account = bank.getByName((nameScanner.next()).toUpperCase());

                        if (account != null) {

                            System.out.println("\tPress 1 To Check Your Balance!");
                            System.out.println("\tPress 2 To Withdraw!");
                            System.out.println("\tPress 3 To Deposit!");

                            System.out.print("\t\tYour Input: ");
                            Scanner optionsScanner = new Scanner(System.in);

                            int optionSelected = optionsScanner.nextInt();

                            if (optionSelected == 1) {
                                System.out.println("\tAccount balance: [" + decfor.format(account.getBalance()) + "]");
                            } else if (optionSelected == 2) {
                                System.out.println("\tIn your account you have [" + decfor.format(account.getBalance()) + "] Flat fee is 10$ and percent value is 5%");
                                System.out.print("\t\tEnter amount you wish to withdraw: ");
                                double amountToWithdraw = optionsScanner.nextDouble();

                                ///      500         - (500 + 10) = 500-510 = -10
                                ///     500         - (500 + 25) = 500-525 = -25
                                ///     500         - (490 + 10) = 500-500 = 0
                                ///     500         - (490 +(490 * 0.05)) = 500 - 514.5 = -14.5

                                double balanceAfterFlatFee = account.getBalance() - (amountToWithdraw + Bank.transactionFlatFeeAmount);
                                double balanceAfterPercentageFee = account.getBalance() - (amountToWithdraw + (amountToWithdraw * Bank.transactionPercentFeeValue));

                                //(account.getBalance()- balanceAfterPercentageFee) > 0||(account.getBalance() - balanceAfterFlatFee)>0
                                if (amountToWithdraw < 200) {
                                    // 200 - 55 + (55 * 10)
                                    // 200 - (55 + 10)    200 - (55 + 10) 150

                                    if (balanceAfterFlatFee > 0) {


                                        account.withdraw(amountToWithdraw, "Withdraw", Bank.transactionFlatFeeAmount);
                                        bank.addFeeToTransactionAmount(Bank.transactionFlatFeeAmount);
                                        bank.addAmountToTotalTransferAmount(amountToWithdraw + Bank.transactionFlatFeeAmount);
                                        System.out.println("\tYour balanced is updated!!! balance: [" + decfor.format(account.getBalance()) + "]");


                                    } else {
                                        System.out.println("\tInsufficient Funds!");
                                    }

                                } else if (amountToWithdraw > 200) {
                                    //   300 - 55 + (55 * 0.05)   300 - (55 + (55*0.05))  300 - (55 + (55 * 0.05))
                                    if (balanceAfterPercentageFee > 0) {

                                        account.withdraw(amountToWithdraw, "Withdraw", Bank.transactionPercentFeeValue);

                                        bank.addFeeToTransactionAmount(amountToWithdraw * Bank.transactionPercentFeeValue);

                                        bank.addAmountToTotalTransferAmount(amountToWithdraw + (Bank.transactionPercentFeeValue * amountToWithdraw));
                                        System.out.println("\tYour balanced is updated!!! balance: [" + decfor.format(account.getBalance()) + "]");

                                    } else {
                                        System.out.println("\tInsufficient Funds!");

                                    }
                                }

                            } else if (optionSelected == 3) {
                                Scanner depositScanner = new Scanner(System.in);
                                System.out.print("Enter amount you wish to deposit: ");
                                double amountTodeposit = depositScanner.nextDouble();
                                account.deposit(amountTodeposit, "Deposit", Bank.transactionFlatFeeAmount);

                                System.out.println("You balance is updated!!! balance: [" + decfor.format(account.getBalance()) + "]");


                            } else {
                                System.out.println("Wrong input");
                            }

                        } else {
                            System.out.println("Account with given name does not exist!!");
                        }

                    } else if (userChoice == 0) {
                        isUserActive = false;
                    } else {
                        //TODO take user to fill choice again if wrong input
                    }
                }

            } else if (memberType == 0) {//TODO if user wants to exit from the application this part handles it
                isApplicationActive = false;
            } else {
                //TODO take user to fill choice again if wrong input
                System.out.println("Check your input again!!!");

            }
        }
    }
}