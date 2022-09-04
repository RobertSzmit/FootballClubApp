package com.example.footballclubapp;

public class TermsModel {

    String teams;

    TermsModel(){

    }

    public TermsModel(String teams) {
        this.teams = teams;
    }
    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

}
