package com.example.toon.boardgamerandomizer.Persistency.Deserializer;

import com.example.toon.boardgamerandomizer.Model.Boardgame;
import com.example.toon.boardgamerandomizer.Model.Root;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Toon on 24/01/2017.
 */

public class RootDeserializer implements JsonDeserializer<Root> {
    @Override
    public Root deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
       final JsonObject jsonObject = json.getAsJsonObject();
        Boardgame[] boardgames = context.deserialize(jsonObject.get("children"), Boardgame[].class);
        return new Root(boardgames);
    }
}
