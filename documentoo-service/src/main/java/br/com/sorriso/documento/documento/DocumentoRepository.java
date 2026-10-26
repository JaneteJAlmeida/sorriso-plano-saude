package br.com.sorriso.documento.documento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentoRepository extends JpaRepository<HealthDocumento, Long> {
    List<HealthDocumento> findByBeneficiarioId(Long beneficiarioId);
}
