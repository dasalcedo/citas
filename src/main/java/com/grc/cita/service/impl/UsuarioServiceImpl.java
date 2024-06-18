package com.grc.cita.service.impl;

import com.grc.cita.model.Rol;
import com.grc.cita.model.Usuario;
import com.grc.cita.repo.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioRepo usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findOneByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        // Construir authorities (roles) para el usuario
        List<GrantedAuthority> authorities = buildAuthorities(usuario.getRoles());

        // Construir UserDetails de Spring Security usando User
        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .authorities(authorities)
                .build();
    }

    private List<GrantedAuthority> buildAuthorities(List<Rol> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Rol rol : roles) {
            authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        return authorities;
    }

    public void incrementarIntentosFallidos(String username) {
        Usuario usuario = usuarioRepo.findOneByUsername(username);
        if (usuario != null) {
            usuario.setIntentos(usuario.getIntentos() + 1);
            if (usuario.getIntentos() >= 3) {
                usuario.setEstado(false); // Bloquear usuario
            }
            usuarioRepo.save(usuario);
        }
    }

    public void reiniciarIntentosFallidos(String username) {
        Usuario usuario = usuarioRepo.findOneByUsername(username);
        if (usuario != null) {
            usuario.setIntentos(0);
            usuarioRepo.save(usuario);
        }
    }

    public boolean isUsuarioActivo(String username) {
        Usuario usuario = usuarioRepo.findOneByUsername(username);
        return usuario != null && usuario.isEstado();
    }

    public int obtenerIntentosFallidos(String username) {
        Usuario usuario = usuarioRepo.findOneByUsername(username);
        return usuario != null ? usuario.getIntentos() : 0;
    }
}
