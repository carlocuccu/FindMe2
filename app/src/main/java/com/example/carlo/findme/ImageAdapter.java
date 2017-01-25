package com.example.carlo.findme;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by carlo on 23/01/17.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {

        mContext = c;

    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(320, 320));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 2, 2); //sinistra, sopra, destra, sotto
        } else {
            imageView = (ImageView) convertView;
        }

        //imageView.setImageResource(mThumbIds[position]);
        imageView.setImageBitmap(loadImageFromStorage("/data/user/0/com.example.carlo.findme/app_imageDir/"));

        return imageView;
    }

//Invalidate

    // references to our images //POSSO PRENDERE I RIFERIMENTI DALLE RIGHE DI UN FILE RIEMPIENDO L'ARRAY AD OGNI LETTURA
    //usare una struttura dati dinamica in cui oltre a queste immagini posso aggiungere le nuove immagini scattate
    private Integer[] mThumbIds = {
            R.drawable.image_1_tn,
            R.drawable.image_2_tn,
            R.drawable.image_3_tn,
            R.drawable.image_4_tn,
            R.drawable.image_5_tn,
            R.drawable.image_6_tn,
            R.drawable.image_7_tn,
            R.drawable.image_8_tn,
            R.drawable.image_1_tn,
            R.drawable.image_2_tn,
            R.drawable.image_3_tn,
            R.drawable.image_4_tn
    };

    private Bitmap loadImageFromStorage(String path)
    {
        Bitmap b=null;
        try {
            File f=new File(path, "profile.jpg");
            b = BitmapFactory.decodeStream(new FileInputStream(f));


        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return b;
    }

    //Creare automaticamente un arryList di stringhe
}