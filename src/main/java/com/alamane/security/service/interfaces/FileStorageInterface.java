package com.alamane.security.service.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageInterface {
    String storeFile(MultipartFile file);
}
