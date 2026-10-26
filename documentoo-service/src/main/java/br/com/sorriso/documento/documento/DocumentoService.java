package br.com.sorriso.documento.documento;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {
    private final DocumentoRepository repository;

    public DocumentoService(DocumentoRepository repository) {
        this.repository = repository;
    }

    public HealthDocumento create(DocumentoRequest r) {
        return repository.save(new HealthDocumento(r.beneficiarioId(), r.documentoType(), r.documentoNumber()));
    }

    public List<HealthDocumento> findByBeneficiario(Long id) {
        return repository.findByBeneficiarioId(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
