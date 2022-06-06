package com.company;

public class Main {

    public static void main(String[] args) throws CreditAccount.CreditAccountException {
        Account savings = new SavingsAccount();
        Account credit = new CreditAccount();
        Account checking = new CheckingAccount();

        savings.setBalance(10_000);
        checking.setBalance(2000);
        credit.pay(1000);
        credit.addMoney(500);
        credit.addMoney(350);
        credit.addMoney(50);
        credit.transfer(checking, 100);
        checking.transfer(savings, 2000);
        savings.transfer(credit, 200);

        System.out.println(credit.getBalance());
        System.out.println(checking.getBalance());
        System.out.println(savings.getBalance());
    }
}
