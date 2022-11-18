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

import com.example.mascotasfavoritas2.BaseDatos.ConstructorPerritos;
import com.example.mascotasfavoritas2.pojo.Perritu;
import com.example.mascotasfavoritas2.R;

import java.util.ArrayList;

public class PerritusAdaptador extends RecyclerView.Adapter<PerritusAdaptador.perrituViewHolder>{
    ArrayList <Perritu> Perritus;
    Activity actividad;
    public PerritusAdaptador(ArrayList<Perritu>perritus, Activity actividad ){
        this.Perritus=perritus;
        this.actividad=actividad;
    }
    @NonNull
    @Override
    public perrituViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view,viewGroup,false);
        return new perrituViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final perrituViewHolder perrituViewHolder, int position) {
        final Perritu perritos = Perritus.get(position);
        perrituViewHolder.imgFoto.setImageResource(perritos.getFoto());
        perrituViewHolder.tvLikes.setText(String.valueOf(perritos.getLikes()));
        perrituViewHolder.tvNombrePerritu.setText(perritos.getNombre());

        perrituViewHolder.imgBtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //perritos.setLikes(perritos.getLikesInt()+1);
                Toast.makeText(actividad,perritos.getLikes(),Toast.LENGTH_SHORT).show();

                ConstructorPerritos constructorPerritos =new ConstructorPerritos(actividad);
                constructorPerritos.insertarPerro(perritos);
                //perrituViewHolder.tvLikes.setText(constructorPerritos.obtnerLikesPerrito(perritos));
            }
        });
    }

    @Override
    public int getItemCount() {
        return Perritus.size();
    }

    public static class perrituViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombrePerritu;
        private TextView tvLikes;
        private ImageButton imgBtnLike;

        public perrituViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imagenPerritu);
            tvLikes = (TextView) itemView.findViewById(R.id.textViewLikes);
            tvNombrePerritu = (TextView) itemView.findViewById(R.id.textViewNombre);
            imgBtnLike = (ImageButton) itemView.findViewById(R.id.HuesoLike);
        }
    }
}
