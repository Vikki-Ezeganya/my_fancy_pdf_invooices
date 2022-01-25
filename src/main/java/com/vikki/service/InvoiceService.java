package com.vikki.service;

import com.vikki.model.Invoice;
import com.vikki.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

   private  List<Invoice>  invoices;
   private final UserService userService;

   public InvoiceService(UserService userService) {
       this.userService = userService;
       this.invoices  = new CopyOnWriteArrayList<>();
    }

        public Invoice create(String userId, Integer amount) {
            User user = userService.findById(userId);
            if(user == null) {
                throw new IllegalStateException();
            }


            String pdfUrl = "http://www.africau.edu/images/default/sample.pdf";
            Invoice invoice = new Invoice(userId, amount, pdfUrl );
            System.out.println(invoice);
            invoices.add(invoice);
            return invoice;
        }

        public  List<Invoice> findAll() {
            System.out.println("Hello");
            System.out.println(invoices);
            return invoices;
        }

}
