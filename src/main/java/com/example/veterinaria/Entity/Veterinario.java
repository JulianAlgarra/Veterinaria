package com.example.veterinaria.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "veterinarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")

    private String nombre;

    @NotBlank(message = "La tarjeta profesional es obligatoria")
    @Column(unique = true)

    private String tarjetaProfesional;

    @NotBlank(message = "La especialidad es obligatoria")

    private String especialidad;

    @Email(message = "Debe ser un correo válido")
    @NotBlank(message = "El correo es obligatorio")
    @Column(unique = true)

    private String correo;

    @ManyToMany(mappedBy = "veterinarios")
    @JsonIgnore
    @Builder.Default
    private List<Mascota> mascotas = new ArrayList<>();
}