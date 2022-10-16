package com.example.webservicesapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webservicesapp.R;
import com.example.webservicesapp.entidades.Contactos;

import java.util.ArrayList;

public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContactoViewHolder> {

    ArrayList<Contactos> listaContactos;

    public ListaContactosAdapter(ArrayList<Contactos> listaContactos){
        this.listaContactos=listaContactos;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_contacto, null, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        holder.viewNombre.setText(listaContactos.get(position).getNombre());
        holder.viewProvincia.setText(listaContactos.get(position).getProvincia());
        holder.viewMunicipio.setText(listaContactos.get(position).getMunicipio());
        holder.viewTelefono.setText(listaContactos.get(position).getTelefono());
        holder.viewCorreo.setText(listaContactos.get(position).getCorreo());
        holder.viewDireccion.setText(listaContactos.get(position).getDireccion());
    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre,viewProvincia,viewMunicipio,viewTelefono,viewCorreo,viewDireccion;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre=itemView.findViewById(R.id.viewNombre);
            viewProvincia=itemView.findViewById(R.id.viewProvincia);
            viewMunicipio=itemView.findViewById(R.id.viewMunicipio);
            viewTelefono=itemView.findViewById(R.id.viewTelefono);
            viewCorreo=itemView.findViewById(R.id.viewCorreo);
            viewDireccion=itemView.findViewById(R.id.viewDireccion);
        }
    }
}
