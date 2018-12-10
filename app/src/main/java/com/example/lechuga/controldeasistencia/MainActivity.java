package com.example.lechuga.controldeasistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView asistenciaButton = (TextView)findViewById(R.id.AsistenciaButton);
        TextView registroButton = (TextView)findViewById(R.id.EliminarAsistenciaBtn);
        TextView desarrolladoresButton = (TextView)findViewById(R.id.DesarrolladoresButton);
        asistenciaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Calendario_Eventos.class);
                i.putExtra("Asistencia", 1);
                startActivity(i);
            }
        });
        registroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Calendario_Eventos.class);
                i.putExtra("Asistencia", 0);
                startActivity(i);
            }
        });
        desarrolladoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Desarrolladores.class);
                startActivity(i);
            }
        });
    }
}
