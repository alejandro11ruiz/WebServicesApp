package com.example.webservicesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.webservicesapp.db.DBContactos;
import com.example.webservicesapp.entidades.Contactos;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buttonEnviar, buttonVer;
    static ArrayList<Contactos> listaContactos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnviar = findViewById(R.id.buttonEnviar);
        buttonVer = findViewById(R.id.buttonVer);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LeerWs();
            }
        });

        buttonVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( MainActivity.this, ListaActivity.class));
            }
        });
    }

    private void LeerWs(){
        for(int i = 1; i<83; i++) {
            String url = "https://www.datos.gov.co/resource/pkhg-bvje.json?no="+Integer.toString(i);
            StringRequest postRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        response = response.substring(1, response.length() - 1);
                        JSONObject jsonObject = new JSONObject(response);
                        Contactos contactos = new Contactos();
                        contactos.setProvincia(jsonObject.getString("provincia"));
                        contactos.setMunicipio(jsonObject.getString("municipio"));
                        contactos.setNombre(jsonObject.getString("nombre_de_la_biblioteca"));
                        contactos.setTelefono(jsonObject.getString("celular_de_contacto_del"));
                        contactos.setCorreo(jsonObject.getString("correo_electronico"));
                        contactos.setDireccion(jsonObject.getString("direcci_n_de_la_biblioteca"));
                        listaContactos.add(contactos);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("error", error.getMessage());
                }
            });
            Volley.newRequestQueue(this).add(postRequest);
        }
    }
}