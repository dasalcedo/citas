package com.grc.cita.service.impl;

import com.grc.cita.model.Consulta;
import com.grc.cita.repo.IConsultaRepo;
import com.grc.cita.service.IConsultaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements IConsultaService {

    @Autowired
    private IConsultaRepo repo;


    @Override
    public Consulta registrar(Consulta obj) {
       obj.getDetalleConsulta().forEach(det->{det.setConsulta(obj);});

        return repo.save(obj);
    }

    @Override
    public Consulta modificar(Consulta pac) {
        return repo.save(pac);
    }

    @Override
    public List<Consulta> listar() {
        return repo.findAll();
    }

    @Override
    public Consulta leerPorId(Integer id) {
        Optional<Consulta> optionalConsulta = repo.findById(id);
        return optionalConsulta.orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
