package com.tuapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration //Swagger para documentación
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tuapp.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}

// http://localhost:8081/swagger-ui/index.html : para comprobación de documentación 
/*Se cambia el puerto de 8080 a 8081 porque aparecia ocupado y generaba error*/