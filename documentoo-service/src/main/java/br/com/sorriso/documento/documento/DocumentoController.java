package br.com.sorriso.documento.documento;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentoos")
public class DocumentoController {
    private final DocumentoService service;

    public DocumentoController(DocumentoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HealthDocumento create(@Valid @RequestBody DocumentoRequest r) {
        return service.create(r);
    }

    @GetMapping("/beneficiario/{beneficiarioId}")
    public List<HealthDocumento> findByBeneficiario(
            @PathVariable("beneficiarioId") Long beneficiarioId) {
        return service.findByBeneficiario(beneficiarioId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable ("id") Long id) {
        service.delete(id);
    }
}
