package io.github.ital023.ProjetoPraticoRelacionamentos.rest.dto;

import io.github.ital023.ProjetoPraticoRelacionamentos.domain.entities.Author;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {

    private String name;

    private Double price;

    private Integer author_id;

}
