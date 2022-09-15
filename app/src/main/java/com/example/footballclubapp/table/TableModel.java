package com.example.footballclubapp.table;

public class TableModel {

    String image, team;

    TableModel(){

    }

    public TableModel(String image, String team) {
        this.image = image;
        this.team = team;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
