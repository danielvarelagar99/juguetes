package com.example.juguetes_reservas_api.controller;

import com.example.juguetes_reservas_api.model.Juguete;
import com.example.juguetes_reservas_api.service.JugueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/juguetes")
public class JugueteController {

    @Autowired
    private JugueteService jugueteService;

    @GetMapping
    public List<Juguete> getAllJuguetes() {
        return jugueteService.findAll();
    }

    @GetMapping("/disponibles")
    public List<Juguete> getJuguetesDisponibles() {
        return jugueteService.findDisponibles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Juguete> getJugueteById(@PathVariable Long id) {
        Juguete juguete = jugueteService.findById(id);
        if (juguete == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(juguete);
    }

    @PostMapping
    public Juguete createJuguete(@RequestBody Juguete juguete) {
        return jugueteService.save(juguete);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Juguete> updateJuguete(@PathVariable Long id, @RequestBody Juguete jugueteDetails) {
        Juguete juguete = jugueteService.findById(id);
        if (juguete == null) {
            return ResponseEntity.notFound().build();
        }

        juguete.setName(jugueteDetails.getName());
        juguete.setAvailable(jugueteDetails.isAvailable());
        juguete.setVarela_categoria(jugueteDetails.getVarela_categoria());

        return ResponseEntity.ok(jugueteService.save(juguete));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJuguete(@PathVariable Long id) {
        jugueteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
