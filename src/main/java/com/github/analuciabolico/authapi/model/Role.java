package com.github.analuciabolico.authapi.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.github.analuciabolico.authapi.model.enums.RoleEnum;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ROLES", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_NAME_TABLE_ROLES", columnNames = { "name" }) })
public class Role implements GrantedAuthority {

    @Id
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @Override
    public String getAuthority() {
        return this.name.getRole();
    }
}
