package com.br.showme.config;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfigSwagger {

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("leonardobarrosbhz@gmail.com");
        contact.setName("LeoKashmir");

        Info info = new Info()
                .title("API - Cadastro ")
                .version("1.0")
                .contact(contact)
                .description("API para cadastrado de Colaboradores");

        return new OpenAPI().info(info);
    }

}
