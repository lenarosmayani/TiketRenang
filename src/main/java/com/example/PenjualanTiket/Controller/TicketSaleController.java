package com.example.PenjualanTiket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PenjualanTiket.Model.TicketSale;
import com.example.PenjualanTiket.Service.TicketSaleService;


@RestController
@RequestMapping("/api/tickets")
public class TicketSaleController {

    @Autowired
    private TicketSaleService ticketSaleService;

    @GetMapping
    public ResponseEntity<List<TicketSale>> getAllTicketSales() {
        return ResponseEntity.ok(ticketSaleService.getAllTicketSales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketSale> getTicketSaleById(@PathVariable Long id) {
        TicketSale ticketSale = ticketSaleService.getTicketSaleById(id);
        if (ticketSale != null) {
            return ResponseEntity.ok(ticketSale);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<TicketSale> saveTicketSale(@RequestBody TicketSale ticketSale) {
        TicketSale savedTicketSale = ticketSaleService.saveTicketSale(ticketSale);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTicketSale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketSale(@PathVariable Long id) {
        ticketSaleService.deleteTicketSale(id);
        return ResponseEntity.noContent().build();
    }
}