package com.example.dm2.examenrecu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAct1, btnAct2, btnAct3, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAct1=(Button)findViewById(R.id.Act1);
        btnAct2=(Button)findViewById(R.id.Act2);
        btnAct3=(Button)findViewById(R.id.Act3);
        btnSalir=(Button)findViewById(R.id.recuSalir);

        btnAct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, Actividad1.class);
                startActivity(intento);
            }
        });

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, Actividad2.class);
                startActivity(intento);
            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),R.string.toasty, Toast.LENGTH_SHORT).show();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
