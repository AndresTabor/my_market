package com.my.market.auth.domain.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users", schema = "my_market", catalog = "")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user")
    private int idUser;
    @Basic
    @Column(name = "user_name")
    private String userName;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "enabled")
    private Boolean enabled;
    @Basic
    @Column(name = "id_rol")
    private int idRol;
    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false, insertable = false, updatable = false)
    private RolesEntity rolesByIdRol;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (idUser != that.idUser) return false;
        if (enabled != that.enabled) return false;
        if (idRol != that.idRol) return false;
        if (!Objects.equals(userName, that.userName)) return false;
        if (!Objects.equals(password, that.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, userName, password, enabled, idRol, rolesByIdRol);
    }

    public RolesEntity getRolesByIdRol() {
        return rolesByIdRol;
    }

    public void setRolesByIdRol(RolesEntity rolesByIdRol) {
        this.rolesByIdRol = rolesByIdRol;
    }
}
