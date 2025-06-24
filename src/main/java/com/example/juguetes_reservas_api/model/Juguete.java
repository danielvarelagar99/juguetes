package com.example.juguetes_reservas_api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Juguete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean available = true;

    // Campo personalizado
    private String varela_categoria;

    @OneToMany(mappedBy = "juguete", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getVarela_categoria() {
        return varela_categoria;
    }

    public void setVarela_categoria(String varela_categoria) {
        this.varela_categoria = varela_categoria;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
