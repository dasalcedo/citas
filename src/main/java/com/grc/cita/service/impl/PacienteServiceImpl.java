package com.grc.cita.service.impl;

import com.grc.cita.model.Paciente;
import com.grc.cita.repo.IPacienteRepo;
import com.grc.cita.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteRepo repo;


    @Override
    public Paciente registrar(Paciente pac) {
       return repo.save(pac);
    }

    @Override
    public Paciente modificar(Paciente pac) {
        return repo.save(pac);
    }

    @Override
    public List<Paciente> listar() {
        return repo.findAll();
    }

    @Override
    public Paciente leerPorId(Integer id) {
        Optional<Paciente> optionalPaciente = repo.findById(id);
        return optionalPaciente.orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
