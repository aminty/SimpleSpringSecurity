package com.simple.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf->csrf.disable())
                .authorizeRequests(auth->auth
                        .antMatchers("/user").authenticated()
                        .antMatchers("/admin").authenticated()
                        .anyRequest().denyAll())
                .httpBasic().and().build();
    }


    @Bean
    PasswordEncoder passwordEncoder(){
     return    NoOpPasswordEncoder.getInstance();
    }
}
