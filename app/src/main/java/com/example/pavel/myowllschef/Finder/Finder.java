package com.example.pavel.myowllschef.Finder;

import com.example.pavel.myowllschef.*;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;


import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pavel.myowllschef.Finder.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import com.example.pavel.myowllschef.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pavel on 14.11.2018.
 */
public class Finder {
    StringBuilder line = new StringBuilder();
    StringBuilder linefor = new StringBuilder();
    int counter = 0;
    int counter2 = 0;
    boolean png =true;
    boolean pnh = false;
    ArrayList<String> userfodlist = new ArrayList<String>(); // список ингридиентов от пользователя
    private static ArrayList<String> ingrideents = new ArrayList<String>(); // список ингридиентов к найденным рецептам
    private static ArrayList<String> recepts = new ArrayList<String>(); // список найденых рецептов
    Context context;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<String> geter(){
        return ingrideents;
    }

    public ArrayList<String> getertwo(){
        return recepts;
    }



    public Finder(ArrayList<String> userfoodlist,Context context){
        this.context = context;
        this.userfodlist = userfoodlist;
        System.out.println("ПоПали в конструктор");
        try {
            getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void getText() {
        BufferedReader reader;
        AssetManager assetManager;
        InputStreamReader stream;
        try {
             assetManager = context.getAssets();
             stream = new InputStreamReader(assetManager.open("Receptss.txt"),"UTF-8");
             reader = new BufferedReader(stream);
              String liine;
            while ((liine= reader.readLine()) != null) {
                line.append(liine);
                compacer(line);
                line.delete(0,line.length());  // Очистка хранилища
            }
                reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(" Ошибка в чтении файла");
        } catch (NullPointerException r){
            r.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean cheker(StringBuilder line){
        Pattern pattern = Pattern.compile("/");
        Matcher matcher = pattern.matcher(line);
        if(matcher.find()){
            return true;
        }else {
            return false;
        }


    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void compacer (StringBuilder line2)  {
        if(png) { // для ингридиентов
            linefor.append(line2 + "  "); // Наполняем хранилище
            counter2++;
            if (cheker(line2)) {//Проверяет содержит ли строка /
                png =false;
                if(chekerforincluding(linefor)){ //если в этом рецепте содержаться ингридиенты от пользователя
                    ingrideents.add(counter,linefor.toString());// добавляет в список ингридиентов строку
                    pnh = true;
                }
                counter2 = 0;
                linefor.delete(0,linefor.length());  // Очистка хранилища
             }
        }else {  //для рецептов
            if(cheker(line2) == false){// Проверяет содержится ли строка с /
                if(pnh){
                    linefor.append(line2); //Наполняем хранилище
                }
            }else {// Строка с / содержится и :
                png = true;// Если она содержится то меняет реле
                if(pnh){
                    recepts.add(counter,linefor.toString()); // Добавляет в список рецептов рецептов содержание хранилища
                    counter++;
                    pnh = false;
                }
                linefor.delete(0,linefor.length());  // Очистка хранилища
            }
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean chekerforincluding(StringBuilder line3){
        counter2--;
        int i = counter2;
        for(String a : userfodlist){
            Pattern patternb = Pattern.compile(a);
            Matcher matcherb = patternb.matcher(line3);
            if(matcherb.find()){
                counter2--;
                }
         }
        if((counter2) <= (i * 30/100)){
            return true;

        }else {
            return false;
        }
    }
}




