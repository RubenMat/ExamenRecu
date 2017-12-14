package com.example.dm2.examenrecu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad1 extends AppCompatActivity {

    String nombre, provincia, conocimientos="",sexo;

    int numCand=0;

    RadioGroup rbGrupo;
    TextView lblCandidatos;
    EditText txtNombre;
    Spinner spinProv;
    RadioButton rbMasc, rbFem;
    CheckBox chkPHP, chkJAVA, chkHTML, chkCSS;
    Button btnEvaluar, btnSalir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        rbGrupo=(RadioGroup)findViewById(R.id.rbGrupo);

        lblCandidatos=(TextView)findViewById(R.id.lblCandidatos);

        txtNombre=(EditText)findViewById(R.id.txtNombre);

        spinProv =(Spinner)findViewById(R.id.spinProvincias);

        rbMasc=(RadioButton)findViewById(R.id.rbMasc);
        rbFem=(RadioButton)findViewById(R.id.rbFem);

        chkPHP=(CheckBox)findViewById(R.id.chkPHP);
        chkJAVA=(CheckBox)findViewById(R.id.chkJAVA);
        chkHTML=(CheckBox)findViewById(R.id.chkHTML);
        chkCSS=(CheckBox)findViewById(R.id.chkCSS);

        btnEvaluar=(Button)findViewById(R.id.btnEvaluar);
        btnSalir=(Button)findViewById(R.id.btnSalir);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,
                R.array.spinProv, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinProv.setAdapter(adaptador);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnEvaluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNombre.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Introduce un nombre", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    nombre=txtNombre.getText().toString();
                }

                provincia=spinProv.getSelectedItem().toString();

                if(rbMasc.isChecked()){
                    sexo="Masculino";
                } else if(rbFem.isChecked()){
                    sexo="Femenino";
                } else{
                    Toast.makeText(getApplicationContext(),"Selecciona sexo", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(chkPHP.isChecked()){
                    conocimientos+="PHP";
                }
                if(chkJAVA.isChecked()){
                    if(!conocimientos.equalsIgnoreCase(""))
                        conocimientos+=",";
                    conocimientos+="JAVA";
                }
                if(chkHTML.isChecked()){
                    if(!conocimientos.equalsIgnoreCase(""))
                        conocimientos+=",";
                    conocimientos+="HTML";
                }
                if(chkCSS.isChecked()){
                    if(!conocimientos.equalsIgnoreCase(""))
                        conocimientos+=",";
                    conocimientos+="CSS";
                }

                Intent intento = new Intent(Actividad1.this, Actividad1b.class);
                intento.putExtra("Nombre", nombre);
                intento.putExtra("Provincia", provincia);
                intento.putExtra("Sexo",sexo);
                intento.putExtra("Conocimientos",conocimientos);
                startActivityForResult(intento,1);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if(requestCode==1 && resultCode==RESULT_OK){
            numCand++;
            lblCandidatos.setText("Candidatos: " + numCand);
        }
        rbGrupo.clearCheck();
        conocimientos="";
        txtNombre.setText("");
        rbMasc.setChecked(false);
        rbFem.setChecked(false);
        spinProv.setSelection(0);
        chkPHP.setChecked(false);
        chkJAVA.setChecked(false);
        chkHTML.setChecked(false);
        chkCSS.setChecked(false);

        if(numCand==4){
            btnEvaluar.setVisibility(View.INVISIBLE);
            btnSalir.setVisibility(View.VISIBLE);
        }
    }
}
