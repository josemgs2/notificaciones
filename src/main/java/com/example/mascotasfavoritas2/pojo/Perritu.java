package com.example.mascotasfavoritas2.pojo;

public class Perritu {
    private int id;
    private String nombre;
    private int likes;
    private int foto;

    public Perritu (){}

    public Perritu (int id, int foto, int likes, String nombre){
        this.id = id;
        this.foto = foto;
        this.likes = likes;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLikes() {
        return String.valueOf(likes);
    }

    public int getLikesInt() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void setId(int id) { this.id = id; }
    public int getId() {return id;}
}
