package com.example.ejerciciocontroles_grupo3;

import java.io.Serializable;

public class DatoContacto implements Serializable {
    private String Dato;
    private String Lugar;

    public DatoContacto(String dato, String Lugar){
        this.Dato = dato;
        this.Lugar = Lugar;
    }

    public String getDato() {
        return Dato;
    }

    public void setDato(String dato) {
        Dato = dato;
    }

    @Override
    public String toString() {
        return this.Dato + " - " + this.Lugar;
    }
}
