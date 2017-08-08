package com.princekumar;

import java.util.ArrayList;

/**
 * Created by princekumar on 07/08/17.
 */
public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
    }

    public String getName(){
        return this.name;
    }

    public void addTrasaction(double value){
        this.transactions.add(value);
    }

    public static Customer createCustomer(String name){
        return new Customer(name);
    }

    public void showTransactions(){
        System.out.println("Transactions of " +this.getName() +" :");
        for(int i = 0; i< this.transactions.size(); i++){
            System.out.println((i+1) +". " +this.transactions.get(i));
        }
    }
}
