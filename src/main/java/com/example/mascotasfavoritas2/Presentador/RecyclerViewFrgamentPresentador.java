package com.example.mascotasfavoritas2.Presentador;

import android.content.Context;

import com.example.mascotasfavoritas2.BaseDatos.ConstructorPerritos;
import com.example.mascotasfavoritas2.adapter.PerritusAdaptador;
import com.example.mascotasfavoritas2.fragment.IFragmentRecycleView;
import com.example.mascotasfavoritas2.pojo.Perritu;

import java.util.ArrayList;

public class RecyclerViewFrgamentPresentador implements IRecycleViewFragmentPresentador {

    private IFragmentRecycleView iFragmentRecycleView;
    private Context context;
    private ConstructorPerritos constructorPerritos;
    private ArrayList<Perritu> perritos = new ArrayList<>();

    public RecyclerViewFrgamentPresentador(IFragmentRecycleView iFragmentRecycleView, Context context){
        this.iFragmentRecycleView = iFragmentRecycleView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorPerritos = new ConstructorPerritos(context);
        perritos=constructorPerritos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iFragmentRecycleView.inicializarAdaptadorRV(iFragmentRecycleView.crearAdaptador(perritos));
        iFragmentRecycleView.generarLinearLayoutVertical();
    }
}
