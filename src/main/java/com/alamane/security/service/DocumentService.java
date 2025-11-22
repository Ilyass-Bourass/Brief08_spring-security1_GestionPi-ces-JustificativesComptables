package com.alamane.security.service;

import com.alamane.security.dto.DocumentRequestDto;
import com.alamane.security.dto.DocumentResponseDto;
import com.alamane.security.entity.Document;
import com.alamane.security.entity.Societe;
import com.alamane.security.enums.StatutDocument;
import com.alamane.security.mapper.DocumentMapper;
import com.alamane.security.repository.DocumentRepository;
import com.alamane.security.repository.SocieteRepository;
import com.alamane.security.service.interfaces.DocumentServiceInterfece;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final SocieteRepository societeRepository;
    private final DocumentMapper documentMapper;

    @Value("${app.storage.upload-dir}")
    private String uploadDir;

    public DocumentResponseDto create(DocumentRequestDto dto, MultipartFile file) throws IOException {

        if (file == null || file.isEmpty()) {
            throw new RuntimeException("Le fichier est obligatoire.");
        }

        Societe societe = societeRepository.findById(dto.getSocieteId())
                .orElseThrow(() -> new RuntimeException("Société introuvable."));

        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String uniqueName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, uniqueName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        Document document = documentMapper.toEntity(dto);

        document.setPathFile(filePath.toString());
        document.setSociete(societe);
        document.setStatut(StatutDocument.EN_ATTENTE);

        Document saved = documentRepository.save(document);

        return documentMapper.toDto(saved);
    }
}

