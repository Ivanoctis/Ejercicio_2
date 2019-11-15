package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Ejercicio_2_act_3 extends AppCompatActivity {

    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_2_act_3);

        lv1 = findViewById(R.id.listview);


        Bundle extras = getIntent().getExtras();
        int[] Array = extras.getIntArray("Arreglo");
        Integer[] Arreglo = new Integer[Array.length];
        int i = 0;
        for (int value:Array){
            Arreglo[i++] = value;
        }
        ArrayAdapter <Integer> adapter = new ArrayAdapter<>(this,R.layout.list_item_act3,Arreglo);
        lv1.setAdapter(adapter);
    }

    public void getback(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}
