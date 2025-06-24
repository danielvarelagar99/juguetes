package com.example.juguetes_reservas_api.controller;

import com.example.juguetes_reservas_api.model.Alumno;
import com.example.juguetes_reservas_api.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        Alumno alumno = alumnoService.findById(id);
        if (alumno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alumno);
    }

    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumnoDetails) {
        Alumno alumno = alumnoService.findById(id);
        if (alumno == null) {
            return ResponseEntity.notFound().build();
        }

        alumno.setName(alumnoDetails.getName());
        alumno.setSurname(alumnoDetails.getSurname());
        alumno.setDvg_email(alumnoDetails.getDvg_email());
        alumno.setDvg_grado(alumnoDetails.getDvg_grado());

        return ResponseEntity.ok(alumnoService.save(alumno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        alumnoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

