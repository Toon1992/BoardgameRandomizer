package com.example.toon.boardgamerandomizer.Views.UIUtiles;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Toon on 24/01/2017.
 */

public class PhotoReader {
    public static void setImage(Context context, ImageView imageView, String url){
        Picasso.with(context).load(url).noFade().into(imageView);
    }
}
