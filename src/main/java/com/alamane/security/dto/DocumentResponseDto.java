package com.alamane.security.dto;

import com.alamane.security.enums.StatutDocument;
import com.alamane.security.enums.TypeDocument;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class DocumentResponseDto {
    private Long id;
    private String numeroPiece;
    private TypeDocument type;
    private String categorieComptable;
    private LocalDate datePiece;
    private Double montant;
    private String fournisseur;
    private String pathFile;
    private StatutDocument statut;
    private String commentaireValidation;
    private String motifRejet;
    private LocalDateTime dateValidation;
    private LocalDateTime creationDate;
    private Long societeId;
    private String societeRaisonSociale;
}
