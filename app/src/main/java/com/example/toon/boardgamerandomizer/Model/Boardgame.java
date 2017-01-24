package com.example.toon.boardgamerandomizer.Model;

/**
 * Created by Toon on 24/01/2017.
 */

public class Boardgame {
    private int gameId;
    private String name;
    private String thumbnail;
    private double averageRating;
    private int minPlayers;
    private int maxPlayers;
    private int playingTime;
    private boolean owned;

    public Boardgame(int gameId, String name, String thumbnail, double averageRating, int minPlayers, int maxPlayers, int playingTime, boolean owned) {
        this.gameId = gameId;
        this.name = name;
        this.thumbnail = thumbnail;
        this.averageRating = averageRating;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playingTime = playingTime;
        this.owned = owned;
    }



    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(int playingTime) {
        this.playingTime = playingTime;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }
}
