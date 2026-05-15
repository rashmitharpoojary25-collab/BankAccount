package com.bank.model;

import com.bank.exception.InsufficientFundsException;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String accountHolder;
    private double balance;
    private List<Transaction> transactionHistory;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        transactionHistory.add(new Transaction("DEPOSIT", amount));
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds! Balance: " + balance);
        }
        balance -= amount;
        transactionHistory.add(new Transaction("WITHDRAWAL", amount));
    }

    public double getBalance() { return balance; }
    public String getAccountHolder() { return accountHolder; }
    public List<Transaction> getTransactionHistory() { return transactionHistory; }

    public void printStatement() {
        System.out.println("\n===== MINI STATEMENT =====");
        System.out.println("Account Holder: " + accountHolder);
        for (Transaction t : transactionHistory) {
            System.out.println(t);
        }
        System.out.println("Current Balance: " + balance);
    }
}