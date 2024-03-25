package com.example.demo.localization;

import com.example.openapi.localizations.LocalizationsApi;
import com.example.openapi.localizations.model.LocalizationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/localizations")
public class LocalizationController implements LocalizationsApi {
    private final LocalizationService localizationService;

    @Override
    public ResponseEntity<List<LocalizationDTO>> localizationsGet() throws Exception {
        List<LocalizationDTO> localizationsDTO = localizationService.localizationsGet();
        return ResponseEntity.status(HttpStatus.OK)
                .body(localizationsDTO);
    }

    @Override
    public ResponseEntity<LocalizationDTO> localizationsIdGet(@PathVariable Long id) throws Exception {
        LocalizationDTO localizationDTO = localizationService.localizationsIdGet(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(localizationDTO);
    }

    @Override
    public ResponseEntity<LocalizationDTO> localizationsPost(LocalizationDTO localizationDTO) throws Exception {
        LocalizationDTO createdLocalization = localizationService.localizationsPost(localizationDTO.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLocalization);
    }




//    @GetMapping("/localizations")
//    public LocalizationDTO get() {
//        LocalizationDTO localizationDTO = new LocalizationDTO();
//        localizationDTO.setName("Slupsk");
//        return localizationDTO;
//    }

//    //pobiera listę lokalizacji
//    @GetMapping
//    public ResponseEntity<List<LocalizationDTO>> getAllLocalizations() {
//        LocalizationDTO localizationDTO = new LocalizationDTO();
//        localizationDTO.setName("Słupsk");
//        List<LocalizationDTO> localizations = new ArrayList<>();
//        localizations.add(localizationDTO);
//        return ResponseEntity.ok(localizations);
//    }
//
//    // Tworzy nową lokalizację
//    @PostMapping
//    public ResponseEntity<LocalizationDTO> createLocalization(@RequestBody LocalizationDTO localizationDTO) {
//        LocalizationDTO createdLocalization = new LocalizationDTO();
//        createdLocalization.setName(localizationDTO.getName());
//        return new ResponseEntity<>(createdLocalization, HttpStatus.CREATED);
//    }
//
//    // Pobiera lokalizację po ID
//    @GetMapping("/{id}")
//    public ResponseEntity<LocalizationDTO> getLocalizationById(@PathVariable Long id) {
//        LocalizationDTO localizationDTO = new LocalizationDTO();
//        localizationDTO.setName("Słupsk");
//        return ResponseEntity.ok(localizationDTO);
//    }


//    @Override
//    public ResponseEntity<List<Localization>> localizationsGet() throws Exception {
//        return ResponseEntity.status(200).body((List<Localization>) new LocalizationDTO("Słupsk"));
//    }

//    @Override
//    public ResponseEntity<List<Localization>> localizationsGet() throws Exception {
//        LocalizationDTO localizationDTO = new LocalizationDTO("Słupsk");
//        List<LocalizationDTO> localizationsDTOList = new ArrayList<>();
//        localizationsDTOList.add(localizationDTO);
//        Localization localization = new Localization();
//        localization.setName(localizationDTO.getName());
//        List<Localization> localizationsList = new ArrayList<>();
//        localizationsList.add(localization);
//        return ResponseEntity.ok(localizationsList);
//    }

}
