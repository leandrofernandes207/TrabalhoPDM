package com.example.trabalhopdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ListaActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        View view;
        setContentView(R.layout.activity_lista);
        Intent intent = getIntent();
        String[] cores = intent.getStringArrayExtra("cores");
        ListView lista = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ListaAdaptador(this,android.R.layout.simple_list_item_1, Arrays.asList(cores));
        lista.setAdapter(adapter);
    }
    private class ListaAdaptador extends ArrayAdapter {

        public ListaAdaptador(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view =  super.getView(position, convertView, parent);
            TextView txt = (TextView) view;
            Intent intent = getIntent();
            String[] cores = intent.getStringArrayExtra("cores");
            //seta o texto com a mesma cor do fundo
            txt.setTextColor(Color.parseColor(cores[position].toString()));
            //seta cada linha com a cor correspondente do array
            view.setBackgroundColor(Color.parseColor(cores[position].toString()));
            return view;
        }
    }

}
