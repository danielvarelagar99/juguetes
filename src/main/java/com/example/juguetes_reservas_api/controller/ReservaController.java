package com.example.juguetes_reservas_api.controller;

import com.example.juguetes_reservas_api.model.Reserva;
import com.example.juguetes_reservas_api.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<?> reservar(@RequestParam Long alumnoId, @RequestParam Long jugueteId) {
        try {
            Reserva reserva = reservaService.reservar(alumnoId, jugueteId);
            return ResponseEntity.ok(reserva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/devolver")
    public ResponseEntity<?> devolver(@PathVariable Long id) {
        try {
            Reserva reserva = reservaService.devolver(id);
            return ResponseEntity.ok(reserva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/alumno/{alumnoId}")
    public List<Reserva> historialPorAlumno(@PathVariable Long alumnoId) {
        return reservaService.historialPorAlumno(alumnoId);
    }
}
