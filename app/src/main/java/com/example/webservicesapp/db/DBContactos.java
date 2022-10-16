package com.example.webservicesapp.db;

import android.content.Context;

import androidx.annotation.Nullable;

import com.example.webservicesapp.entidades.Contactos;

import java.util.ArrayList;

public class DBContactos{

    private ArrayList<Contactos> lista;

    public void escricirContactos(Contactos contacto){
        lista.add(contacto);
     }

    public ArrayList<Contactos> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Contactos> lista) {
        this.lista = lista;
    }
}
