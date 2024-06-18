package com.grc.cita.repo;

import com.grc.cita.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepo extends JpaRepository<Usuario,Integer> {

    Usuario findOneByUsername(String username);

}