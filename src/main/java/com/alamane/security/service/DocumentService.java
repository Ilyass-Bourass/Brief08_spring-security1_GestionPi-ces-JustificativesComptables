package com.alamane.security.service;

import com.alamane.security.dto.DocumentRequestDto;
import com.alamane.security.dto.DocumentResponseDto;
import com.alamane.security.entity.Document;
import com.alamane.security.mapper.DocumentMapper;
import com.alamane.security.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    private final FileStorageService fileStorageService;

    public DocumentResponseDto createDocument(DocumentRequestDto dto, MultipartFile file) {
        String filename = fileStorageService.storeFile(file);

        Document document = documentMapper.toEntity(dto);
        document.setPathFile(filename);

        Document saved = documentRepository.save(document);

        return documentMapper.toDto(saved);
    }
}
