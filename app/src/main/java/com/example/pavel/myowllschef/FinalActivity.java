package com.example.pavel.myowllschef;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pavel.myowllschef.Adapters.Addapter;
import com.example.pavel.myowllschef.Finder.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.pavel.myowllschef.R.color.red;

/**
 * Created by pavel on 04.12.2018.
 */

public class FinalActivity extends AppCompatActivity {
    String [] mass;
    int counter =0;
    LinearLayout layout;

    Drawable image1;
    Drawable image2;
    Drawable image3;
    Drawable image4;
    Drawable image5;


     @Override
       protected void onCreate(Bundle savedInstanceState) {
      //   layout.setBackgroundColor(getResources().getColor(red));
         ArrayList<String>food = new ArrayList<String>();
         ArrayList<String>ffirstletters = new ArrayList<String>();

         Bundle argument = getIntent().getExtras();
         super.onCreate(savedInstanceState);
         setContentView(R.layout.finalactivity);
         int numberofres;

         if(argument != null) {
             numberofres = (Integer) argument.get("numberodposition");
              if (numberofres > 0) {
                 for (int i = 0; i <= numberofres; i++) {
                   food.add((String) argument.get(String.valueOf(i)));
               //    ffirstletters.add(Cutter((String) argument.get(String.valueOf(i))));
                 }
              }
           }


         ListView listView = (ListView) findViewById(R.id.listfinal);
         Addapter adapter = new Addapter(this,food);
         listView.setAdapter(adapter);
          setImmages();
          setBackkgr();

       }



    private void setBackkgr(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {


                handler.postDelayed(this, 5000);
            }
        });
    }
       private void setImmages(){
           image1 = getDrawable(R.drawable.i1);
           image2 = getDrawable(R.drawable.i5);
           image3 = getDrawable(R.drawable.i6);
           image4 = getDrawable(R.drawable.i3);
           image5 = getDrawable(R.drawable.i10);
       }

       private Drawable setImgbck(){
            layout = (LinearLayout) findViewById(R.id._linerlayoutfinal) ;
            int random_number1 = (int) (Math.random() * 5);


            switch (random_number1){
                case 1:
                    return image1;

                case 2:
                    return image2;

                case 3:
                    return image3;

                case 4:
                    return image4;

                case 5:
                    return image5;

                default:
                    return image1;

                 }

            }





    /*   private String Cutter(String a){
           Pattern pattern = Pattern.compile("[A-Za-z0-9]{0,15}");
           Matcher matcher = pattern.matcher(a);
           System.out.print(matcher.group());

           return matcher.group();


       }*/



}