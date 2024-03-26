package com.example.demo.localization;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocalizationService {

    private final LocalizationRepository localizationRepository;

    public Localization createLocalization(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nieprawidłowa nazwa lokalizacji: " + name);
        }
        var localization = new Localization(null, name);
        return localizationRepository.save(localization);
    }

    public Page<Localization> getAllLocalizations(Pageable pageable) {
        return localizationRepository.findAll(pageable);
    }

    public Localization getLocalization(Long id) {
        return localizationRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nie ma lokalizacji o id: " + id));
    }

}
