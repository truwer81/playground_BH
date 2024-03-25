package com.example.demo.localization;

import com.example.openapi.localizations.model.LocalizationDTO;
import org.springframework.stereotype.Component;

import java.util.List;

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
}