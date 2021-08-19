package com.github.analuciabolico.authapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.AllArgsConstructor;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@AllArgsConstructor
public class SwaggerConfiguration implements WebMvcConfigurer {
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.github.analuciabolico.authapi")).build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("Spring Boot REST AUTH API")
                .description("\"Spring Boot REST AUTH API is the application that authentication users.\"")
                .licenseUrl("https://github.com/analuciabolico/auth-api/blob/main/LICENSE\"").version("1.0.0")
                .license("MIT License").build();
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        if (swaggerProperties.enabled) {
            registry.addResourceHandler("/h2/**");
            registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
            registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
    }

}
