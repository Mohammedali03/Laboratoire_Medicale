package com.example.laboratoire_medicale.services;

import com.example.laboratoire_medicale.dao.StockRepository;
import com.example.laboratoire_medicale.entities.Stock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock update(Long id, Stock stock) {
        Stock existing = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found with id: " + id));
        existing.setProduit(stock.getProduit());
        existing.setMagasin(stock.getMagasin());
        existing.setQuantity(stock.getQuantity());
        return stockRepository.save(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Stock> findById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Stock> findByMagasin(String magasin) {
        return stockRepository.findByMagasin(magasin);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Stock> findByProduit(String produit) {
        return stockRepository.findByProduit(produit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Stock> findByMagasinAndProduit(String magasin, String produit) {
        return stockRepository.findByMagasinAndProduit(magasin, produit);
    }

    @Override
    public void deleteById(Long id) {
        if (!stockRepository.existsById(id)) {
            throw new RuntimeException("Stock not found with id: " + id);
        }
        stockRepository.deleteById(id);
    }
}
