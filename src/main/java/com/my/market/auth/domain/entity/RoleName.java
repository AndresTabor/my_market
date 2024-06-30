package com.my.market.auth.domain.entity;

import java.util.Locale;

public enum RoleName {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN"),
    ROLE_SUPPORT("SUPPORT");

    private final String name;

    RoleName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static RoleName fromName(String roleName) {
        String name = roleName.toUpperCase(Locale.ROOT);
        for (RoleName role : RoleName.values()) {
            if (role.name.equals(name)) {
                return role;
            }

        }
        throw new IllegalArgumentException("No enum constant with name " + roleName);
    }
}
