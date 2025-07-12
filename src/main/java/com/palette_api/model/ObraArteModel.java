package com.palette_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "obra_arte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraArteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(nullable = false)
    private int anoCriacao;

    @Column(nullable = false)
    private String tecnica;


    @ManyToOne
    @JoinColumn(name = "pintor_id")
    private PintorModel pintor;

}
