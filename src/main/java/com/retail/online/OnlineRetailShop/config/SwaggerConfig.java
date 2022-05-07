package com.retail.online.OnlineRetailShop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket postApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Learn Project").apiInfo(apiInfo()).select()
                .paths(regex("/retail.*")).build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Retail Shop")
                .description("Swagger documentation")
                .termsOfServiceUrl("demo")
                .license("demo")
                .licenseUrl("").version("1.0").build();
    }
}
