package com.FutbolClub.App.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import jakarta.validation.constraints.NotEmpty;

@Document(collection="jugadores")
public class Jugadores {
    
    @Id
    private String id;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    private int numero;
    
    @NotEmpty
    private String posicion;

    @DocumentReference
    private Clubes club;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Clubes getClub() {
        return club;
    }

    public void setClub(Clubes club) {
        this.club = club;
    }
}
