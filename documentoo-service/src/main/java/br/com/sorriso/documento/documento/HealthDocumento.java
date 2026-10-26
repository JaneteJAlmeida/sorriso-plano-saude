package br.com.sorriso.documento.documento;

import jakarta.persistence.*;

@Entity
@Table(name = "documentos")
public class HealthDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long beneficiarioId;

    @Column(nullable = false)
    private String documentoType;

    @Column(nullable = false)
    private String documentoNumber;

    public HealthDocumento() {
    }

    public HealthDocumento(
            Long beneficiarioId,
            String documentoType,
            String documentoNumber) {
        this.beneficiarioId = beneficiarioId;
        this.documentoType = documentoType;
        this.documentoNumber = documentoNumber;
    }

    public Long getId() {
        return id;
    }

    public Long getBeneficiarioId() {
        return beneficiarioId;
    }

    public void setBeneficiarioId(Long v) {
        beneficiarioId = v;
    }

    public String getDocumentoType() {
        return documentoType;
    }

    public void setDocumentoType(String v) {
        documentoType = v;
    }

    public String getDocumentoNumber() {
        return documentoNumber;
    }

    public void setDocumentoNumber(String v) {
        documentoNumber = v;
    }
}