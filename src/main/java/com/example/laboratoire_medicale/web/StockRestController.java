package com.example.laboratoire_medicale.web;

import com.example.laboratoire_medicale.entities.Stock;
import com.example.laboratoire_medicale.services.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockRestController {

    private final StockService stockService;

    public StockRestController(StockService stockService) {
        this.stockService = stockService;
    }

    // GET /api/stocks
    @GetMapping
    public ResponseEntity<List<Stock>> getAll() {
        return ResponseEntity.ok(stockService.findAll());
    }

    // GET /api/stocks/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getById(@PathVariable Long id) {
        return stockService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/stocks/magasin/{magasin}
    @GetMapping("/magasin/{magasin}")
    public ResponseEntity<List<Stock>> getByMagasin(@PathVariable String magasin) {
        return ResponseEntity.ok(stockService.findByMagasin(magasin));
    }

    // GET /api/stocks/produit/{produit}
    @GetMapping("/produit/{produit}")
    public ResponseEntity<List<Stock>> getByProduit(@PathVariable String produit) {
        return ResponseEntity.ok(stockService.findByProduit(produit));
    }

    // GET /api/stocks/search?magasin=...&produit=...
    @GetMapping("/search")
    public ResponseEntity<List<Stock>> getByMagasinAndProduit(
            @RequestParam String magasin,
            @RequestParam String produit) {
        return ResponseEntity.ok(stockService.findByMagasinAndProduit(magasin, produit));
    }

    // POST /api/stocks
    @PostMapping
    public ResponseEntity<Stock> create(@RequestBody Stock stock) {
        Stock saved = stockService.save(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // PUT /api/stocks/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Stock> update(@PathVariable Long id, @RequestBody Stock stock) {
        try {
            Stock updated = stockService.update(id, stock);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/stocks/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            stockService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
