package com.example.laboratoire_medicale.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String produit;

    private String magasin;

    @Column(precision = 19, scale = 4)
    private BigDecimal quantity;

    public Stock() {}

    public Stock(String produit, String magasin, BigDecimal quantity) {
        this.produit = produit;
        this.magasin = magasin;
        this.quantity = quantity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProduit() { return produit; }
    public void setProduit(String produit) { this.produit = produit; }

    public String getMagasin() { return magasin; }
    public void setMagasin(String magasin) { this.magasin = magasin; }

    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }
}
