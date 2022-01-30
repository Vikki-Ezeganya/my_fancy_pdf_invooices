package com.vikki.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikki.App;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = App.class)
public class MyFancyPdfInvoicesApplicationConfiguration {

    @Bean
    public ObjectMapper ObjectMapper() {
        return new ObjectMapper();
    }


}
