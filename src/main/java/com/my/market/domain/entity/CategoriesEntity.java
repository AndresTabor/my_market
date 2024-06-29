package com.my.market.domain.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categories", schema = "my_market", catalog = "")
public class CategoriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_category")
    private int idCategory;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "state")
    private Boolean state;
    @OneToMany(mappedBy = "categoriesByIdCategory")
    private List<ProductsEntity> productsByIdCategory;

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        CategoriesEntity that = (CategoriesEntity) o;

        if (idCategory != that.idCategory) return false;
        if (state != that.state) return false;
        if (!Objects.equals(description, that.description)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategory, description, state, productsByIdCategory);
    }

    public List<ProductsEntity> getProductsByIdCategory() {
        return productsByIdCategory;
    }

    public void setProductsByIdCategory(List<ProductsEntity> productsByIdCategory) {
        this.productsByIdCategory = productsByIdCategory;
    }
}
