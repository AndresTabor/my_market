package com.my.market.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "purchase_products", schema = "my_market", catalog = "")
@IdClass(PurchaseProductsEntityPK.class)
public class PurchaseProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_purchase")
    private int idPurchase;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_product")
    private int idProduct;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "total")
    private BigDecimal total;
    @Basic
    @Column(name = "state")
    private Boolean state;
    @ManyToOne
    @JoinColumn(name = "id_purchase", referencedColumnName = "id_purchase", nullable = false, insertable = false, updatable = false)
    private PurchasesEntity purchasesByIdPurchase;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", nullable = false, insertable = false,updatable = false)
    private ProductsEntity productsByIdProduct;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseProductsEntity that = (PurchaseProductsEntity) o;

        if (idPurchase != that.idPurchase) return false;
        if (idProduct != that.idProduct) return false;
        if (!Objects.equals(quantity, that.quantity)) return false;
        if (!Objects.equals(total, that.total)) return false;
        if (!Objects.equals(state, that.state)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPurchase;
        result = 31 * result + idProduct;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    public PurchasesEntity getPurchasesByIdPurchase() {
        return purchasesByIdPurchase;
    }

    public void setPurchasesByIdPurchase(PurchasesEntity purchasesByIdPurchase) {
        this.purchasesByIdPurchase = purchasesByIdPurchase;
    }

    public ProductsEntity getProductsByIdProduct() {
        return productsByIdProduct;
    }

    public void setProductsByIdProduct(ProductsEntity productsByIdProduct) {
        this.productsByIdProduct = productsByIdProduct;
    }
}
