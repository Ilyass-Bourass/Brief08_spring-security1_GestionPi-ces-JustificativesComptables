
package com.alamane.security.repository;

import com.alamane.security.entity.Document;
import com.alamane.security.enums.StatutDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findBySocieteId(Long societeId);

    List<Document> findByStatut(StatutDocument statut);

    List<Document> findByStatutOrderByCreationDateDesc(StatutDocument statut);
}

