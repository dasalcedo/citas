package com.grc.cita.service.impl;

import com.grc.cita.model.Medico;
import com.grc.cita.repo.IMedicoRepo;
import com.grc.cita.service.IMedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements IMedicoService {

    @Autowired
    private IMedicoRepo repo;


    @Override
    public Medico registrar(Medico pac) {
       return repo.save(pac);
    }

    @Override
    public Medico modificar(Medico pac) {
        return repo.save(pac);
    }

    @Override
    public List<Medico> listar() {
        return repo.findAll();
    }

    @Override
    public Medico leerPorId(Integer id) {
        Optional<Medico> optionalMedico = repo.findById(id);
        return optionalMedico.orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
