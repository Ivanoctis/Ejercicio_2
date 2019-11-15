package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText _size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _size = findViewById(R.id.size);
    }

    public void Start(View view){
        String size = _size.getText().toString();
        if (size.length()!=0 && Integer.parseInt(size) > 0){
            Intent next = new Intent(this,Ejercicio_2_act_2.class);
            next.putExtra("Tamaño", size);
            startActivity(next);
        }
        else {
            Toast.makeText(this,"Error en el tamaño, repita porfavor",Toast.LENGTH_SHORT).show();
        }
    }
}
