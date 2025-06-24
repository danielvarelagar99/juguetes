package com.example.juguetes_reservas_api.service;

import com.example.juguetes_reservas_api.model.Juguete;
import com.example.juguetes_reservas_api.repository.JugueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugueteService {

    @Autowired
    private JugueteRepository jugueteRepository;

    public List<Juguete> findAll() {
        return jugueteRepository.findAll();
    }

    public Juguete findById(Long id) {
        return jugueteRepository.findById(id).orElse(null);
    }

    public Juguete save(Juguete juguete) {
        return jugueteRepository.save(juguete);
    }

    public void delete(Long id) {
        jugueteRepository.deleteById(id);
    }

    public List<Juguete> findDisponibles() {
        return jugueteRepository.findByAvailableTrue();
    }
}

