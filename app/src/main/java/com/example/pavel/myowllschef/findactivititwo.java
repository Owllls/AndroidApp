package com.example.pavel.myowllschef;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pavel.myowllschef.Finder.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;



public class findactivititwo extends AppCompatActivity {
    Button adbutton;
    Button delbutton;
    Button startbutton;
    EditText resline;
    EditText  wedthline;
    ArrayList<String> foodlist = new ArrayList<String>();
    Context context;
    View view;
    LinearLayout layout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findactivititwo);
        adbutton = (Button) findViewById(R.id.button2);
        delbutton = (Button) findViewById(R.id.button2);
        startbutton = (Button) findViewById(R.id.button2);
        resline = (EditText) findViewById(R.id.editText3);
        wedthline = (EditText) findViewById(R.id.editText2);
        view = findViewById(R.id._linerlayoutfinal);
        layout = (LinearLayout)findViewById(R.id._fndact);
        layout.setBackgroundResource(R.drawable.i8);


    }




    public void Start(View view) throws Exception {
         Intent intent = new Intent(findactivititwo.this, FinalActivity.class);
          context = getApplicationContext();
         if (foodlist.isEmpty() != true) {
            makeRecepts res = new makeRecepts(foodlist,context);
            for(int j =0; j < res.getreslist().size(); j ++){
                intent.putExtra("numberodposition",res.getreslist().size());
                intent.putExtra(String.valueOf(j) ,res.getreslist().get(j).getRecept());
               }

               startActivity(intent);

        }


    }

    public InputStream file() throws Exception{

        AssetManager assetManager = context.getAssets();
        return  assetManager.open("Receptss.txt");
    }

    public void addtolist(View view) {
        if(!resline.getText().equals(null)) {
            foodlist.add(resline.getText().toString());
            resline.setText("");
            wedthline.setText("");
        }else {
            resline.setText("Вы ничего не ввели");
        }

    }

    public void clean(View view) {
        resline.setText("");
        wedthline.setText("");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(file()));
            if(reader.readLine() != null){
                System.out.print(reader.readLine());
                wedthline.setText(reader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       /* try {
            AssetManager assetManager = this.getAssets();
            InputStream stream = assetManager.open("Recepts.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            if(reader.readLine() != null){
                System.out.print(reader.readLine());
                wedthline.setText(reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("NIHUYA");
        } catch (NullPointerException r){
            r.printStackTrace();
            System.out.print("Toze NIHUYA");
        }*/

         System.out.print("11111111111111");
    }
}
