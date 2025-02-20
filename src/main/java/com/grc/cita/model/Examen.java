package com.grc.cita.model;

import jakarta.persistence.*;

@Entity
@Table(name="examen")
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExamen;

    @Column(name="nombre",nullable=false,length=50)
    private String nombre;

    @Column(name="descripcion",nullable=false,length=150)
    private String descripcion;

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
