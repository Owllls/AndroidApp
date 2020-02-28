package com.example.pavel.myowllschef.Finder;

/**
 * Created by pavel on 04.12.2018.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pavel on 19.11.2018.
 */
public class IngCuter {

    private ArrayList<String> list = new ArrayList<String>();
    public StringBuilder userfood = new StringBuilder();
    private ArrayList<Ingridients> ingridientslist = new ArrayList<Ingridients>();
    private ArrayList<Recept> receptslist = new ArrayList<Recept>();
    ArrayList<String> recepts = new ArrayList<String>(); // списку присваивается рецепты - готовые из класса фаиндер

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Ingridients> inter(){
        return ingridientslist;

    }
    public ArrayList<Recept> intertwo(){
        return receptslist;

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public IngCuter(ArrayList<String> userfoodlist, ArrayList<String> list,ArrayList<String> recepts){
        this.list.addAll(list);
        this.recepts.addAll(recepts);
        for(int i =0; i < userfoodlist.size(); i++){
            userfood.append(userfoodlist.get(i) + " ");
        }
        Cuter();
        receptssort();
        Collections.sort(ingridientslist);
        Collections.sort(receptslist);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void receptssort(){
       /*
        Этот метод сортирует рецепты. Он сначала создает список "Лол" в который закидывает из Объекта класса фаиндер все рецепты
        потом он заполняет список с экземплярами данного класса
         */
          for(String a : recepts){
            receptslist.add(new Recept(a));
        }

    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void Cuter(){
        /*       Один из саммых проблемных медотов. Берет список,который мы получили при создании объекта
         *       и перебирает его - каждая позиция из списка - это перечисление ингридиентов через два пробела
         *       каждую позицию он делит на эти пробелы и присваивает массиву. Выходит каждая ячейка массива
         *       это ингридиент. Потом он создает объекты классов "Ingridients" и в каждый передает этот массив.
         *       При создании объектов он должен передать туда число, которое обозначает - (сколько ингридиентов из рецепта есть у пользователя)
         *
         */
        //Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я]{1,}");

        for (int i = 0; i<list.size();i++){
            String [] mass =  list.get(i).split(" {2}");
            ingridientslist.add(new Ingridients(mass, includeornot(mass)));
        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int includeornot(String[]mas){
         /*Сделвть так, чтобы это работало в процентах
         * Считает сколько ингридиетов из рецепта есть у пользователя
         * возвращает ответ, целочисловоготипа
         */
        int count=0;
        for(String a: mas) {
            Pattern pattern1 = Pattern.compile(a);
            Matcher matcher1 = pattern1.matcher(userfood);
            if(matcher1.find()){
                count++;
            }
        }
        return count;
    }
}
