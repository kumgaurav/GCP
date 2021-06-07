package com.gkumargaur.oauth2.api;

public interface AccessTokenValidator {
    AccessTokenValidationResult validate(String accessToken);
}