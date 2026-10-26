
package br.com.sorriso.documento.documento;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DocumentoServiceTest {

    @Mock
    DocumentoRepository repository;

    @InjectMocks
    DocumentoService service;

    @Test
    void createShouldSaveDocumento() {
        when(repository.save(any(HealthDocumento.class)))
                .thenAnswer(i -> i.getArgument(0));

        DocumentoRequest request =
                new DocumentoRequest(1L, "CPF", "12345678900");

        HealthDocumento result = service.create(request);

        assertEquals(1L, result.getBeneficiarioId());
        assertEquals("CPF", result.getDocumentoType());
    }

    @Test
    void shouldListDocumentoosByBeneficiario() {
        when(repository.findByBeneficiarioId(7L))
                .thenReturn(List.of(
                        new HealthDocumento(7L, "RG", "123")
                ));

        assertEquals(1, service.findByBeneficiario(7L).size());

        verify(repository).findByBeneficiarioId(7L);
    }
}
