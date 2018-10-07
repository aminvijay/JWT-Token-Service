package com.vijay.jwt.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	// https://www.baeldung.com/rest-api-spring-oauth2-angularjs
	// https://www.baeldung.com/spring-security-oauth-2-verify-claims

	@Autowired	
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
    public void configure(ClientDetailsServiceConfigurer clients) 
      throws Exception { 		
        clients
        	.inMemory()
        	.withClient("vijay-client-id")
        	.secret(passwordEncoder.encode("vijay-client-secret"))
        	//.secret(passwordEncoder.encode("XY7kmzoNzl1001"))
        	//.secret("vijay-client-secret")
        	.authorizedGrantTypes("client_credentials", "password","authorization_code","refresh_token")
        	.scopes("read","write")
        	.resourceIds("vijay-resource-ids")
        	.accessTokenValiditySeconds(300);        
    }
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		TokenEnhancerChain tokenEnhancer = new TokenEnhancerChain();
		tokenEnhancer.setTokenEnhancers(Arrays.asList(accessTokenConverter));
		
		endpoints.tokenStore(tokenStore)
			.accessTokenConverter(accessTokenConverter)
			.tokenEnhancer(tokenEnhancer)
			.authenticationManager(authenticationManager);
		
	}

}
