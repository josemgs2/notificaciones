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
import com.example.mascotasfavoritas2.R;
import com.example.mascotasfavoritas2.pojo.Perritu;

import java.util.ArrayList;

public class PerritoAdaptadorBasico  extends RecyclerView.Adapter<PerritoAdaptadorBasico.perritoViewHolder>{

    ArrayList<Perritu> Perritus;
    Activity actividad;
    public PerritoAdaptadorBasico(ArrayList<Perritu>perritus, Activity actividad ){
        this.Perritus=perritus;
        this.actividad=actividad;
    }
    @NonNull
    @Override
    public PerritoAdaptadorBasico.perritoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view,viewGroup,false);
        return new PerritoAdaptadorBasico.perritoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PerritoAdaptadorBasico.perritoViewHolder perritoViewHolder, int position) {
        final Perritu perritos = Perritus.get(position);
        perritoViewHolder.imgFoto.setImageResource(perritos.getFoto());
        perritoViewHolder.tvLikes.setText(String.valueOf(perritos.getLikes()));
        perritoViewHolder.tvNombrePerritu.setText(perritos.getNombre());

        perritoViewHolder.imgBtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perritos.setLikes(perritos.getLikesInt()+1);
                Toast.makeText(actividad,perritos.getLikes(),Toast.LENGTH_SHORT).show();

                ConstructorPerritos constructorPerritos =new ConstructorPerritos(actividad);
                if (constructorPerritos.obtnerNumeroPerritos()<5){
                    constructorPerritos.insertarPerro(perritos);
                }else{
                    constructorPerritos.borrarPrimerPerrito();
                    constructorPerritos.insertarPerro(perritos);
                }
                //constructorPerritos.insertarPerro(perritos);
                //constructorPerritos.darLikePerrito(perritos);
                //constructorPerritos.eliminarPerrito(perritos);
               // perritoViewHolder.tvLikes.setText(constructorPerritos.obtenerLikesPerrito(perritos));
            }
        });
    }

    @Override
    public int getItemCount() {
        return Perritus.size();
    }

    public static class perritoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombrePerritu;
        private TextView tvLikes;
        private ImageButton imgBtnLike;

        public perritoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imagenPerritu);
            tvLikes = (TextView) itemView.findViewById(R.id.textViewLikes);
            tvNombrePerritu = (TextView) itemView.findViewById(R.id.textViewNombre);
            imgBtnLike = (ImageButton) itemView.findViewById(R.id.HuesoLike);
        }
    }
}
