package com.example.demo;

import com.example.openapi.localizations.LocalizationsApi;
import com.example.openapi.localizations.model.LocalizationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalizationController implements LocalizationsApi {
//    @GetMapping("/localizations")
//    public LocalizationDTO get() {
//        LocalizationDTO localizationDTO = new LocalizationDTO();
//        localizationDTO.setName("Slupsk");
//        return localizationDTO;
//    }

    @Override
    public ResponseEntity<LocalizationDTO> localizationsGet() throws Exception {
        return ResponseEntity.status(200).body(new LocalizationDTO("Słupsk"));
    }
}
