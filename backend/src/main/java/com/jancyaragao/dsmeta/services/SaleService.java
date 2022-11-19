package com.jancyaragao.dsmeta.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jancyaragao.dsmeta.entities.Sale;
import com.jancyaragao.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
    
    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> findSales() {
        return saleRepository.findAll();
    }

    public Page<Sale> findSalesPage(String minDate, String maxDate, Pageable pageable) {
        
        LocalDate today = LocalDate.now();

        LocalDate min = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        
        return saleRepository.findSalesPage(min, max, pageable);
    }

}
