package com.example.juguetes_reservas_api.service;

import com.example.juguetes_reservas_api.model.Alumno;
import com.example.juguetes_reservas_api.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void delete(Long id) {
        alumnoRepository.deleteById(id);
    }
}
