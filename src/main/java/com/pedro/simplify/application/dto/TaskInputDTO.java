package com.pedro.simplify.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskInputDTO(
        @NotBlank String name,
        @NotBlank String description,
        @NotNull boolean realized,
        @NotNull int priority) {
}
