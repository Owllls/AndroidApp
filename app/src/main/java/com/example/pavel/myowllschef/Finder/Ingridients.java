package com.example.pavel.myowllschef.Finder;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.*;

/**
 * Created by pavel on 14.11.2018.
 */
public class Ingridients extends ArrayList implements Comparable<Ingridients> {
    private int appropriatyvity;

    private StringBuilder sumofall;

    public String getIngrideents(){
        return sumofall.toString();
    }


    public  Ingridients(String [] ar,int appropriatyvity) {
        super.addAll(Arrays.asList(ar));
        this.appropriatyvity = appropriatyvity;
        /*for(String a: ar){
            sumofall.append(a);
        }*/
    }
    public Ingridients(){}





    public int compareTo(Ingridients o) {

        if(this.appropriatyvity  > o.appropriatyvity ){
            return 1;
        }
        if(this.appropriatyvity == o.appropriatyvity){
            return 0;
        }
        if(this.appropriatyvity < o.appropriatyvity){
            return -1;
        }else {
            return 0;
        }

    }


}
