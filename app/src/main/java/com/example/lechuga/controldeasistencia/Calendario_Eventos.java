package com.example.lechuga.controldeasistencia;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.sql.Time;
import java.util.ArrayList;

public class Calendario_Eventos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__eventos);
        final int Asistencia = (int)getIntent().getExtras().getSerializable("Asistencia");
        final ArrayList<Evento> conferencias = new ArrayList<Evento>();

        conferencias.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        conferencias.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        conferencias.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        conferencias.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        conferencias.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        conferencias.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        conferencias.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        conferencias.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        conferencias.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        conferencias.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        conferencias.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));

        AdaptadorEvento adaptadorEvento = new AdaptadorEvento(this, conferencias);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adaptadorEvento);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Evento conferencia = conferencias.get(position);
                Intent i;
                if(Asistencia==1){
                    i = new Intent(Calendario_Eventos.this, Asistencia.class);
                }
                else{
                    i = new Intent(Calendario_Eventos.this, Anular_Asistencia.class);
                }
                startActivity(i);
            }
        });

    }
}
