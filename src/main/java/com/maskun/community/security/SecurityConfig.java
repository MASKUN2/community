package com.maskun.community.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //Allow anyone to access homePage;
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry.requestMatchers("/", "home").permitAll().anyRequest().authenticated())

                //Not using formLogin. this is a BackendServer;
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.disable())

                //Not using httpBasic. this is token-based;
                .httpBasic(httpSecurityHttpBasicConfigurer -> httpSecurityHttpBasicConfigurer.disable())

                //Not using session. this is token-based;
                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                //Oauth2.0
                .oauth2Client(Customizer.withDefaults())

        //todo: Add jwt filter;
        //.addFilter()

        ;//end
        return http.build();
    }
}
