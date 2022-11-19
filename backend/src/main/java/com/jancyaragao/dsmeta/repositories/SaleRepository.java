package com.jancyaragao.dsmeta.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jancyaragao.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    
    @Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
    List<Sale> findSalesList(LocalDate min, LocalDate max);

    @Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
    Page<Sale> findSalesPage(LocalDate min, LocalDate max, Pageable pageable);

}
