package com.jancyaragao.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jancyaragao.dsmeta.entities.Sale;
import com.jancyaragao.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping(value = "/list")
    public List<Sale> findSales() {
        return saleService.findSales();
    }

    @GetMapping(value = "/page")
    public Page<Sale> findSalesPage(@RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate, Pageable pageable) {
        return saleService.findSalesPage(minDate, maxDate, pageable);
    }

}