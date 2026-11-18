package com.example.laboratoire_medicale.dao;

import com.example.laboratoire_medicale.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findByMagasin(String magasin);

    List<Stock> findByProduit(String produit);

    List<Stock> findByMagasinAndProduit(String magasin, String produit);
}
