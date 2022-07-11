package com.itransition.appusercollection.entity;

import com.itransition.appusercollection.entity.enums.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ElementCollection(targetClass = Permission.class,fetch = FetchType.LAZY)
    @Column(name = "permissions", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions;

    public Role(String roleName, List<Permission> permissions) {
        this.name = roleName;
        this.permissions = permissions;
    }
}