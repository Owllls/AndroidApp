package com.example.pavel.myowllschef.Finder;



/**
 * Created by pavel on 04.12.2018.
 */

public class Recept extends Ingridients implements Comparable<Ingridients>{
    private String recept;

    public String getRecept(){
        return recept;
    }

    public Recept(String recept){
        this.recept = recept;

    }
}
