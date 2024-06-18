package com.grc.cita;

import com.grc.cita.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = usuarioService.loadUserByUsername(username);

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            usuarioService.incrementarIntentosFallidos(username);
            int intentosFallidos = usuarioService.obtenerIntentosFallidos(username);
            if (intentosFallidos >= 3) {
                throw new BadCredentialsException("Número de intentos fallidos: " + intentosFallidos + ". Usuario bloqueado.");
            } else {
                throw new BadCredentialsException("Usuario o contraseña incorrectos. Intento fallido: " + intentosFallidos);
            }
        }

        if (!usuarioService.isUsuarioActivo(username)) {
            throw new LockedException("Usuario bloqueado. Por favor, contacte al administrador.");
        }

        // Reiniciar intentos fallidos si la autenticación es exitosa
        usuarioService.reiniciarIntentosFallidos(username);

        // Construir la lista de authorities (roles)
        List<GrantedAuthority> authorities = new ArrayList<>(userDetails.getAuthorities());

        // Devolver UsernamePasswordAuthenticationToken si la autenticación es exitosa
        return new UsernamePasswordAuthenticationToken(userDetails, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
