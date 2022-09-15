package com.example.footballclubapp.team;

public class TeamModel {

    String image, player;

    TeamModel(){

    }

    public TeamModel(String image, String player) {
        this.image = image;
        this.player = player;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
