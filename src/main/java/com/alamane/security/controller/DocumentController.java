package com.alamane.security.controller;

import com.alamane.security.dto.DocumentRequestDto;
import com.alamane.security.dto.DocumentResponseDto;
import com.alamane.security.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DocumentResponseDto> createDocument(
            @ModelAttribute DocumentRequestDto dto,
            @RequestPart("file") MultipartFile file) throws IOException {

        return ResponseEntity.ok(documentService.create(dto, file));
    }
}
