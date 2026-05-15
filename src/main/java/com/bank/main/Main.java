package com.bank.main;

import com.bank.exception.InsufficientFundsException;
import com.bank.model.BankAccount;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(name, initialBalance);
        boolean continueApp = true;

        while (continueApp) {
            System.out.println("\n===== BANK ACCOUNT SYSTEM =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Print Statement");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("Deposited successfully! New Balance: " + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        System.out.println("Withdrawn successfully! New Balance: " + account.getBalance());
                        break;
                    case 3:
                        System.out.println("Current Balance: " + account.getBalance());
                        break;
                    case 4:
                        account.printStatement();
                        break;
                    case 5:
                        continueApp = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input! Try again.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}