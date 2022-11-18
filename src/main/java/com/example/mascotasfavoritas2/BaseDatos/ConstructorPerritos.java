package com.example.mascotasfavoritas2.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mascotasfavoritas2.R;
import com.example.mascotasfavoritas2.pojo.Perritu;

import java.util.ArrayList;

public class ConstructorPerritos {

    private Context context;

    public   ConstructorPerritos (Context context){
        this.context = context;
    }

    public ArrayList<Perritu> obtenerDatos(){
        /*ArrayList<Perritu> lista= new ArrayList<>();
        lista.add(new Perritu(R.drawable.rex,250,"Rex"));
        lista.add(new Perritu(R.drawable.kim,100,"Kim"));
        lista.add(new Perritu(R.drawable.guardian,20,"Guardian"));
        lista.add(new Perritu(R.drawable.lana,20,"Lana"));
        return lista; */

        BaseDatos db = new BaseDatos(context);
        //insetarTresPerritos(db);
        return db.obtenerTodosLosPerritos();
    }

    public void insetarTresPerritos ( BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBasesDeDatos.TABLE_CONTACTS_ID,1);
        contentValues.put(ConstantesBasesDeDatos.TABLE_CONTACTS_NOMBRE,"Rex");
        contentValues.put(ConstantesBasesDeDatos.TABLE_CONTACTS_FOTO, R.drawable.rex);
        contentValues.put(ConstantesBasesDeDatos.TABLE_LIEKS_CONTACTS_NUMERO_DE_LIKES,0);
        db.insertarPerrito(contentValues);
    }

    public void insertarPerro (Perritu perritu){
        BaseDatos db =new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBasesDeDatos.TABLE_CONTACTS_ID,perritu.getId());
        contentValues.put(ConstantesBasesDeDatos.TABLE_CONTACTS_NOMBRE, perritu.getNombre());
        contentValues.put(ConstantesBasesDeDatos.TABLE_CONTACTS_FOTO,perritu.getFoto());
        contentValues.put(ConstantesBasesDeDatos.TABLE_LIEKS_CONTACTS_NUMERO_DE_LIKES,perritu.getLikes());
        System.out.println(perritu);
        db.insertarPerrito(contentValues);
    }

    public int obtenerLikesPerrito(Perritu perritu){
        Perritu perritoLikes = new Perritu();
        BaseDatos db = new BaseDatos(context);
        perritoLikes=db.buscarPerrito(perritu.getId());
        return perritoLikes.getLikesInt();
    }

    public void darLikePerrito(Perritu perritu){
        BaseDatos db =new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBasesDeDatos.TABLE_CONTACTS_ID,perritu.getId());
        contentValues.put(ConstantesBasesDeDatos.TABLE_CONTACTS_NOMBRE, perritu.getNombre());
        contentValues.put(ConstantesBasesDeDatos.TABLE_CONTACTS_FOTO,R.drawable.kim);
        contentValues.put(ConstantesBasesDeDatos.TABLE_LIEKS_CONTACTS_NUMERO_DE_LIKES,perritu.getLikes());
        db.modificarPerrito(contentValues,perritu.getId());

    }

    public  int obtnerNumeroPerritos (){
        BaseDatos db = new BaseDatos(context);
        return db.numeroDePerritos();
    }

    public void borrarUltimoPerrito(){
        BaseDatos db = new BaseDatos((context));
        Perritu perritu = new Perritu();
        perritu= db.ultimoPerrito();
        db.borrarPerrito(perritu.getId());
    }

    public void borrarPrimerPerrito(){
        BaseDatos db = new BaseDatos((context));
        Perritu perritu = new Perritu();
        perritu= db.primerPerrito();
        db.borrarPerrito(perritu.getId());
    }

    public void eliminarPerrito(Perritu perritu){
        BaseDatos db =new BaseDatos(context);
        db.borrarPerrito(perritu.getId());
    }
}
