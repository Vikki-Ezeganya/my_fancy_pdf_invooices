package com.vikki.web;

import com.vikki.model.Invoice;
import com.vikki.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyFancyPdfInvoicesController {

    private InvoiceService invoiceService;

    public MyFancyPdfInvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    @ResponseBody
    public List<Invoice> getAllInvoices () {

        return invoiceService.findAll();

    }

    @PostMapping("/invoices/{userId}/{amount}")
    public Invoice createInvoice(@PathVariable String userId, @PathVariable Integer amount ) {
        return invoiceService.create(userId, amount);
    }

}
