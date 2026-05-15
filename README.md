# Bank Account Management System

A Java-based Bank Account System with JUnit 5 unit testing.

## Features
- Deposit and Withdrawal
- Balance Inquiry
- Transaction History
- Custom Exception (InsufficientFundsException)
- 6 JUnit 5 unit tests with 100% pass rate

## Project Structure
src/
├── main/java/com/bank/
│   ├── model/BankAccount.java
│   ├── model/Transaction.java
│   ├── exception/InsufficientFundsException.java
│   └── main/Main.java
└── test/java/com/bank/test/
└── BankAccountTest.java

## How to Run
1. Install JDK 17 or above
2. Open project in IntelliJ IDEA
3. Run Main.java for the app
4. Run BankAccountTest.java for unit tests

## Technologies Used
- Java JDK 26
- JUnit 5 for unit testing
- Maven for dependency management
- Custom Exception Handling