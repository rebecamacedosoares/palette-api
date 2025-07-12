package com.palette_api.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
public class PintorDTO {
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotNull(message = "A data de nascimento é obrigatória.")
    private LocalDate dataNascimento;

    private LocalDate dataFalecimento;

    @NotBlank(message = "A nacionalidade é obrigatória.")
    private String nacionalidade;
}

