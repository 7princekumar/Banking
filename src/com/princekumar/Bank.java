package com.princekumar;

import java.util.ArrayList;

/**
 * Created by princekumar on 07/08/17.
 */
public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public void addNewBranch(String branchName){
        if(isBranchAdded(name)){
            System.out.println("Branch, "+branchName +" , is already added in "+this.name +" bank.");
        }else{
            branches.add(Branch.createBranch(branchName));
        }
    }

    public void addCustomerInBranch(String branchName, String customerName, double initialTransaction){
        if(branchPosition(branchName) >= 0){
            branches.get(branchPosition(branchName)).addNewCustomer(customerName, initialTransaction);
        }else{
            System.out.println("Cannot add "+customerName+" in "+branchName+ " of "+ this.getName() +" Bank.");
            if(isBranchAdded(branchName)){
                if(!branches.get(branchPosition(branchName)).isCustomerAdded(customerName)){
                    System.out.println("Customer "+customerName+" is not added in "+branchName+ " branch.");
                }
            }else{
                System.out.println("Branch " +branchName+ " is not added.");
            }
        }
    }

    public void addTransactionsOfCustomerInBranch(String customerName, String branchName, double transactionMoney){
        branches.get(branchPosition(branchName)).getCustomer(customerName).addTrasaction(transactionMoney);
    }

    public String getName(){
        return this.name;
    }

    public boolean isBranchAdded(String branchName){
        for(int i = 0; i< branches.size(); i++){
            if(branches.get(i).getName().equals(branchName)){
                return true;
            }
        }
        return false;
    }

    private int branchPosition(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }


    public void showBranches(){
        if(this.isBranchesEmpty()){
            System.out.println("No branch is added yet.");
            return;
        }
        System.out.println("Branches of " +this.getName() +" :");
        for(int i = 0; i< this.branches.size(); i++){
            System.out.println((i+1) +". " +this.branches.get(i).getName());
        }
    }

    public void showCustomersOfBranch(String branchName){
        if(isBranchAdded(branchName)){
                branches.get(branchPosition(branchName)).showListOfCustomers();
        }else{
            System.out.println("Branch " +branchName+ " is not present in this bank.");
        }
    }

    public void showCustomersOfBranchWithTransactions(String branchName){
        if(isBranchAdded(branchName)){
            branches.get(branchPosition(branchName)).showListOfCustomersWithTransactions();
        }else{
            System.out.println("Branch " +branchName+ " is not present in this bank.");
        }
    }

    public boolean isBranchesEmpty(){
        return this.branches.isEmpty();
    }

    public boolean isCustomerPresentInBranch(String branchName, String customerName){
        if(isBranchesEmpty() || !isBranchAdded(branchName)){
            return false;
        }else{
            return (this.branches.get(branchPosition(branchName)).isCustomerAdded(customerName));
        }
    }
}
