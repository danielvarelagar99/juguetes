package com.example.juguetes_reservas_api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String surname;

    // Campos personalizados que empiezan por dvg_
    private String dvg_email;

    private String dvg_grado;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDvg_email() {
        return dvg_email;
    }

    public void setDvg_email(String dvg_email) {
        this.dvg_email = dvg_email;
    }

    public String getDvg_grado() {
        return dvg_grado;
    }

    public void setDvg_grado(String dvg_grado) {
        this.dvg_grado = dvg_grado;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}