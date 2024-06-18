package com.grc.cita.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    private int idUsuario;

    @Column(name="nombre", nullable=false,unique = true)
    private String username;


    @Column(name="clave", nullable=false)
    private String password;

    @Column(name="estado", nullable=false)
    private boolean  estado;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="usuario_rol",joinColumns = @JoinColumn(name="id_usuario",referencedColumnName = "idUsuario"),inverseJoinColumns = @JoinColumn(name="id_rol",referencedColumnName = "idRol"))
    private List<Rol> roles;

    private int intentos;

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
