package com.example.mascotasfavoritas2.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mascotasfavoritas2.MascotasFavoritas;
import com.example.mascotasfavoritas2.Presentador.IRecycleViewFragmentPresentador;
import com.example.mascotasfavoritas2.Presentador.RecyclerViewFrgamentPresentador;
import com.example.mascotasfavoritas2.R;
import com.example.mascotasfavoritas2.adapter.PerritusAdaptador;
import com.example.mascotasfavoritas2.pojo.Perritu;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecycleView extends Fragment implements IFragmentRecycleView{

   // private ArrayList<Perritu> listaPerritusFavoritos = new ArrayList<>();;
    private  RecyclerView rvPerritus;
    private IRecycleViewFragmentPresentador presentador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment_recycle_view, container, false);

        View v = inflater.inflate(R.layout.fragment_fragment_recycle_view,container,false);

        rvPerritus = (RecyclerView) v.findViewById(R.id.resicleViewMascotasFavoritas);
        presentador = new RecyclerViewFrgamentPresentador(this,getContext());
        return v;
    }

   // public void  inicializarListaDePerritus (){
     //   listaPerritusFavoritos.add(new Perritu(R.drawable.rex,250,"Rex"));
     // listaPerritusFavoritos.add(new Perritu(R.drawable.kim,100,"Kim"));
      //  listaPerritusFavoritos.add(new Perritu(R.drawable.guardian,20,"Guardian"));
      //  listaPerritusFavoritos.add(new Perritu(R.drawable.lana,20,"Lana"));
    //}

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPerritus.setLayoutManager(llm);
    }

    @Override
    public PerritusAdaptador crearAdaptador(ArrayList<Perritu> perrito) {
        PerritusAdaptador adaptador = new PerritusAdaptador( perrito, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(PerritusAdaptador adaptador) {

        rvPerritus.setAdapter(adaptador);

    }
}
