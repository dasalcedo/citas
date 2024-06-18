package com.grc.cita.service.impl;

import com.grc.cita.model.Examen;
import com.grc.cita.repo.IExamenRepo;
import com.grc.cita.service.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements IExamenService {

    @Autowired
    private IExamenRepo repo;


    @Override
    public Examen registrar(Examen pac) {
       return repo.save(pac);
    }

    @Override
    public Examen modificar(Examen pac) {
        return repo.save(pac);
    }

    @Override
    public List<Examen> listar() {
        return repo.findAll();
    }

    @Override
    public Examen leerPorId(Integer id) {
        Optional<Examen> optionalExamen = repo.findById(id);
        return optionalExamen.orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
