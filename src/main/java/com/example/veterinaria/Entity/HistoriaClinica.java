package com.example.veterinaria.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "historias_clinicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Historia clínica de una mascota")
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull(message = "La fecha de apertura es obligatoria")

    private LocalDate fechaApertura;

    @Schema(description = "Antecedentes médicos previos", example = "Vacunación al día, esterilizado")
    private String antecedentes;

    @Schema(description = "Observaciones generales", example = "Alergia a la penicilina")
    private String observaciones;

    @OneToOne
    @JoinColumn(name = "mascota_id", unique = true)
    @JsonIgnore
    private Mascota mascota;
}
