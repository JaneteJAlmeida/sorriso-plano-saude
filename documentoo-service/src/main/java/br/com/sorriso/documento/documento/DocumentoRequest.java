package br.com.sorriso.documento.documento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DocumentoRequest(
        @NotNull Long beneficiarioId,
        @NotBlank String documentoType,
        @NotBlank String documentoNumber
) {
}