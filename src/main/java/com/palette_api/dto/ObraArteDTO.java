package com.palette_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ObraArteDTO {
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    private Integer anoCriacao;

    @NotBlank(message = "O nome é obrigatório.")
    private String tecnica;

    private Long pintorId;
}
