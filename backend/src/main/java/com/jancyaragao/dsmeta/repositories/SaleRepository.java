package com.jancyaragao.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jancyaragao.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    
}
