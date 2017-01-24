package com.example.toon.boardgamerandomizer.Model;

/**
 * Created by Toon on 24/01/2017.
 */

public class Boardgame {
    private int id;
    private String name;
    private String thumbnailUrl;
    private double rating;
    private int minPlayer;
    private int maxPlayer;
    private int playingTime;
    private boolean owned;

    public Boardgame(int id, String name, String thumbnailUrl, double rating, int minPlayer, int maxPlayer, int playingTime, boolean owned) {
        this.id = id;
        this.name = name;
        this.thumbnailUrl = thumbnailUrl;
        this.rating = rating;
        this.minPlayer = minPlayer;
        this.maxPlayer = maxPlayer;
        this.playingTime = playingTime;
        this.owned = owned;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getMinPlayer() {
        return minPlayer;
    }

    public void setMinPlayer(int minPlayer) {
        this.minPlayer = minPlayer;
    }

    public int getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(int maxPlayer) {
        this.maxPlayer = maxPlayer;
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
