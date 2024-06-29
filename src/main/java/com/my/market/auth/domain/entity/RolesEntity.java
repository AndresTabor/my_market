package com.my.market.auth.domain.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "roles", schema = "my_market", catalog = "")
public class RolesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_rol")
    private int idRol;
    @Basic
    @Column(name = "name")
    private RoleName name;
    @OneToMany(mappedBy = "rolesByIdRol")
    private Collection<UsersEntity> usersByIdRol;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesEntity that = (RolesEntity) o;

        if (idRol != that.idRol) return false;
        if (!Objects.equals(name, that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRol;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<UsersEntity> getUsersByIdRol() {
        return usersByIdRol;
    }

    public void setUsersByIdRol(Collection<UsersEntity> usersByIdRol) {
        this.usersByIdRol = usersByIdRol;
    }
}
