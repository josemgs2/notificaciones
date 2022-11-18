package com.example.mascotasfavoritas2;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.mascotasfavoritas2.adapter.PageAdapter;
import com.example.mascotasfavoritas2.adapter.PerritusAdaptador;
import com.example.mascotasfavoritas2.fragment.FragmentPerfil;
import com.example.mascotasfavoritas2.fragment.FragmentRecycleView;
import com.example.mascotasfavoritas2.pojo.Perritu;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    private  Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        //listaRecycle = (RecyclerView) findViewById(R.id.resicleViewMascotasFavoritas);

       /* // LinearLayoutManager  llm = new LinearLayoutManager(this);
        GridLayoutManager glm = new GridLayoutManager(this,1);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //listaRecycle.setLayoutManager(llm);
        listaRecycle.setLayoutManager(glm);
        inicializarListaDePerritus();
        inicializarAdaptador();*/

       if (toolbar != null){
           setSupportActionBar(toolbar);
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       }



    }

    private ArrayList <Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

         fragments.add(new FragmentRecycleView());
         fragments.add(new FragmentPerfil());

         return fragments;
    }


    private void  setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.icons8_dog_house_64);
        tabLayout.getTabAt(1).setIcon(R.drawable.icons8_year_of_dog_50_1);
    }


    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.ihw_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        Intent myintent;
        switch (id) {
            case R.id.mnSiguiente:
                myintent = new Intent(this, MascotasFavoritas.class);
                startActivity(myintent);
                return false;

            case R.id.AcercaDe:
                myintent = new Intent(this, AcercaDe.class);
                startActivity(myintent);
                return false;

            case R.id.Contacto:
                myintent = new Intent(this, Contacto.class);
                startActivity(myintent);
                return false;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}