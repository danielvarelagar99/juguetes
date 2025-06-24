package com.example.juguetes_reservas_api.repository;

import com.example.juguetes_reservas_api.model.Juguete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugueteRepository extends JpaRepository<Juguete, Long> {
    List<Juguete> findByAvailableTrue();
}
