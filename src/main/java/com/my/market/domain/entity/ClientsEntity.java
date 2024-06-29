package com.my.market.domain.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clients", schema = "my_market", catalog = "")
public class ClientsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_client")
    private int idClient;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "cell_phone")
    private Integer cellPhone;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "clientsByIdClient")
    private List<PurchasesEntity> purchasesByIdClient;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Integer cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (idClient != that.idClient) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(lastName, that.lastName)) return false;
        if (!Objects.equals(cellPhone, that.cellPhone)) return false;
        if (!Objects.equals(address, that.address)) return false;
        if (!Objects.equals(email, that.email)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClient;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (cellPhone != null ? cellPhone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public List<PurchasesEntity> getPurchasesByIdClient() {
        return purchasesByIdClient;
    }

    public void setPurchasesByIdClient(List<PurchasesEntity> purchasesByIdClient) {
        this.purchasesByIdClient = purchasesByIdClient;
    }
}
