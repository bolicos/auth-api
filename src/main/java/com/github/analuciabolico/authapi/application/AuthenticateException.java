package com.github.analuciabolico.authapi.application;

public class AuthenticateException extends RuntimeException {
    public AuthenticateException(final String errorMessage, final Throwable err) {
        super(errorMessage, err);
    }

    public AuthenticateException(final String errorMessage) {
        super(errorMessage);
    }
}
