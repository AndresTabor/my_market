package com.my.market.domain.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "purchases", schema = "my_market")
public class PurchasesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_purchase")
    private int idPurchase;
    @Basic
    @Column(name = "id_client")
    private int idClient;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "payment_method")
    private String paymentMethod;
    @Basic
    @Column(name = "comment")
    private String comment;
    @Basic
    @Column(name = "state")
    private String state;
    @OneToMany(mappedBy = "purchasesByIdPurchase")
    private List<PurchaseProductsEntity> purchaseProductsByIdPurchase;
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id_client", nullable = false, insertable = false,updatable = false)
    private ClientsEntity clientsByIdClient;

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchasesEntity that = (PurchasesEntity) o;

        if (idPurchase != that.idPurchase) return false;
        if (idClient != that.idClient) return false;
        if (!Objects.equals(date, that.date)) return false;
        if (!Objects.equals(paymentMethod, that.paymentMethod))
            return false;
        if (!Objects.equals(comment, that.comment)) return false;
        return Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        int result = idPurchase;
        result = 31 * result + idClient;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    public List<PurchaseProductsEntity> getPurchaseProductsByIdPurchase() {
        return purchaseProductsByIdPurchase;
    }

    public void setPurchaseProductsByIdPurchase(List<PurchaseProductsEntity> purchaseProductsByIdPurchase) {
        this.purchaseProductsByIdPurchase = purchaseProductsByIdPurchase;
    }

    public ClientsEntity getClientsByIdClient() {
        return clientsByIdClient;
    }

    public void setClientsByIdClient(ClientsEntity clientsByIdClient) {
        this.clientsByIdClient = clientsByIdClient;
    }
}
