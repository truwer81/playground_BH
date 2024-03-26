package com.example.demo.localization;

import com.example.openapi.localizations.LocalizationsApi;
import com.example.openapi.localizations.model.LocalizationDTO;
import com.example.openapi.localizations.model.PageOfLocalizationDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class LocalizationController implements LocalizationsApi {

    private final LocalizationService localizationService;
    private final LocalizationMapper localizationMapper;

    @Override
    public ResponseEntity<PageOfLocalizationDTO> localizationsGet(Integer pageNum, Integer size) {
        var page = localizationService.getAllLocalizations(pageNum, size);
        var pageDTO = localizationMapper.asPageDTO(page);
        return ResponseEntity.ok(pageDTO);
    }

    @Override
    public ResponseEntity<LocalizationDTO> localizationsIdGet(Long id) throws Exception {
        var localizationDTO = localizationService.getLocalization(id);
        if (localizationDTO == null || localizationDTO.getName().isBlank()) {
            throw new EntityNotFoundException("Lokalizacja " + id + " w bazie danych jest błędna lub pusta.");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(localizationMapper.asDTO(localizationDTO));
    }

    @Override
    public ResponseEntity<LocalizationDTO> localizationsPost(@Valid LocalizationDTO localizationDTO) throws Exception {
        if (localizationDTO.getName().length() > 50) {
            throw new IllegalArgumentException("Nazwa nie może przekraczać 50 znaków.");
        }
        var createdLocalization = localizationService.createLocalization(localizationDTO.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(localizationMapper.asDTO(createdLocalization));
    }
}
