package com.example.toon.boardgamerandomizer.Views.UIUtiles;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by Toon on 24/01/2017.
 */

public class UIUtiles {
    public static void setImage(Context context, ImageView imageView, String url){
        Picasso.with(context).load(url).noFade().into(imageView);
    }

    public static void makeToast(Context context, int stringID, int duration){
        Toast t = Toast.makeText(context,stringID, duration);
        t.show();
    }

    public static String fixUrl(String thumb){
        return "https://" + thumb.substring(2);
    }
}
