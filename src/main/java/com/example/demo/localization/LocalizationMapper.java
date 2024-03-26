package com.example.demo.localization;

import com.example.openapi.localizations.model.LocalizationDTO;
import com.example.openapi.localizations.model.PageOfLocalizationDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocalizationMapper {

    public LocalizationDTO asDTO(Localization localization) {
        return new LocalizationDTO(
                localization.getId(),
                localization.getName()
        );
    }

    public List<LocalizationDTO> asDTO(List<Localization> localizations) {
        return localizations.stream()
                .map(this::asDTO)
                .toList();
    }

    public Page<LocalizationDTO> asDTO(Page<Localization> localizations) {
        return localizations.map(this::asDTO);
    }

    public PageOfLocalizationDTO asPageDTO(Page<Localization> localizationsPage) {
        var content = localizationsPage.getContent().stream()
                .map(this::asDTO) // Zakładając, że asDTO to metoda mapująca pojedynczą encję na DTO.
                .collect(Collectors.toList());
        return new PageOfLocalizationDTO(
                content,
                localizationsPage.getTotalPages(),
                (int) localizationsPage.getTotalElements(),
                localizationsPage.getSize(),
                localizationsPage.getNumber()
        );
    }
}