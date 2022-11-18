package com.example.mascotasfavoritas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
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
