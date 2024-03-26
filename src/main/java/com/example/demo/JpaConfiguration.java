package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaConfiguration {

    @Bean
    AuditorAware<Long> auditorProvider() {
        return () -> Optional.of(1L);
    }
}
