package com.github.analuciabolico.authapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum {
    ADMIN("ADMIN"),
    TEACHER("TEACHER"),
    STUDENT("STUDENT");

    private final String role;
}
