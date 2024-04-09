package com.projeto.praticando.util;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfg {

    //Classe que configura o swagger(SpringDoc). título, versão e descrição da aplicação e etc...
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(new Info()
                .title("Gestão de pessoas")
                .version("1.0.0")
                .description("Sistema de gestão de pessoas"));
    }
}
