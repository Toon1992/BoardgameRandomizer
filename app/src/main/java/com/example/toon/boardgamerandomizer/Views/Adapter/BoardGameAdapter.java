package com.example.toon.boardgamerandomizer.Views.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toon.boardgamerandomizer.Model.Boardgame;
import com.example.toon.boardgamerandomizer.R;
import com.example.toon.boardgamerandomizer.Views.UIUtiles.UIUtiles;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Toon on 24/01/2017.
 */

public class BoardGameAdapter extends RecyclerView.Adapter<BoardGameAdapter.BoardGameViewHolder>{


    public static class BoardGameViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivBoardGameThumbnail)
        ImageView ivThumbnail;
        @BindView(R.id.tvBoardGameTitle)
        TextView tvTitle;
        @BindView(R.id.tvPlayers)
        TextView tvPlayers;
        @BindView(R.id.tvRating)
        TextView tvRating;
        @BindView(R.id.tvPlaytime)
        TextView tvPlayTime;

        public BoardGameViewHolder(View v){
            super(v);
            ButterKnife.bind(this,v);
        }
    }

    private List<Boardgame> boardgameList;
    private Activity ac;
    public BoardGameAdapter(Activity ac, List<Boardgame> boardgames){
        this.boardgameList = boardgames;
        this.ac = ac;
    }

    @Override
    public BoardGameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.boargame_item, parent, false);

        return new BoardGameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BoardGameViewHolder holder, int position) {
        final Boardgame game = boardgameList.get(position);

        holder.tvPlayers.setText(String.format("%s - %s",game.getMinPlayers(), game.getMaxPlayers()));
        holder.tvPlayTime.setText(String.format("%d",game.getPlayingTime()));
        holder.tvRating.setText(String.format("%.2f",game.getAverageRating()));
        holder.tvTitle.setText(game.getName());

        UIUtiles.setImage(ac.getBaseContext(),holder.ivThumbnail,UIUtiles.fixUrl(game.getThumbnail()));

    }

    @Override
    public int getItemCount() {
        return boardgameList.size();
    }
}
