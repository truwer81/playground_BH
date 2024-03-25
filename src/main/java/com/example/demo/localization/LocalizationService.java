package com.example.demo.localization;

import com.example.openapi.localizations.model.LocalizationDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocalizationService {

    private final LocalizationRepository localizationRepository;
    private final LocalizationMapper localizationMapper;

    public LocalizationDTO localizationsPost(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nieprawidłowa nazwa lokalizacji: " + name);
        }
        var localization = new Localization(null, name);
        return localizationMapper.asDTO(localizationRepository.save(localization));
    }

    public List<LocalizationDTO> localizationsGet() {
        List<Localization> localizations = localizationRepository.findAll();
        return localizationMapper.asDTO(localizations);
    }

    public LocalizationDTO localizationsIdGet(Long id) {
        Localization localization = localizationRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Nie ma lokalizacji o id: " + id));
        return localizationMapper.asDTO(localization);
    }

}
