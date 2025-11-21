package com.alamane.security.controller;

import com.alamane.security.dto.DocumentRequestDto;
import com.alamane.security.dto.DocumentResponseDto;
import com.alamane.security.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    public ResponseEntity<DocumentResponseDto> createDocument(
            @RequestPart("document") DocumentRequestDto dto,
            @RequestPart("file") MultipartFile file) {

        DocumentResponseDto response = documentService.createDocument(dto, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
