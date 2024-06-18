package com.grc.cita;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.grc.cita.model.Usuario;
import com.grc.cita.repo.IUsuarioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootTest
class CitaApplicationTests {

    @Autowired
    private IUsuarioRepo repo;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Test
    public void crearUsuario() {
    Usuario us= new Usuario();
    us.setIdUsuario(1);
    us.setUsername("sperez");
    us.setPassword(bcrypt.encode("123"));
    us.setEstado(true);

    Usuario retorno=repo.save(us);

    assertTrue(retorno.getPassword().equals(us.getPassword()));
    }

}
