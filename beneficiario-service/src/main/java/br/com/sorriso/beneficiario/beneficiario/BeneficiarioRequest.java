
package br.com.sorriso.beneficiario.beneficiario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record BeneficiarioRequest(
        @NotBlank String nome,
        String telefone,
        @Email String email
) {
}

