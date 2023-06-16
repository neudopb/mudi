package com.alura.mudi.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record PedidoNewDTO(
        @NotBlank
        String nomeProduto,
        @NotBlank @URL
        String urlProduto,
        @NotBlank @URL
        String urlImg,
        String descricao) {

}
