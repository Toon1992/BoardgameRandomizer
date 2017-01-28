package com.example.toon.boardgamerandomizer.Model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Toon on 24/01/2017.
 */

@Entity
public class Boardgame {

    @Id
    private long gameId;

    private String name;
    private String image;
    private double averageRating;
    private int minPlayers;
    private int maxPlayers;
    private int playingTime;
    private boolean owned;

    @Keep
    public Boardgame(int gameId, String name, String image, double averageRating, int minPlayers, int maxPlayers, int playingTime, boolean owned) {
        this.gameId = gameId;
        this.name = name;
        this.image = image;
        this.averageRating = averageRating;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playingTime = playingTime;
        this.owned = owned;
    }



    @Generated(hash = 2136645576)
    public Boardgame() {
    }



    @Generated(hash = 1371529074)
    public Boardgame(long gameId, String name, String image, double averageRating, int minPlayers, int maxPlayers, int playingTime, boolean owned) {
        this.gameId = gameId;
        this.name = name;
        this.image = image;
        this.averageRating = averageRating;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playingTime = playingTime;
        this.owned = owned;
    }



    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return image;
    }

    public void setThumbnail(String thumbnail) {
        this.image = thumbnail;
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



    public String getImage() {
        return this.image;
    }



    public void setImage(String image) {
        this.image = image;
    }



    public boolean getOwned() {
        return this.owned;
    }
}
