package com.example.juguetes_reservas_api.repository;

import com.example.juguetes_reservas_api.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    boolean existsBySurname(String surname);
}
