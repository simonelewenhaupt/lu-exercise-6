package org.lu.ics.labs;

import java.util.ArrayList;

public class PersonRegister {
    private ArrayList<Person> Persons = new ArrayList <Person>();

    public void setPerson(ArrayList<Person> newList) {
        Persons = newList;
    }

    public ArrayList<Person> getPersons(){
        return Persons;
    }

    public void addPerson (Person p) {
        Persons.add(p);
    }

    public Person findPerson (String pNbr) {
        for(Person tmp: Persons) {
            if(tmp.getPNbr(). equals(pNbr)) {
                return tmp;
            }
        }
        return null;
    }

    public Person removePerson (String pNbr) {
        for (Person tmp: Persons) {
            if(tmp.getPNbr().equals(pNbr)) {
                Persons.remove(tmp);
                return tmp;

            }
        }
        return null;
    }

    public ArrayList<Account>findPersonAccounts(String pNbr){
        Person p = this.findPerson(pNbr);
        if (p != null) {
            return p.getBankAccount();
        }

        return null;
    }

}