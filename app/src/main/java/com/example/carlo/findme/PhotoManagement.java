package com.example.carlo.findme;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PhotoManagement extends AppCompatActivity {

    private static int countPlaces = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_management);

        Bitmap bitmap = (Bitmap) this.getIntent().getParcelableExtra("Bitmap");




        ImageView viewBitmap = (ImageView) findViewById(R.id.bitmapView);
        viewBitmap.setImageBitmap(bitmap);


        //quando si preme il tasto per salvare foto e tag :
        // - riempire l'oggetto con l'url della foto e i tag inseriti tirandoli fuori dai campi dell'activity
        // - aggiungere il posto ad un arrayList di posti,
        // - salvare la foto nella memoria
        // - incremento il countPlaces che tiene tyraccia dei posti inseriti e posso usarlo per rinominare ogni nuova foto

        //salvo la foto
        saveToInternalStorage(bitmap);
    }


    /*On activity result */

    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext()); // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        //File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

        // Create imageDir
        File mypath=new File(directory,"place" + countPlaces + ".jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }
}

