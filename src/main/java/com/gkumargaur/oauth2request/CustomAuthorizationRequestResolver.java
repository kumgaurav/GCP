/**
 * 
 */
package com.gkumargaur.oauth2request;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

public class CustomAuthorizationRequestResolver implements OAuth2AuthorizationRequestResolver {
	private static final Logger log = LoggerFactory.getLogger(CustomAuthorizationRequestResolver.class);
    private OAuth2AuthorizationRequestResolver defaultResolver;

    public CustomAuthorizationRequestResolver(ClientRegistrationRepository repo, String authorizationRequestBaseUri){
        defaultResolver = new DefaultOAuth2AuthorizationRequestResolver(repo, authorizationRequestBaseUri);
    }

    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request) {
        OAuth2AuthorizationRequest req = defaultResolver.resolve(request);
        if(req != null){
            req = customizeAuthorizationRequest(req);
        }
        return req;
    }

    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request, String clientRegistrationId) {
        OAuth2AuthorizationRequest req = defaultResolver.resolve(request, clientRegistrationId);
        if(req != null){
            req = customizeAuthorizationRequest(req);
        }
        return req;
    }

    private OAuth2AuthorizationRequest customizeAuthorizationRequest(OAuth2AuthorizationRequest req) {
        Map<String,Object> extraParams = new HashMap<String,Object>();
        extraParams.putAll(req.getAdditionalParameters()); //VIP note
        extraParams.put("test", "extra");
        log.info("here =====================");
        return OAuth2AuthorizationRequest.from(req).additionalParameters(extraParams).build();
    }

    private OAuth2AuthorizationRequest customizeAuthorizationRequest1(OAuth2AuthorizationRequest req) {
        return OAuth2AuthorizationRequest.from(req).state("xyz").build();
    }
    
    private OAuth2AuthorizationRequest customizeOktaReq(OAuth2AuthorizationRequest req) {
        Map<String,Object> extraParams = new HashMap<String,Object>();
        extraParams.putAll(req.getAdditionalParameters()); 
        extraParams.put("idp", "https://idprovider.com");
        return OAuth2AuthorizationRequest.from(req).additionalParameters(extraParams).build();
    }
}