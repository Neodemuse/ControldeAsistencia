package com.example.lechuga.controldeasistencia;

import android.content.Intent;
import android.opengl.Visibility;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Asistencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistencia);

        TextView folioButton = (TextView)findViewById(R.id.folioButton);
        final EditText folioEdit = (EditText)findViewById(R.id.folioEdit);
        folioEdit.setVisibility(View.GONE);
        final Button folioConfirmar = (Button)findViewById(R.id.confirmarFolioButton);
        folioConfirmar.setVisibility(View.GONE);

        folioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(folioEdit.getVisibility()==View.GONE){
                    folioEdit.setVisibility(View.VISIBLE);
                    folioConfirmar.setVisibility(View.VISIBLE);
                }
                else{
                    folioEdit.setVisibility(View.GONE);
                    folioConfirmar.setVisibility(View.GONE);
                }
            }
        });

        folioConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsistenciaBD obj = new AsistenciaBD();
                String folio = folioEdit.getText().toString();
                String mensaje = obj.EnviarPost(folio);
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
