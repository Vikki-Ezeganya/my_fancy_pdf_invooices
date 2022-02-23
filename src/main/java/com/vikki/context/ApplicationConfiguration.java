package com.vikki.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikki.App;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = App.class)
@PropertySource("classpath:/application.properties")
@PropertySource(value = "classpath:/application-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
@EnableWebMvc
public class ApplicationConfiguration {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Bean
    public ObjectMapper ObjectMapper() {
        return new ObjectMapper();
    }


}