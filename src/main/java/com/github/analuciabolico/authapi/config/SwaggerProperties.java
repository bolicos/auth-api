package com.github.analuciabolico.authapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.AllArgsConstructor;


@ConstructorBinding
@AllArgsConstructor
@ConfigurationProperties("documentation.swagger")
public class SwaggerProperties {
    final boolean enabled;
}