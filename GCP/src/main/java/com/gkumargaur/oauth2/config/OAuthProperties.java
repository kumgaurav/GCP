/**
 * 
 */
package com.gkumargaur.oauth2.config;

/**
 * @author gkumargaur
 *
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application-oauth2-extractors-baeldung.properties")
public class OAuthProperties {
    @Value("${security.oauth2.client.client-id}")
    private String clientId;
    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;
    @Value("${security.oauth2.client.checkTokenUrl}")
    private String checkTokenUrl;
    @Value("${security.oauth2.resource.userInfoUri}")
    private String userInfoUrl;

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getCheckTokenUrl() {
        return checkTokenUrl;
    }

    public String getUserInfoUrl() {
        return userInfoUrl;
    }
}