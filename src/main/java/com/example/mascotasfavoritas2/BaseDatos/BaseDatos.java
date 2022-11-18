package com.example.mascotasfavoritas2.BaseDatos;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mascotasfavoritas2.pojo.Perritu;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {


    private Context contexto;
    public BaseDatos (Context context){
        super(context,ConstantesBasesDeDatos.DATABASE_NAME,null,ConstantesBasesDeDatos.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaPerrito = "CREATE TABLE " + ConstantesBasesDeDatos.TABLE_CONTACTS +"("+
                ConstantesBasesDeDatos.TABLE_CONTACTS_ID + " INTEGER PRIMARY KEY , "+
                ConstantesBasesDeDatos.TABLE_CONTACTS_NOMBRE+" TEXT, "+
                ConstantesBasesDeDatos.TABLE_CONTACTS_FOTO+" INTEGER, " +
                ConstantesBasesDeDatos.TABLE_LIEKS_CONTACTS_NUMERO_DE_LIKES + " INTEGER "+
                ")";


        db.execSQL(queryCrearTablaPerrito);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBasesDeDatos.TABLE_CONTACTS);
        onCreate(db);
    }

    public ArrayList<Perritu> obtenerTodosLosPerritos(){
        ArrayList<Perritu> perritos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBasesDeDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()){
            Perritu perrituActual = new Perritu();
            perrituActual.setId(registros.getInt(0));
            perrituActual.setNombre(registros.getString(1));
            perrituActual.setFoto(registros.getInt(2));
            perrituActual.setLikes(registros.getInt(3));
            //System.out.println(perrituActual.getId());
            //System.out.println(perrituActual.getNombre());
            //System.out.println(perrituActual.getFoto());
            //System.out.println(perrituActual.getLikes());
            perritos.add(perrituActual);
        }
        db.close();
       //System.out.println(perritos);
        return perritos;
    }

    public void insertarPerrito(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBasesDeDatos.TABLE_CONTACTS,null, contentValues);
        System.out.println("Perrito Insertado");
        db.close();
    }

    public Perritu buscarPerrito (int id){
        boolean bandera;
        bandera = true;
        String query = "SELECT * FROM " + ConstantesBasesDeDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        Perritu perrituActual = new Perritu();
        while (registros.moveToNext() && bandera){
            perrituActual.setId(registros.getInt(0));
            perrituActual.setNombre(registros.getString(1));
            perrituActual.setFoto(registros.getInt(2));
            perrituActual.setLikes(registros.getInt(3));
            if (id == perrituActual.getId()) {

                bandera = false;

            }
            //System.out.println(perrituActual.getId());
            //System.out.println(perrituActual.getNombre());
            //System.out.println(perrituActual.getFoto());
            //System.out.println(perrituActual.getLikes());
        }
        return perrituActual;
    }

    public Perritu ultimoPerrito(){
        String query = "SELECT * FROM " + ConstantesBasesDeDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        Perritu perrituActual = new Perritu();
        while (registros.moveToNext()){
            perrituActual.setId(registros.getInt(0));
            perrituActual.setNombre(registros.getString(1));
            perrituActual.setFoto(registros.getInt(2));
            perrituActual.setLikes(registros.getInt(3));
            //System.out.println(perrituActual.getId());
            //System.out.println(perrituActual.getNombre());
            //System.out.println(perrituActual.getFoto());
            //System.out.println(perrituActual.getLikes());
        }
        return perrituActual;
    }

    public Perritu primerPerrito(){
        int contador =0;
        String query = "SELECT * FROM " + ConstantesBasesDeDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        Perritu perrituActual = new Perritu();
        while (registros.moveToNext() && contador==0){
            perrituActual.setId(registros.getInt(0));
            perrituActual.setNombre(registros.getString(1));
            perrituActual.setFoto(registros.getInt(2));
            perrituActual.setLikes(registros.getInt(3));
            //System.out.println(perrituActual.getId());
            //System.out.println(perrituActual.getNombre());
            //System.out.println(perrituActual.getFoto());
            //System.out.println(perrituActual.getLikes());
            contador++;
        }
        return perrituActual;
    }

    public int numeroDePerritos(){
        int numero=0;
        String query = "SELECT * FROM " + ConstantesBasesDeDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()){
            numero++;
        }
        return numero;
    }

    public void borrarPerrito(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ConstantesBasesDeDatos.TABLE_CONTACTS,ConstantesBasesDeDatos.TABLE_CONTACTS_ID+"="+id,null);
        db.close();
    }

    public void modificarPerrito(ContentValues contentValues,int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantesBasesDeDatos.TABLE_CONTACTS,contentValues,ConstantesBasesDeDatos.TABLE_CONTACTS_ID+"="+id,null);
        db.close();
    }

}
