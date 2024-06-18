package com.wisecode.pet_tech.dto;

import java.util.UUID;

public record ProdutoDTO(
        UUID id,
        String nome,
        String descricao,
        double preco,
        String UrldaImagem
) {

}
