package com.example.toon.boardgamerandomizer.Views.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.toon.boardgamerandomizer.Model.Boardgame;
import com.example.toon.boardgamerandomizer.Model.DaoSession;
import com.example.toon.boardgamerandomizer.Model.Root;
import com.example.toon.boardgamerandomizer.Persistency.Database.MyDB;
import com.example.toon.boardgamerandomizer.Persistency.Requests.GsonRequest;
import com.example.toon.boardgamerandomizer.R;
import com.example.toon.boardgamerandomizer.Views.Adapter.BoardGameAdapter;
import com.example.toon.boardgamerandomizer.Views.UIUtiles.UIUtiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Toon on 24/01/2017.
 */

public class BoardGameViewFragment extends Fragment {
    @BindView(R.id.rvBoardgameList)
    RecyclerView rvBoardGame;

    private RequestQueue queue;
    private List<Boardgame> list;
    private final String URL = "https://bgg-json.azurewebsites.net/";
    private View rootView;
    private MyDB db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_boardgames_layout,container,false);
        ButterKnife.bind(this,v);
        initialize();
        return v;
    }

    private String makeUrl(){
        String user = getArguments().getString("user");
        return URL + "collection/" + user;
    }

    private void initialize(){
        list = new ArrayList<>();
        queue = Volley.newRequestQueue(getContext());

        db = new MyDB(getContext());
        db.startDatabase();
        getData();

        if(list == null || list.isEmpty()){
            responseObject(makeUrl());
        } else {
            initializeRecyclerView();
        }
    }

    private void getData(){
        list = db.getData();
    }

    private void initializeRecyclerView(){
        LinearLayoutManager lManager = new LinearLayoutManager(getContext());
        rvBoardGame.setLayoutManager(lManager);
        BoardGameAdapter adapter = new BoardGameAdapter(getActivity(),list);
        rvBoardGame.setAdapter(adapter);
    }

    @SuppressWarnings("unchecked")
    private void responseObject(String url){
        GsonRequest gsonRequest = new GsonRequest(url,Root.class,null, new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                final Root root = (Root) response;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        db.seeding(root.getBoardgames());
                    }
                }).start();

                fillBoardGameListIn(root.getBoardgames());
                initializeRecyclerView();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                UIUtiles.makeToast(getContext(),R.string.error, Toast.LENGTH_LONG);
                Log.e("error",error.getMessage());
            }
    });

        queue.add(gsonRequest);

    }

    private void fillBoardGameListIn(Boardgame[] data){
        Collections.addAll(list, data);
    }
}
