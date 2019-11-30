package org.boaboa.economy.config;

import org.boaboa.economy.vo.EndpointVO;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.boaboa.economy.vo.EndpointVO.VERSION_1;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api(BuildProperties buildProperties) {
        return new Docket(SWAGGER_2)
                .apiInfo(apiInfo(buildProperties))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant(VERSION_1 + "/**"))
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo(BuildProperties buildProperties) {
        return new ApiInfoBuilder()
                .description("Data source indicadores economicos")
                .title(buildProperties.getName())
                .version(buildProperties.getVersion())
                .build();
    }
}
