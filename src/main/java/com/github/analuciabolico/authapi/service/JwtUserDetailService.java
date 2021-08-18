package com.github.analuciabolico.authapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.analuciabolico.authapi.repository.AccountCredentialsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JwtUserDetailService implements UserDetailsService {
    private final AccountCredentialsRepository repository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                         .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
