package com.example.mascotasfavoritas2.fragment;

import com.example.mascotasfavoritas2.adapter.PerritusAdaptador;
import com.example.mascotasfavoritas2.pojo.Perritu;

import java.util.ArrayList;

public interface IFragmentRecycleView {

  public void generarLinearLayoutVertical ();

  public PerritusAdaptador crearAdaptador (ArrayList <Perritu> perrito);

  public void inicializarAdaptadorRV (PerritusAdaptador adaptador);
}
