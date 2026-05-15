package com.bank.test;

import com.bank.exception.InsufficientFundsException;
import com.bank.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("Test User", 1000.0);
    }

    @Test
    void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    void testWithdraw() throws InsufficientFundsException {
        account.withdraw(200.0);
        assertEquals(800.0, account.getBalance());
    }

    @Test
    void testInsufficientFunds() {
        assertThrows(InsufficientFundsException.class, () -> {
            account.withdraw(2000.0);
        });
    }

    @Test
    void testNegativeDeposit() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100.0);
        });
    }

    @Test
    void testTransactionHistorySize() throws InsufficientFundsException {
        account.deposit(500.0);
        account.withdraw(200.0);
        assertEquals(2, account.getTransactionHistory().size());
    }

    @Test
    void testInitialBalance() {
        assertEquals(1000.0, account.getBalance());
    }
}