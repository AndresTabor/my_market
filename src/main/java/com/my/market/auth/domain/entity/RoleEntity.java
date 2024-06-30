package com.my.market.auth.domain.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles", schema = "my_market")
public class RoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_rol")
    private int idRol;
    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private RoleName name;
    @OneToMany(mappedBy = "rolesByIdRol")
    private List<UserEntity> usersByIdRol;

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

        RoleEntity that = (RoleEntity) o;

        if (idRol != that.idRol) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = idRol;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public List<UserEntity> getUsersByIdRol() {
        return usersByIdRol;
    }

    public void setUsersByIdRol(List<UserEntity> usersByIdRol) {
        this.usersByIdRol = usersByIdRol;
    }
}
