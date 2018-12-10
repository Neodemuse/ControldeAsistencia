package com.example.lechuga.controldeasistencia;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

public class AsistenciaBD {

    public String EnviarPost(String folio) {

        StrictMode.ThreadPolicy p = new StrictMode.ThreadPolicy.Builder().permitAll().build(); StrictMode.setThreadPolicy(p);

        String URL_RUTA = "http://192.168.43.33/prueba/wsprueba.php";

        String name = "";

        URL url = createUrl(URL_RUTA);

        try {
            String parametros = "folio=" + folio;

            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
           // conexion.setConnectTimeout(15 * 1000 /*Milisegundos*/);
            //conexion.setReadTimeout(10 * 1000 /*Milisegundos*/);
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Length", "" + Integer.toString(parametros.getBytes().length));
            conexion.setDoOutput(true);
            conexion.setRequestProperty( "charset", "utf-8");
            conexion.connect();

            OutputStream os = conexion.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(parametros);
            writer.flush();
            writer.close();
            os.close();

            return "Logrado";
        } catch (Exception e) {

        }
        return "Falla";
    }


    private URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException exception) {

            return null;
        }
        return url;
    }
}


