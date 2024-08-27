package com.example.PenjualanTiket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PenjualanTiket.Model.TicketSale;
import com.example.PenjualanTiket.Repository.TicketSaleRepository;

@Service
public class TicketSaleService {

    @Autowired
    private TicketSaleRepository ticketSaleRepository;

    public List<TicketSale> getAllTicketSales() {
        return ticketSaleRepository.findAll();
    }

    public TicketSale getTicketSaleById(Long id) {
        return ticketSaleRepository.findById(id).orElse(null);
    }

    public TicketSale saveTicketSale(TicketSale ticketSale) {
        return ticketSaleRepository.save(ticketSale);
    }

    public void deleteTicketSale(Long id) {
        ticketSaleRepository.deleteById(id);
    }
}
