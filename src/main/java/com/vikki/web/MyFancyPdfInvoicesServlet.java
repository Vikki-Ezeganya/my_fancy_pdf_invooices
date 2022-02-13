package com.vikki.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikki.context.MyFancyPdfInvoicesApplicationConfiguration;
import com.vikki.model.Invoice;
import com.vikki.service.InvoiceService;
import com.vikki.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFancyPdfInvoicesServlet extends HttpServlet {
    private UserService userService;
    private InvoiceService invoiceService;
    private ObjectMapper objectMapper;


    @Override
    public void init() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyFancyPdfInvoicesApplicationConfiguration.class);

        ctx.registerShutdownHook();


        this.invoiceService = ctx.getBean(InvoiceService.class);
        this.objectMapper = ctx.getBean(ObjectMapper.class);
        this.userService = ctx.getBean(UserService.class);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/")) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(
                    "<html>\n" +
                            "<body>\n" +
                            "<h1>Hello World</h1>\n" +
                            "<p>This is my very first, embedded Tomcat, HTML Page!</p>\n" +
                            "</body>\n" +
                            "</html>");

        } else if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
            response.setContentType("application/json; charset=UTF-8");
            var invoices = this.invoiceService.findAll();
            var invoicesAsJson = this.objectMapper.writeValueAsString(invoices);

            response.getWriter().print(invoicesAsJson);
        }
    }

    @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        if(request.getRequestURI().equalsIgnoreCase("/invoices")) {
            var userId = request.getParameter("user_id");
            var amount = Integer.parseInt(request.getParameter("amount"));

            Invoice invoice  = this.invoiceService.create(userId, amount);

            response.setContentType("application/json; charset=UTF-8");
            String json = this.objectMapper.writeValueAsString(invoice);
            response.getWriter().print(json);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }

}
