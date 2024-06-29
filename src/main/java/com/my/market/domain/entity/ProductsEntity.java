package com.my.market.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "my_market", catalog = "")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_product")
    private int idProduct;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "id_category")
    private int idCategory;
    @Basic
    @Column(name = "bar_code")
    private String barCode;
    @Basic
    @Column(name = "sale_price")
    private BigDecimal salePrice;
    @Basic
    @Column(name = "stock")
    private int stock;
    @Basic
    @Column(name = "state")
    private Boolean state;
    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id_category", nullable = false, insertable = false, updatable = false)
    private CategoriesEntity categoriesByIdCategory;
    @OneToMany(mappedBy = "productsByIdProduct")
    private List<PurchaseProductsEntity> purchaseProductsByIdProduct;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

        ProductsEntity that = (ProductsEntity) o;

        if (idProduct != that.idProduct) return false;
        if (idCategory != that.idCategory) return false;
        if (stock != that.stock) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(barCode, that.barCode)) return false;
        if (!Objects.equals(salePrice, that.salePrice)) return false;
        if (!Objects.equals(state, that.state)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProduct;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + idCategory;
        result = 31 * result + (barCode != null ? barCode.hashCode() : 0);
        result = 31 * result + (salePrice != null ? salePrice.hashCode() : 0);
        result = 31 * result + stock;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    public CategoriesEntity getCategoriesByIdCategory() {
        return categoriesByIdCategory;
    }

    public void setCategoriesByIdCategory(CategoriesEntity categoriesByIdCategory) {
        this.categoriesByIdCategory = categoriesByIdCategory;
    }

    public List<PurchaseProductsEntity> getPurchaseProductsByIdProduct() {
        return purchaseProductsByIdProduct;
    }

    public void setPurchaseProductsByIdProduct(List<PurchaseProductsEntity> purchaseProductsByIdProduct) {
        this.purchaseProductsByIdProduct = purchaseProductsByIdProduct;
    }
}
