package com.my.market.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class PurchaseProductsEntityPK implements Serializable {
    @Column(name = "id_purchase")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPurchase;
    @Column(name = "id_product")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseProductsEntityPK that = (PurchaseProductsEntityPK) o;

        if (idPurchase != that.idPurchase) return false;
        if (idProduct != that.idProduct) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPurchase;
        result = 31 * result + idProduct;
        return result;
    }
}
