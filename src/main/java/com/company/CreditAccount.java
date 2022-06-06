package com.company;

public class CreditAccount extends Account{

    private int balance = 0;

    public int getBalance() {
        return balance;
    }

    @Override
    public void pay(int amount) {
        balance = balance - amount;
    }

    @Override
    public void transfer(Account account, int amount) throws CreditAccountException {
        account.addMoney(amount);
        balance = balance - amount;
    }

    @Override
    public void addMoney(int amount) throws CreditAccountException {
        if (amount + balance >= 0) {
            throw new CreditAccountException(balance);
        } else {
            balance = balance + amount;
        }
    }

    public static class CreditAccountException extends Exception {

        CreditAccountException(int balance) {
            super("You are adding too much money on your credit account.\nYour curring debt is: " + balance);
        }
    }

}
