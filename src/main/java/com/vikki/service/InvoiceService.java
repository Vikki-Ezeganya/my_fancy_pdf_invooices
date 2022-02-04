package com.vikki.service;

import com.vikki.model.Invoice;
import com.vikki.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

       private  List<Invoice>  invoices = new CopyOnWriteArrayList<>();

       private final UserService userService;
       private String cdnUrl;

       @Autowired
        public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
            this.userService = userService;
            this.cdnUrl = cdnUrl;
        }

        @PostConstruct
        public void init() {
            System.out.println("Fetching PDF Template from S3...");
            // TODO download from s3 and save locally
        }

        @PreDestroy
        public void shutdown() {
            System.out.println("Deleting downloaded templates...");
            // TODO actual deletion of PDFs
        }

        public Invoice create(String userId, Integer amount) {
            User user = userService.findById(userId);
            if(user == null) {
                throw new IllegalStateException();
            }


//            String pdfUrl = "http://www.africau.edu/images/default/sample.pdf";
            Invoice invoice = new Invoice(userId, amount, cdnUrl + "/images/default/sample.pdf" );
            invoices.add(invoice);
            return invoice;
        }

        public  List<Invoice> findAll() {
            return invoices;
        }


}
