package com.example.pavel.myowllschef.Finder;

import android.content.Context;

import java.util.ArrayList;


 import java.util.ArrayList;

 /**
 * Created by pavel on 14.11.2018.
 */
public class makeRecepts {

     private ArrayList<String> trylisr = new ArrayList<String>();

     ArrayList<String> ufl;
     Finder result;
     IngCuter ing;


     private void start() {  //вымышленный метод который набивает вымышленный список
         ing = new IngCuter(ufl, result.geter(),result.getertwo());
     }

     ///////////////////////////////////////////////////////////////////////////////////////////////////////////
     public ArrayList<Ingridients> getfoodlist() {
         return ing.inter();
     }

     public ArrayList<Recept> getreslist() {
         return ing.intertwo();
     }


     ////////////////////////////////////////////////////////////////////////////////////////////////////////////
     public makeRecepts(ArrayList<String> userfoodlist, Context context) throws Exception {
        /*
    Тут запускается конструктор класса, экземпляр класса при создании получает список пищи от пользователя(ингридиентов) и создает один поисковик,
     которому он передает список, если список не пустой. Дальше конструктор запускает метод старт который проверяет все остальное
      */
         if (userfoodlist.isEmpty() != true) {
             ufl = userfoodlist;
             result = new Finder(ufl, context);
             start();
         } else {
             throw new Exception(" List of your Inridients is empty, i so sorry, i cann`t to help ");
         }


     }
 }





