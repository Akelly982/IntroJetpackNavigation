package com.aidankelly.introjetpacknavigation.classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class player implements Serializable {

    String playerName;
    Boolean winLose;
    String score;
    String level;


    //constructor empty
    public player() {

    }

    //constructor all data
    public player(String playerName, Boolean winLose, String score, String level) {
        this.playerName = playerName;
        this.winLose = winLose;
        this.score = score;
        this.level = level;
    }


    // getters and setters  (not private variables so do not really need these)

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Boolean getWinLose() {
        return winLose;
    }

    public void setWinLose(Boolean winLose) {
        this.winLose = winLose;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
