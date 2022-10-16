package com.example.webservicesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.webservicesapp.adapters.ListaContactosAdapter;
import com.example.webservicesapp.db.DBContactos;
import com.example.webservicesapp.entidades.Contactos;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    RecyclerView listaContactos;
    ArrayList<Contactos> listaArrayContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listaContactos=findViewById(R.id.listaContactos);

        listaContactos.setLayoutManager(new LinearLayoutManager(this));

        listaArrayContactos = MainActivity.listaContactos;
        ListaContactosAdapter adapter = new ListaContactosAdapter(listaArrayContactos);
        listaContactos.setAdapter(adapter);
    }
}