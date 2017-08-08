package com.princekumar;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank sbiBank = new Bank("SBI");

    public static void main(String[] args) {
        openBank(sbiBank);
        boolean quit = false;
        printMenu();

        while(!quit){
            System.out.println("Choice (8 for options): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); //to clear the buffer

            switch(choice){
                case 1: closeBank(sbiBank);
                        quit = true;
                        break;
                case 2: addNewBranch();   break;
                case 3: addNewCustomer(); break;
                case 4: addTransaction(); break;
                case 5: sbiBank.showBranches(); break;
                case 6: showCustomersOfBranch();break;
                case 7: showCustomersOfBranchWithTransactions(); break;
                case 8: printMenu(); break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }


    private static void openBank(Bank bank){
        System.out.println("Opening bank "+bank.getName() +" ...");
    }

    private static void closeBank(Bank bank){
        System.out.println("Closing bank "+bank.getName() +" ...");
    }

    private static void addNewBranch(){
        System.out.println("Enter the branch name: \r");
        String branchName = scanner.nextLine();

        sbiBank.addNewBranch(branchName);
    }

    private static void addNewCustomer(){
        if(sbiBank.isBranchesEmpty()){
            System.out.println("Create a branch first.");
            return;
        }
        System.out.println("Enter the branch Name: ");
        String branchName = scanner.nextLine();
        if(!sbiBank.isBranchAdded(branchName)){
            System.out.println("Branch " +branchName+ " is not present in this bank.");
            return;
        }
        System.out.println("Enter Customer's Name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter initial transaction amount: ");
        double initialTransaction = scanner.nextDouble();

        sbiBank.addCustomerInBranch(branchName,customerName,initialTransaction);
    }

    private static void addTransaction(){
        if(sbiBank.isBranchesEmpty()){
            System.out.println("Create a branch first.");
            return;
        }

        System.out.println("Enter the branch Name: ");
        String branchName = scanner.nextLine();
        if(!sbiBank.isBranchAdded(branchName)){
            System.out.println("Branch " +branchName+ " is not present in this bank.");
            return;
        }

        System.out.println("Enter Customer's Name: ");
        String customerName = scanner.nextLine();
        if(!sbiBank.isCustomerPresentInBranch(branchName,customerName)){
            System.out.println("Customer is not present in this branch.");
            return;
        }

        System.out.println("Enter transaction amount: ");
        double transaction = scanner.nextDouble();

        sbiBank.addTransactionsOfCustomerInBranch(customerName,branchName,transaction);
    }


    private static void showCustomersOfBranch(){
        if(sbiBank.isBranchesEmpty()){
            System.out.println("No branch is added yet.");
            return;
        }
        System.out.println("Enter the branch. ");
        String branchName = scanner.nextLine();

        sbiBank.showCustomersOfBranch(branchName);
    }


    private static void showCustomersOfBranchWithTransactions(){
        if(sbiBank.isBranchesEmpty()){
            System.out.println("No branch is added yet.");
            return;
        }
        System.out.println("Enter the branch. ");
        String branchName = scanner.nextLine();

        sbiBank.showCustomersOfBranchWithTransactions(branchName);
    }




    private static void printMenu(){
        System.out.println("Press");
        System.out.println("\t 1. Quit");
        System.out.println("\t 2. Add New Branch");
        System.out.println("\t 3. Add New Customer in a branch");
        System.out.println("\t 4. Add transactions of Customer in a branch");
        System.out.println("\t 5. Print List of Branches");
        System.out.println("\t 6. Print list of Customers in a branch");
        System.out.println("\t 7. Print list of Transactions of a customer in a branch");
        System.out.println("\t 8. Print lists of actions.");
    }



}
