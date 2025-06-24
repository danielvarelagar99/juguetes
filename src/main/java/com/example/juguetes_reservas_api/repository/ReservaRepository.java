package com.example.juguetes_reservas_api.repository;

import com.example.juguetes_reservas_api.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByAlumnoId(Long alumnoId);
}
