package com.example.juguetes_reservas_api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "juguete_id", nullable = false)
    private Juguete juguete;

    private LocalDateTime bookingDate;

    private LocalDateTime returnDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Campos personalizados con tu nombre: daniel_*
    private String daniel_observaciones;

    private boolean daniel_autorizado;

    public enum Status {
        RESERVED,
        RETURNED
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Juguete getJuguete() {
        return juguete;
    }

    public void setJuguete(Juguete juguete) {
        this.juguete = juguete;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDaniel_observaciones() {
        return daniel_observaciones;
    }

    public void setDaniel_observaciones(String daniel_observaciones) {
        this.daniel_observaciones = daniel_observaciones;
    }

    public boolean isDaniel_autorizado() {
        return daniel_autorizado;
    }

    public void setDaniel_autorizado(boolean daniel_autorizado) {
        this.daniel_autorizado = daniel_autorizado;
    }
}
