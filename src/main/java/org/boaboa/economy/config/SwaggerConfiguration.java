package org.boaboa.economy.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

  @Bean
  public OpenAPI springShopOpenAPI(BuildProperties buildProperties) {
    return new OpenAPI()
        .info(
            new Info()
                .title(buildProperties.getName())
                .description("Data source indicadores economicos")
                .version(buildProperties.getVersion()))
        .externalDocs(
            new ExternalDocumentation()
                .description("SpringShop Wiki Documentation")
                .url("https://springshop.wiki.github.org/docs"));
  }
}
