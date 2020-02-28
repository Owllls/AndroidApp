package com.example.pavel.myowllschef;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static com.example.pavel.myowllschef.R.id.RadioB1;
import static com.example.pavel.myowllschef.R.id.RadioB2;
import static com.example.pavel.myowllschef.R.id.radioGroupsettings;

public class MainActivity extends AppCompatActivity {
    boolean a = false;
    boolean b = false;
    ConstraintLayout layout;
    Drawable image1;
    Drawable image2;
    Drawable image3;
    Drawable image4;
    Drawable image5;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // layout.setBackgroundColor(getResources().getColor(R.color.blue));
        layout = (ConstraintLayout) findViewById(R.id.bck) ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         final Intent answerInttent = new Intent(MainActivity.this,findactivity.class);
         final Intent answerInntent = new Intent(MainActivity.this,findactivititwo.class);

         final String film = "FILM";
         final Button buttonupper = (Button) findViewById(R.id.buttonupper);
         RadioGroup radioGroup = (RadioGroup) findViewById(radioGroupsettings);
         RadioButton radioButton1 = (RadioButton) findViewById(RadioB1);
         RadioButton radioButton2 = (RadioButton) findViewById(RadioB2);
          final String chose = "Выбор ";
          setImmages();
          setBackkgr();

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){

                switch (checkedId){
                    case R.id.RadioB1:
                        a = true;
                        startActivity(answerInttent);
                        break;
                    case R.id.RadioB2:
                        b = true;
                        startActivity(answerInntent);
                        break;
                    default:
                        break;
                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                buttonupper.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            if ( a == true || b == false) {
                                startActivity(answerInttent);
                            }
                             if (b == true || a == false) {
                                startActivity(answerInntent);
                             } }catch (Exception ex){
                            ex.printStackTrace();
                        }


                    }

                });
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
    private void setBackkgr(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {


                handler.postDelayed(this, 5000);
            }
        });
    }
}
