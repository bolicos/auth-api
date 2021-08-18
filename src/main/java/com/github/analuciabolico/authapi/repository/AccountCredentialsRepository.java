package com.github.analuciabolico.authapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.analuciabolico.authapi.model.AccountCredentials;

public interface AccountCredentialsRepository extends JpaRepository <AccountCredentials, String> {
    Optional<AccountCredentials> findByUsername(final String username);
}
