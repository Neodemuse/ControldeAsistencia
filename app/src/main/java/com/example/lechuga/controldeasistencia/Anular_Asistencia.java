package com.example.lechuga.controldeasistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Anular_Asistencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anular_asistencia);
        TextView alumnoButton = (TextView)findViewById(R.id.anularAsistenciaText);
        final EditText alumnoEdit = (EditText)findViewById(R.id.numeroCuentaEdit);
        final Button alumnoRgistrar = (Button)findViewById(R.id.anularAsistenciaBtn);
        alumnoEdit.setVisibility(View.GONE);
        alumnoRgistrar.setVisibility(View.GONE);
        alumnoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(alumnoEdit.getVisibility()==View.GONE){
                    alumnoEdit.setVisibility(View.VISIBLE);
                    alumnoRgistrar.setVisibility(View.VISIBLE);
                }
                else {
                    alumnoEdit.setVisibility(View.GONE);
                    alumnoRgistrar.setVisibility(View.GONE);
                }
            }
        });
    }
}
