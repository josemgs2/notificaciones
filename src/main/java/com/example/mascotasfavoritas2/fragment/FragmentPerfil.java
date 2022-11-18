package com.example.mascotasfavoritas2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mascotasfavoritas2.R;
import com.example.mascotasfavoritas2.adapter.PerfilAdaptador;
import com.example.mascotasfavoritas2.adapter.PerritusAdaptador;
import com.example.mascotasfavoritas2.pojo.Perritu;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPerfil extends Fragment {

    private ArrayList<Perritu> listaPerritusFavoritos;
    private RecyclerView rvPerfil;

    public FragmentPerfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_perfil, container, false);

        rvPerfil = (RecyclerView) v.findViewById(R.id.resicleViewPerfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        rvPerfil.setLayoutManager(glm);

        inicializarListaDePerritus ();
        inicializarAdaptador2();

        return v;
    }

    public void inicializarAdaptador2(){
        PerfilAdaptador adaptador = new PerfilAdaptador(listaPerritusFavoritos, getActivity());
        rvPerfil.setAdapter(adaptador);
    }

    public void  inicializarListaDePerritus (){
        listaPerritusFavoritos = new ArrayList<>();
        listaPerritusFavoritos.add(new Perritu(1,R.drawable.rex,250,"Rex"));
        listaPerritusFavoritos.add(new Perritu(2,R.drawable.kim,100,"Kim"));
        listaPerritusFavoritos.add(new Perritu(3,R.drawable.guardian,20,"Guardian"));
        listaPerritusFavoritos.add(new Perritu(4,R.drawable.lana,20,"Lana"));
    }
}
