package main.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import static com.google.common.base.Predicates.*;
import static springfox.documentation.builders.PathSelectors.*;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerAsConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("crud-service-swaggerui")
                .apiInfo(apiInfo())
                .select()
                .paths(postPaths())
                .build();
    }

    private Predicate<String> postPaths() {
        return or(
                regex("/operazionicrud/insert"),
                regex("/operazionicrud/update"),
                regex("/operazionicrud/delete"),
                regex("/operazionicrud/select")
        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Crud Controller API")
                .description("Crud Controller API reference for developers")
                .build();
    }

}