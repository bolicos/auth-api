package com.github.analuciabolico.authapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Order(2)
@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Value("${documentation.swagger.enabled:false}")
    private boolean enableSwagger;

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
    public void configure(final WebSecurity web) throws Exception {
        if (enableSwagger) {
            web.ignoring().antMatchers("/v2/api-docs", "/v3/api-docs", "/swagger-resources/**", "/swagger-ui/**",
                    "/swagger-resources/configuration/ui", "/swagger-resources",
                    "/swagger-resources/configuration/security", "/swagger-ui.html", "/webjars/**");
        }
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        if (enableSwagger) {
            registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
            registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
    }
}
