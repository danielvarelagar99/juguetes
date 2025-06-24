package com.example.juguetes_reservas_api.service;

import com.example.juguetes_reservas_api.model.*;
import com.example.juguetes_reservas_api.repository.AlumnoRepository;
import com.example.juguetes_reservas_api.repository.JugueteRepository;
import com.example.juguetes_reservas_api.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private JugueteRepository jugueteRepository;

    public Reserva reservar(Long alumnoId, Long jugueteId) throws Exception {
        Alumno alumno = alumnoRepository.findById(alumnoId).orElseThrow(() -> new Exception("Alumno no encontrado"));
        Juguete juguete = jugueteRepository.findById(jugueteId).orElseThrow(() -> new Exception("Juguete no encontrado"));

        if (!juguete.isAvailable()) {
            throw new Exception("El juguete no está disponible");
        }

        Reserva reserva = new Reserva();
        reserva.setAlumno(alumno);
        reserva.setJuguete(juguete);
        reserva.setBookingDate(LocalDateTime.now());
        reserva.setStatus(Reserva.Status.RESERVED);
        reserva.setDaniel_observaciones("Primera reserva");  // ejemplo de uso
        reserva.setDaniel_autorizado(true);

        juguete.setAvailable(false);  // Marcar como no disponible
        jugueteRepository.save(juguete);
        return reservaRepository.save(reserva);
    }

    public Reserva devolver(Long reservaId) throws Exception {
        Reserva reserva = reservaRepository.findById(reservaId).orElseThrow(() -> new Exception("Reserva no encontrada"));

        if (reserva.getStatus() == Reserva.Status.RETURNED) {
            throw new Exception("El juguete ya fue devuelto");
        }

        reserva.setReturnDate(LocalDateTime.now());
        reserva.setStatus(Reserva.Status.RETURNED);

        // Marcar juguete como disponible otra vez
        Juguete juguete = reserva.getJuguete();
        juguete.setAvailable(true);
        jugueteRepository.save(juguete);

        return reservaRepository.save(reserva);
    }

    public List<Reserva> historialPorAlumno(Long alumnoId) {
        return reservaRepository.findByAlumnoId(alumnoId);
    }
}
