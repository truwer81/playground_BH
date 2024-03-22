package com.example.demo;

import com.example.openapi.localizations.LocalizationsApi;
import com.example.openapi.localizations.model.Localization;
import com.example.openapi.localizations.model.LocalizationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/localizations")
public class LocalizationController implements LocalizationsApi {
//    @GetMapping("/localizations")
//    public LocalizationDTO get() {
//        LocalizationDTO localizationDTO = new LocalizationDTO();
//        localizationDTO.setName("Slupsk");
//        return localizationDTO;
//    }

    //pobiera listę lokalizacji
    @GetMapping
    public ResponseEntity<List<LocalizationDTO>> getAllLocalizations() {
        LocalizationDTO localizationDTO = new LocalizationDTO();
        localizationDTO.setName("Słupsk");
        List<LocalizationDTO> localizations = new ArrayList<>();
        localizations.add(localizationDTO);
        return ResponseEntity.ok(localizations);
    }

    // Tworzy nową lokalizację
    @PostMapping
    public ResponseEntity<LocalizationDTO> createLocalization(@RequestBody LocalizationDTO localizationDTO) {
        LocalizationDTO createdLocalization = new LocalizationDTO();
        createdLocalization.setName(localizationDTO.getName());
        return new ResponseEntity<>(createdLocalization, HttpStatus.CREATED);
    }

    // Pobiera lokalizację po ID
    @GetMapping("/{id}")
    public ResponseEntity<LocalizationDTO> getLocalizationById(@PathVariable Long id) {
        LocalizationDTO localizationDTO = new LocalizationDTO();
        localizationDTO.setName("Słupsk");
        return ResponseEntity.ok(localizationDTO);
    }


//    @Override
//    public ResponseEntity<List<Localization>> localizationsGet() throws Exception {
//        return ResponseEntity.status(200).body((List<Localization>) new LocalizationDTO("Słupsk"));
//    }

    @Override
    public ResponseEntity<List<LocalizationDTO>> localizationsGet() throws Exception {
        LocalizationDTO localizationDTO = new LocalizationDTO("Słupsk");
        List<LocalizationDTO> localizationsList = new ArrayList<>();
        localizationsList.add(localizationDTO);
        return ResponseEntity.ok(localizationsList);
    }

}
