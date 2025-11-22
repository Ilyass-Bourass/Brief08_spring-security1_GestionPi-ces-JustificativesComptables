package com.alamane.security.service.interfaces;

import com.alamane.security.dto.DocumentRequestDto;
import com.alamane.security.dto.DocumentResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentServiceInterfece {
    public DocumentResponseDto create(DocumentRequestDto dto, MultipartFile file);
}
