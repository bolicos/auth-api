package com.github.analuciabolico.authapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.analuciabolico.authapi.application.AuthenticateException;
import com.github.analuciabolico.authapi.model.dto.JwtResponse;
import com.github.analuciabolico.authapi.model.dto.UserRequest;
import com.github.analuciabolico.authapi.security.JwtTokenUtil;
import com.github.analuciabolico.authapi.service.JwtUserDetailService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api")
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailService jwtUserDetailService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody final UserRequest user) {

        this.authenticate(user.getUsername(), user.getPassword());
        final UserDetails userDetails = jwtUserDetailService.loadUserByUsername(user.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws AuthenticateException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticateException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticateException("INVALID_CREDENTIALS", e);
        }
    }

}
