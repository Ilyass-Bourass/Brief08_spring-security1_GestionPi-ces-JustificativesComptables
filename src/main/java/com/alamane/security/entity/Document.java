package com.alamane.security.entity;

import com.alamane.security.enums.StatutDocument;
import com.alamane.security.enums.TypeDocument;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "documents")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numeroPiece;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeDocument type;

    private String categorieComptable;

    @Column(nullable = false)
    private LocalDate datePiece;

    private Double montant;

    private String fournisseur;

    @Column(nullable = false)
    private String pathFile;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutDocument statut;

    private String commentaireValidation;

    private String motifRejet;

    private LocalDateTime dateValidation;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    private LocalDateTime modificationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "societe_id", nullable = false)
    private Societe societe;

    @PrePersist
    public void prePersist() {
        this.creationDate = LocalDateTime.now();
        this.modificationDate = LocalDateTime.now();
        this.statut = StatutDocument.EN_ATTENTE;
    }
}
