package com.ghale.services.room.roomService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2 //For Documentation
@EnableDiscoveryClient //Instance currently registered with Eureka .so who ever have access to Eureka can use Room service
public class RoomServiceApplication {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Room").select()
                .apis(RequestHandlerSelectors.basePackage("com.ghale.services.room.roomService"))
                .paths(any()).build().apiInfo(new ApiInfo("Room Services",
                        "A set of services to provide data access to rooms", "1.0.0", null,
                        new Contact("Roshan Ghale", "https://www.linkedin.com/in/roshan-ghale-2a2088b8/", "Roshan.ghale.rg@gmail.com"),null, null));
    }
    public static void main(String[] args) {
        SpringApplication.run(RoomServiceApplication.class, args);
    }

}
