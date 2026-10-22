package com.example.lab4;

import java.io.Serializable;

public class masina implements Serializable {
    private String marca;
    private int anFabricatie;
    private boolean esteElectrica;
    private float rating;

    public masina(String marca, int anFabricatie, boolean esteElectrica, float rating) {
        this.marca = marca;
        this.anFabricatie = anFabricatie;
        this.esteElectrica = esteElectrica;
        this.rating = rating;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public boolean isEsteElectrica() {
        return esteElectrica;
    }

    public void setEsteElectrica(boolean esteElectrica) {
        this.esteElectrica = esteElectrica;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Marcă: " + marca + ", An: " + anFabricatie + ", Electrică: " + (esteElectrica ? "Da" : "Nu") + ", Rating: " + rating;
    }
}
//update