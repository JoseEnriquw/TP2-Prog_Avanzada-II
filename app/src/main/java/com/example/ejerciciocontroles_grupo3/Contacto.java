package com.example.ejerciciocontroles_grupo3;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Contacto implements Serializable {
    private String nombre;
    private String apellido;
    private DatoContacto telefono;
    private DatoContacto email;
    private String direccion;
    private String fechaNacimiento;
    private String nivelEstudioAlcanzado;
    private List<String> intereses;
    private Boolean recibirInf;

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, DatoContacto telefono, DatoContacto email, String direccion, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
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

    public DatoContacto getTelefono() {
        return telefono;
    }

    public void setTelefono(DatoContacto telefono) {
        this.telefono = telefono;
    }

    public DatoContacto getEmail() {
        return email;
    }

    public void setEmail(DatoContacto email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNivelEstudioAlcanzado() {
        return nivelEstudioAlcanzado;
    }

    public void setNivelEstudioAlcanzado(String nivelEstudioAlcanzado) {
        this.nivelEstudioAlcanzado = nivelEstudioAlcanzado;
    }

    public List<String> getIntereses() {
        return intereses;
    }

    public void setIntereses(List<String> intereses) {
        this.intereses = intereses;
    }

    public Boolean getRecibirInf() {
        return recibirInf;
    }

    public void setRecibirInf(Boolean recibirInf) {
        this.recibirInf = recibirInf;
    }

    @Override
    public String toString() {
        return  nombre +" "+ apellido +
                "-" + email;
    }
}
