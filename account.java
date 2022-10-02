package banking_application;

import java.util.Scanner;

class Account {
    //Class Variables
    double balance=10000;
   
    String customerName;
    String customerID;

    //Class constructor
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    //Function for Depositing money
    void deposit(double amount) {
        if (amount != 0) {
            balance = balance + amount;
            
        }
    }

    //Function for Withdrawing money
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            
        }
    }


    //Function To transfer the amount

    public void transferAmount(double amount,double benificiaryAccountNumber,String benificaryName,String benificaryId) {
        if (amount < 0) // transfer value is negative
        {
            System.out.println();
            System.out.println("Error: transfer amount is invalid.");
        } else if (amount > balance) // transfer value exceeds balance
        {
            System.out.println();
            System.out.println("Error: Insufficient funds.");
            System.out.println("Requested: " + amount);
            System.out.println("Available: " + balance);
        } else {

            try{
//                check if the details of account,id are valid
                balance = balance - amount; //deduct the amount from the customer one

                //this the customer having these details benificiaryAccountNumber,benificaryName,benificaryIFSCcode

                Account customer =getTheAccountDetails(benificiaryAccountNumber,benificaryName,benificaryId);

                customer.deposit(amount);

                
                
                System.out.println("Successfully transferred the amount to account number "+String.format("%.0f",benificiaryAccountNumber));


            } catch (Exception ex){
                System.out.println("Something went wrong in transferring funds, please contact the bank,");
            }



        }
    }

    public Account getTheAccountDetails(double benificiaryAccountNumber,String benificaryName,String benificaryId){

        //check these account number and id return account of that customer
        return new Account("c1","01");

    }



    //Function showing the main menu
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to IDFC First Bank, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A.view balance");
        System.out.println("B.deposit");
        System.out.println("C.withdrawal");
        System.out.println("D.transfer  amount");
        System.out.println("E. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                //Case 'A' allows the user to check their account balance
                case 'A':
                    System.out.println("====================================");
                    System.out.println("Balance = rs=" + balance);
                    System.out.println("====================================");
                    System.out.println();
                    break;
                //Case 'B' allows the user to deposit money into their account using the 'deposit' function
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                //Case 'C' allows the user to withdraw money from their account using the 'withdraw' function
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                
                case 'E':
                    System.out.println("====================================");
                    break;
                //The default case let's the user know that they entered an invalid character and how to enter a valid one

                case 'D':
                    System.out.println("Enter an amount to transfer: ");
                    double amountToTransfer = scanner.nextDouble();
                    System.out.println("Enter an accountnumber to transfer: ");
                    double accountNumber = scanner.nextDouble();
                    System.out.println("Enter an account name: ");
                    String accountName =scanner.next();
                    System.out.println("Enter an account id : ");
                    String accountId =scanner.next();

                    transferAmount(amountToTransfer,accountNumber,accountName,accountId);
                    break;
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D or access services.");
                    break;
            }
        } while (option != 'E');
        System.out.println("Thank you for banking with us!");
    }

}