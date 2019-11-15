package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class Ejercicio_2_act_2 extends AppCompatActivity {

    private EditText In;
    private TextView tv1;
    private int counter = 0;
    private int limit = 0;
    private int[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_2_act_2);
        In = findViewById(R.id.Input);
        tv1 = findViewById(R.id.Texto2);

        String size = getIntent().getStringExtra("Tamaño");

        String message ="Ingrese los "+size+" numeros";

        limit = Integer.parseInt(size);
        list = new int[limit];
        Toast.makeText(this,"Tamaño: "+limit,Toast.LENGTH_SHORT).show();

        tv1.setText(message);
    }

    public int[] Mergesort(int[] _Array){
        if (_Array.length <= 1){
            return _Array;
        }
        int midpoint = _Array.length/2;
        int[] left = new int[midpoint];
        int[] right;
        if (_Array.length%2 == 0){
            right = new int[midpoint];
        }
        else {
            right = new int[midpoint + 1];
        }
        for (int i = 0; i < midpoint; i++){
            left[i] = _Array[i];
        }
        for(int j = 0; j < right.length; j++){
            right[j] = _Array[midpoint+j];
        }
        int[] result = new int[_Array.length];
        left = Mergesort(left);
        right = Mergesort(right);
        result = merge(left,right);

        return result;
    }

    public int[] merge(int[] _left, int[] _right) {
        int[] result = new int[_left.length + _right.length];
        int leftpointer, rightpointer, resultpointer;
        leftpointer = rightpointer = resultpointer = 0;

        while (leftpointer < _left.length || rightpointer < _right.length) {
            if (leftpointer < _left.length && rightpointer < _right.length) {
                if (_left[leftpointer] < _right[rightpointer]) {
                    result[resultpointer++] = _left[leftpointer++];
                } else {
                    result[resultpointer++] = _right[rightpointer++];
                }

            } else if (leftpointer < _left.length) {
                result[resultpointer++] = _left[leftpointer++];
            } else if (rightpointer < _right.length) {
                result[resultpointer++] = _right[rightpointer++];
            }
        }

        return result;
    }

    public void Add(View view){
        if (In.getText().toString().length() != 0){
            int Input = Integer.parseInt(In.getText().toString());
            list[counter] = Input;
            counter = counter + 1;
            int restante = limit - counter;
            Toast.makeText(this,"Faltan "+restante+" digitos más",Toast.LENGTH_SHORT).show();
            if (counter == limit){
                Toast.makeText(this,"Completado!",Toast.LENGTH_LONG).show();
                counter = 0;
                list = Mergesort(list);
                Intent end = new Intent(this,Ejercicio_2_act_3.class);
                end.putExtra("Arreglo",list);
                startActivity(end);
            }
        }
        else {
            Toast.makeText(getApplicationContext(),"Inserte digito porfavor",Toast.LENGTH_LONG).show();
        }


    }

    public void Clear(View view){
        Arrays.fill(list,0);
        Toast.makeText(getApplicationContext(),"Todos los datos borrados con exito",Toast.LENGTH_LONG).show();
        counter = 0;
    }

}

