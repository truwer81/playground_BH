package com.example.demo.localization;

import com.example.openapi.localizations.LocalizationsApi;
import com.example.openapi.localizations.model.LocalizationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocalizationController implements LocalizationsApi {

    private final LocalizationService localizationService;

    // todo handle exceptions -> create a class annotated with @RestControllerAdvice

    @Override
    public ResponseEntity<List<LocalizationDTO>> localizationsGet() throws Exception {
        // todo use 'var'
        List<LocalizationDTO> localizationsDTO = localizationService.localizationsGet();
        return ResponseEntity.status(HttpStatus.OK)
                .body(localizationsDTO);
    }

    @Override
    public ResponseEntity<LocalizationDTO> localizationsIdGet(@PathVariable Long id) throws Exception { // todo remove @PathVariable - it is unnecessary
        // todo add pagination https://www.baeldung.com/rest-api-pagination-in-spring
        LocalizationDTO localizationDTO = localizationService.localizationsIdGet(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(localizationDTO);
    }

    @Override
    public ResponseEntity<LocalizationDTO> localizationsPost(LocalizationDTO localizationDTO) throws Exception { // todo maxLength=50 in openid -> exception -> @RestControllerAdvice -> 400
        LocalizationDTO createdLocalization = localizationService.localizationsPost(localizationDTO.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLocalization);
    }
}
