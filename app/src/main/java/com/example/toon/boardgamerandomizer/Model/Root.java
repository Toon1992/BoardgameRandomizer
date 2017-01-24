package com.example.toon.boardgamerandomizer.Model;

/**
 * Created by Toon on 24/01/2017.
 */

public class Root {
    private Boardgame[] boardgames;

    public Root(Boardgame[] boardgames) {
        this.boardgames = boardgames;
    }

    public Boardgame[] getBoardgames() {
        return boardgames;
    }

    public void setBoardgames(Boardgame[] boardgames) {
        this.boardgames = boardgames;
    }
}
