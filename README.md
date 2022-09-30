# Bank_System_EnesSejdini
OOP Simple Java Banking System Solution


The following project is a console application that represents the abstractions of a simple banking system. 

Structure:


Functionality:

In terms of functionality the project is structured with the admin and user abstractions with the following roles:
Admin is able to see:
List Of All Bank Accounts
Total Of All Transaction Fees
Total Of Transacrtions

User is able to:
Create An Account
Access An Existing One
Check Account Balance
Withdraw Money
Deposit Money


How To Use: In this section the behaviour of the program will be analysed in case of every input from the user

Firstly the program will ask you to:
Press 1 To Access Admin Functions
Press 2 To Access User Functions
Press 0 To Exist

------------------------------------------------------------------------------------------------------------------
In case of Pressing 1 you will be welcomed by:

Welcome to admin panel
Press 1 For List Of All Accounts
Press 2 For Total Transaction Fee Amount
Press 3 For Total Transfer Amount

If User Press 1:
A list of all bank accounts will be shown and the program will go back to the main welcoming screen.

If User Press 2:
A total of all transaction fees from any transactions in the program will be shown
and the program will go back to the main welcoming screen.

If User Press 3:
A total of the amount of all money transfered will be shown and the program will go back to the 
main welcoming screen.
----------------------------------------------------

In case of Pressing 2 you will be welcomed by: 

Press 1 To Create An Account!
Press 2 To Access An Existing One!
Press 0 To Exit

If User Press 1 - The following will be shown:
Enter your name for your account: 

The user will expect an input that will be the desired name for an account. Upon completion of the input an
account will be created

The application will send you to the same messages you saw previously.



If User Press 2 - The following will be shown:
Enter name of the account: 

The user will expect an input that will be the account you desire to access. Upon completion of the input
the application will compare your input to find the same name in the list of accounts.

If user input matches with one of the accounts the following will be shown:

  Press 1 To Check Your Balance!
	Press 2 To Withdraw!
	Press 3 To Deposit!

  If User Press 1 - The application will show the account balance as following:

   Account balance: ['Amount Of Money In The Account']

  If User Press 2 - The user will be able to withdraw money as following:
			
  In your account you have [0.00] Flat fee is 10$ and percent value is 5%
				Enter amount you wish to withdraw: 
		
   A message of the amount of money you have in your account will be shown, the types of fees that will be
	 applied and the program will ask you to input the amount of money you wish to withdraw
		
   In case of withdrawing money the program will behave according to two cases:

   When there is enough money on the account to be withdrawn:
			Money will be deducted from the balance and the following will be shown:

   Your balanced is updated!!! balance: ['Balance After Deducting Withdrawal']

   When there is not enough money on the account to be withdrawn:
			A message will be shown as follows:
	
   Insufficient Funds!

   Note: Neccessary functions implemented to reduce the right amount of money in withdrawal after
	 calculating the withdrawal fees.

  If User Press 3 - The user will be able to deposit money as following:
			
  Enter amount you wish to deposit:
		
  The program will ask the user to input the money needed to be deposited. Upon completion of the input
	the money will be added to the balance and the following message will be shown:
			
  You balance is updated!!! balance: ['Balance After Deposit']
		
		
  After any complete user interaction the application will send you to 
	the same messages you saw previously.

		
  If users input does not match with any account the following will be shown:
		
   Account with given name does not exist!!

		






