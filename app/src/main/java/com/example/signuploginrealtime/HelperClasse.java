package com.example.signuploginrealtime;

public class HelperClasse {

    String name, party;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }


    public HelperClasse(String name, String party) {
        this.name = name;
        this.party = party;

    }
    public HelperClasse(String party2) {

    }
}
