package com.example.toon.boardgamerandomizer.Persistency.Deserializer;

import android.util.Log;

import com.example.toon.boardgamerandomizer.Model.Boardgame;
import com.example.toon.boardgamerandomizer.Model.Root;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toon on 24/01/2017.
 */

public class RootDeserializer implements JsonDeserializer<Root> {
    @Override
    public Root deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

       final JsonArray jsonObject = json.getAsJsonArray();

        Boardgame[] boardgames = context.deserialize(json.getAsJsonArray(),Boardgame[].class);
        //fillBoardGame(jsonObject);
        //Boardgame[] boardgames = context.deserialize(jsonObject.get("children"), Boardgame[].class);
        return new Root(boardgames);
    }

//    private void fillBoardGame(JsonArray array){
//        List<Boardgame> list = new ArrayList<>();
//        for(JsonElement el : array){
//            JsonObject jsonObject = el.getAsJsonObject();
//            Boardgame temp = new Boardgame(jsonObject.get("gameId").getAsInt()
//                    ,jsonObject.get("name").getAsString()
//                    ,jsonObject.get("thumbnail").getAsString()
//                    ,jsonObject.get("averageRating").getAsDouble()
//                    ,jsonObject.get("minPlayers").getAsString()
//                    )
//
//        }
//    }
}
