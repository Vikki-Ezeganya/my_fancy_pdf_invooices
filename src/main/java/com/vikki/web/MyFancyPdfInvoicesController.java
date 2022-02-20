package com.vikki.web;

import com.vikki.dto.InvoiceDto;
import com.vikki.model.Invoice;
import com.vikki.service.InvoiceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@Validated
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

    @PostMapping("/invoices")
    public Invoice createInvoice(@RequestParam("user_id") @NotBlank String userId, @RequestParam @Min(10) @Max(100) Integer amount) {
        return invoiceService.create(userId, amount);
    }

}
