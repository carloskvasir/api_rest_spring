package com.api.livros.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API REST de Controle de Livros")
                        .version("1.0.0")
                        .description("Documentação interativa da API de Controle de Livros (Trabalho 1).")
                        .contact(new Contact()
                                .name("Carlos Kvasir")
                                .url("https://carloskvasir.dev")
                                .email("gpg@kvasir.dev"))
                        .license(new License()
                                .name("MPL 2.0")
                                .url("https://www.mozilla.org/en-US/MPL/2.0/")));
    }
}
