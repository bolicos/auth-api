package com.github.analuciabolico.authapi.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtResponse implements Serializable {
    private final String jwt;
}
