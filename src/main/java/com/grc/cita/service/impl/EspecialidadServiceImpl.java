package com.grc.cita.service.impl;

import com.grc.cita.model.Especialidad;
import com.grc.cita.repo.IEspecialidadRepo;
import com.grc.cita.service.IEspecialidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

    @Autowired
    private IEspecialidadRepo repo;


    @Override
    public Especialidad registrar(Especialidad pac) {
       return repo.save(pac);
    }

    @Override
    public Especialidad modificar(Especialidad pac) {
        return repo.save(pac);
    }

    @Override
    public List<Especialidad> listar() {
        return repo.findAll();
    }

    @Override
    public Especialidad leerPorId(Integer id) {
        Optional<Especialidad> optionalEspecialidad = repo.findById(id);
        return optionalEspecialidad.orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
