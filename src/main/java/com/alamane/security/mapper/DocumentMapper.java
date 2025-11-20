package com.alamane.security.mapper;

import com.alamane.security.dto.DocumentRequestDto;
import com.alamane.security.dto.DocumentResponseDto;
import com.alamane.security.entity.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "societeId", target = "societe.id")
    Document toEntity(DocumentRequestDto dto);

    @Mapping(source = "societe.id", target = "societeId")
    @Mapping(source = "societe.raisonSociale", target = "societeRaisonSociale")
    DocumentResponseDto toDto(Document document);
}
