package com.vikki.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikki.App;
import com.vikki.service.InvoiceService;
import com.vikki.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = App.class)
public class MyFancyPdfInvoicesApplicationConfiguration {

//    @Bean
//    public UserService userService() {
//        return new UserService();
//    }
//
//    @Bean
//    public InvoiceService invoiceService(UserService userService) {
//        return new InvoiceService(userService);
//    }

    @Bean
    public ObjectMapper ObjectMapper() {
        return new ObjectMapper();
    }


}
