package com.example.dm2.examenrecu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Actividad2 extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        ArrayList<Localidad> arrayLocalidades = new ArrayList<Localidad>();
        Localidad localidad;

        localidad = new Localidad("Añana", 157, 21.92f,  ContextCompat.getDrawable(this, R.drawable.aniana_salinas_2),"http://www.cuadrilladeanana.es/anana/");
        arrayLocalidades.add(localidad);
        localidad = new Localidad("Mundaka", 1892, 4.01f,  ContextCompat.getDrawable(this, R.drawable.mundaka),"http://www.mundaka.org");
        arrayLocalidades.add(localidad);
        localidad = new Localidad("Gernika-Lumo", 16763, 8.60f,  ContextCompat.getDrawable(this, R.drawable.gernika2),"http://www.gernika-lumo.net");
        arrayLocalidades.add(localidad);
        localidad = new Localidad("Laguardia", 1520, 81.08f,  ContextCompat.getDrawable(this, R.drawable.laguardia),"http://www.laguardia-alava.net/");
        arrayLocalidades.add(localidad);
        localidad = new Localidad("Vitoria-Gasteiz", 243918, 276.08f,  ContextCompat.getDrawable(this, R.drawable.vitoria_gasteiz),"http://www.vitoria-gasteiz.org/");
        arrayLocalidades.add(localidad);

        lista=(ListView)findViewById(R.id.listaProv);
        AdaptadorLoc adaptador = new AdaptadorLoc(this,arrayLocalidades);
        lista.setAdapter(adaptador);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = ((Localidad)parent.getItemAtPosition(position)).getUrl();
                System.out.print(url);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

    public class Localidad {

        Drawable imagen;
        int poblacion;
        float superficie;
        String nombre, url;

        public Localidad(String nombre, int poblacion, float superficie, Drawable imagen, String url){
            this.nombre=nombre;
            this.poblacion=poblacion;
            this.superficie=superficie;
            this.url=url;
            this.imagen=imagen;
        }

        public String getUrl() {
            return url;
        }

        public Drawable getImagen() {
            return imagen;
        }

        public String getNombre() {
            return nombre;
        }

        public int getPoblacion() {
            return poblacion;
        }

        public float getSuperficie() {
            return superficie;
        }
    }

    class AdaptadorLoc extends ArrayAdapter<Localidad> {
        public AdaptadorLoc(Context context, ArrayList<Localidad> datos) {
            super(context, R.layout.listaprovincias, datos);
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listaprovincias, null);

            TextView lblNombre= (TextView) item.findViewById(R.id.provNom);
            lblNombre.setText(getItem(position).getNombre());
            ImageView imagen =(ImageView)item.findViewById(R.id.provImg);
            imagen.setImageDrawable(getItem(position).getImagen());
            TextView lblPoblacion = (TextView)item.findViewById(R.id.provPoblacion);
            lblPoblacion.setText(getItem(position).getPoblacion() + " hab (2015)");
            TextView lblSuperficie=(TextView)item.findViewById(R.id.provSup);
            lblSuperficie.setText(getItem(position).getSuperficie()+" Km2 / ");
            TextView lblURL=(TextView)item.findViewById(R.id.provURL);
            lblURL.setText(getItem(position).getUrl());
            return (item);
        }
    }
}
