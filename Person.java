package org.lu.ics.labs;

import java.util.ArrayList;

public class Person {
    private String pNbr;
    private String name;
    private ArrayList<Account> BankAccount = new ArrayList <Account>();

    public Person(String name, String pNbr) {
        this.name = name;
        this.pNbr = pNbr;
    }

    public void setAccount(ArrayList<Account> newLista) {
        BankAccount = newLista;
    }

    public ArrayList<Account>getBankAccount(){
        return BankAccount;
    }

    public void addAccount (Account a) {
        BankAccount.add(a);
    }

    public void setPNbr(String pNbr) {
        this.pNbr = pNbr;
    }

    public String getPNbr() {
        return pNbr;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }
}