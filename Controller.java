package org.lu.ics.labs;

import java.util.ArrayList;
import javax.swing.JFrame;

public class Controller {
    PersonRegister PR = new PersonRegister();
    Account BankAccount;
    JFrame customerFrame;

    public void addPerson(Person p) {
        PR.addPerson(p);
    }

    public Person removePerson(String pNbr) {
        return PR.removePerson(pNbr);
    }

    public Person findPerson(String pNbr) {
        return PR.findPerson(pNbr);
    }

    public void addAccount(Account a, Person p){
        p.addAccount(a);
        a.setPerson(p);
    }

    public void credit(double amount, String pNbr, String nbr){
        Account tmp = findSpecificAccount(pNbr, nbr);
        if(tmp != null){
            tmp.credit(amount);
        }
    }

    public void withdraw(double amount, String pNbr, String nbr){
        Account tmp = findSpecificAccount(pNbr,nbr);
        if(tmp != null){
            tmp.withdraw(amount);
        }
    }

    public ArrayList<Account> findPersonAccounts (String pNbr) {
        return PR.findPersonAccounts(pNbr);
    }

    public void setOwner(Person p) {
        //
    }

    public Account findSpecificAccount (String pNbr, String nbr){
        ArrayList<Account> tmpList = PR.findPersonAccounts(pNbr);
        if (tmpList != null) {
            for (Account a : tmpList) {
                if (a.getNbr().equals(nbr)) {
                    return a;
                }
            }
        }
        return null;
    }
}