package com.grc.cita.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medico")

public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;

    @Column(name="nombres",nullable = false, length = 70)
    private String nombres;

    @Column(name="apellidos",nullable = false, length = 70)
    private String apellidos;

    @Column(name="CMP",nullable = false, length = 70)
    private String CMP;

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCMP() {
        return CMP;
    }

    public void setCMP(String CMP) {
        this.CMP = CMP;
    }
}
