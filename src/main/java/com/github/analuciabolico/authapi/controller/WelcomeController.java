package com.github.analuciabolico.authapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WelcomeController {

    @GetMapping
    public ResponseEntity<String> base() {
        return ResponseEntity.ok("URL BASE!");
    }

    @GetMapping(path = "/api/home")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Seja bem vindes ao Sitema!!");
    }
}
