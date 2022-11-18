package com.example.mascotasfavoritas2.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mascotasfavoritas2.R;
import com.example.mascotasfavoritas2.pojo.Perritu;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.perfilViewHolder>{
    ArrayList<Perritu> Perritus;
    Activity actividad;
    public PerfilAdaptador(ArrayList<Perritu>perritus, Activity actividad ){
        this.Perritus=perritus;
        this.actividad=actividad;
    }
    @NonNull
    @Override
    public PerfilAdaptador.perfilViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.perfil_layaout,viewGroup,false);
        return new PerfilAdaptador.perfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilAdaptador.perfilViewHolder perfilViewHolder, int position) {
        final Perritu perritos = Perritus.get(position);
        perfilViewHolder.imgFoto.setImageResource(perritos.getFoto());
        perfilViewHolder.tvLikes.setText(perritos.getLikes());
    }


    @Override
    public int getItemCount() {
        return Perritus.size();
    }

    public static class perfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvLikes;

        public perfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imagenPerrituPerfil);
            tvLikes = (TextView) itemView.findViewById(R.id.textViewLikesPerfil);
        }
    }
}
