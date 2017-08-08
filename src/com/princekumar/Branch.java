package com.princekumar;

import java.util.ArrayList;

/**
 * Created by princekumar on 07/08/17.
 */
public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public void addNewCustomer(String name, double firstTransactionValue){
        if(isCustomerAdded(name)){
            System.out.println("Customer, "+name +" , is already added in "+this.name +" branch.");
        }else{
            customers.add(Customer.createCustomer(name));
            customers.get(0).addTrasaction(firstTransactionValue);
        }
    }

    public void addNewTransaction(String name, double transactionValue){
        if(isCustomerAdded(name)){
            customers.get(customerPosition(name)).addTrasaction(transactionValue);
        }else{
            System.out.println("Customer, "+name +" , is not added in "+this.name +" branch. \nCannot add trasaction.");
        }
    }

    public boolean isCustomerAdded(String name){
        for(int i = 0; i< customers.size(); i++){
            if(customers.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    private int customerPosition(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public String getName(){
        return this.name;
    }

    public static Branch createBranch(String branchName){
        return new Branch(branchName);
    }

    public void showListOfCustomers(){
        if(this.customers.isEmpty()){
            System.out.println("No customer is added yet.");
            return;
        }
        System.out.println("Customers: ");
        for(int i =0; i< customers.size(); i++){
            System.out.println((i+1) +". " +customers.get(i).getName());
        }
    }

    public void showListOfCustomersWithTransactions(){
        if(this.customers.isEmpty()){
            System.out.println("No customer is added yet.");
            return;
        }
        System.out.println("Customers: ");
        for(int i =0; i< customers.size(); i++){
            System.out.println((i+1) +". " +customers.get(i).getName());
            customers.get(i).showTransactions();
        }
    }

    public Customer getCustomer(String name){
        if (customerPosition(name) >=0 ){
            return customers.get(customerPosition(name));
        }else{
            return null;
        }
    }

}
