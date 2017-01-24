package com.example.toon.boardgamerandomizer.Persistency.Requests;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.example.toon.boardgamerandomizer.Model.Root;
import com.example.toon.boardgamerandomizer.Persistency.Deserializer.BoardgameSerializer;
import com.example.toon.boardgamerandomizer.Persistency.Deserializer.RootDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by Toon on 24/01/2017.
 */

public class GsonRequest<T> extends Request<T> {
    private Gson gson;
    private final Class<T> clazz;
    private final Map<String, String> headers;
    private final Response.Listener<T> listener;

    public GsonRequest(String url,Class<T> clazz, Map<String, String>  headers, Response.Listener<T> listener, Response.ErrorListener errListener) {
        super(Method.GET, url, errListener);

        this.clazz = clazz;
        this.headers = headers;
        this.listener = listener;
        setGson();
    }

    private void setGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Root.class, new RootDeserializer());
        builder.registerTypeAdapter(BoardgameSerializer.class, new BoardgameSerializer());
        gson = builder.create();
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }


    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(gson.fromJson(json, clazz), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }
}
