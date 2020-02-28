package com.example.pavel.myowllschef.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pavel.myowllschef.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Addapter extends BaseAdapter {

    private ArrayList<String>list;
    private LayoutInflater layoutInflater;

public Addapter(Context context, ArrayList<String> list){
    this.list = list;
    layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);


}
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     View view = convertView;
      if(view == null){
          view = layoutInflater.inflate(R.layout.recy,parent,false);

      }
        TextView textofrecept = (TextView) view.findViewById(R.id.textofrecept);
        textofrecept.setText(list.get(position));
        return view;
    }
}
