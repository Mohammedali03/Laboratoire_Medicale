package com.example.laboratoire_medicale.services;

import com.example.laboratoire_medicale.entities.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {

    Stock save(Stock stock);

    Stock update(Long id, Stock stock);

    Optional<Stock> findById(Long id);

    List<Stock> findAll();

    List<Stock> findByMagasin(String magasin);

    List<Stock> findByProduit(String produit);

    List<Stock> findByMagasinAndProduit(String magasin, String produit);

    void deleteById(Long id);
}
