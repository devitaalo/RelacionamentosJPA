package io.github.ital023.ProjetoPraticoRelacionamentos.rest.dto;

import io.github.ital023.ProjetoPraticoRelacionamentos.domain.entities.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResultadoDbDTO {

    private String name;

    private Double price;

    private String nameAuthor;


}
