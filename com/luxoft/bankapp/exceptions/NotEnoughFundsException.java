package com.luxoft.bankapp.exceptions;

public class NotEnoughFundsException extends BankException {
    private int id;
    private double balance;
    private double amount;
    private double maximum_withdrawel_amount;

    public NotEnoughFundsException(int id, double balance, double amount, double maximum_withdrawel_amount) {
        super("Not enough funds for account " + id + ". Current balance: " + balance + ", requested amount: " + amount + ", maximum withdrawel amount: " + maximum_withdrawel_amount);
        this.id = id;
        this.balance = balance;
        this.amount = amount;
        this.maximum_withdrawel_amount = maximum_withdrawel_amount;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAmount() {
        return amount;
    }
}
