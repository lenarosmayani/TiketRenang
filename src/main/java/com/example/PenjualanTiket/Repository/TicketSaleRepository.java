package com.example.PenjualanTiket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PenjualanTiket.Model.TicketSale;


@Repository
public interface TicketSaleRepository extends JpaRepository<TicketSale, Long> {
}
