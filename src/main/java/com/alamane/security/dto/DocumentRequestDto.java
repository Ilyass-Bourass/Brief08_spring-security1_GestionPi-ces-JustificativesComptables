package com.alamane.security.dto;

import com.alamane.security.enums.TypeDocument;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DocumentRequestDto {
    private String numeroPiece;
    private TypeDocument type;
    private String categorieComptable;
    private LocalDate datePiece;
    private Double montant;
    private String fournisseur;
    private Long societeId;
}
