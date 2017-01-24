package com.example.toon.boardgamerandomizer.Persistency.Deserializer;

import com.example.toon.boardgamerandomizer.Model.Boardgame;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Toon on 24/01/2017.
 */

public class BoardgameSerializer implements JsonDeserializer<Boardgame> {
    @Override
    public Boardgame deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        //Getting the attributes from the json file
        final JsonObject jsonObject = json.getAsJsonObject();

        final int id = jsonObject.get("gameId").getAsInt();
        final String name = jsonObject.get("name").getAsString();
        final String thumb = jsonObject.get("thumbnail").getAsString();
        final int minPlayer = jsonObject.get("minPlayer").getAsInt();
        final int maxPlayer = jsonObject.get("maxPlayer").getAsInt();
        final int playingTime = jsonObject.get("playingTime").getAsInt();
        final double rating = jsonObject.get("averageRating").getAsDouble();
        final boolean own = jsonObject.get("owned").getAsBoolean();

        return new Boardgame(id,name,thumb,rating,minPlayer,maxPlayer,playingTime,own);
    }
}
