package com.example.dm2.examenrecu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actividad1b extends AppCompatActivity {

    String nombre,provincia,sexo,conocimientos;
    TextView lblCandNom, lblCandProv, lblCandSex, lblCandCono;
    Button btnAceptar, btnRechazar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1b);

        btnAceptar=(Button)findViewById(R.id.btnAceptar);
        btnRechazar=(Button)findViewById(R.id.btnRechazar);

        lblCandNom=(TextView)findViewById(R.id.candNombre);
        lblCandProv=(TextView)findViewById(R.id.candProvincia);
        lblCandSex=(TextView)findViewById(R.id.candSexo);
        lblCandCono=(TextView)findViewById(R.id.candConocimientos);

        Bundle bundle = getIntent().getExtras();
        nombre= bundle.getString("Nombre");
        provincia=bundle.getString("Provincia");
        sexo=bundle.getString("Sexo");
        conocimientos=bundle.getString("Conocimientos");

        lblCandNom.append(nombre);
        lblCandProv.append(provincia);
        lblCandSex.append(sexo);
        lblCandCono.append(conocimientos);

        final Intent intento = new Intent(Actividad1b.this, Actividad1.class);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK,intento);
                finish();
            }
        });

        btnRechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED,intento);
                finish();
            }
        });
    }
}
