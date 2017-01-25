package com.example.carlo.findme;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by carlo on 24/01/17.
 */

public class Posto implements Serializable {

    private int id;
    private String path;
    private ArrayList<String> imageTags;

    public Posto(String path){
        this.path = path ;
        this.imageTags = new ArrayList<>(); //Inizializzo l'array di tag
    }

    public void setTag (String tag){
        imageTags.add(tag);
    }

}
