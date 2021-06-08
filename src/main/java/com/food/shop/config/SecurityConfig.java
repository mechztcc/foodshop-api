package com.food.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private static final String[] PUBLIC_MATHERS = {
        "/h2-console/**",
        // "/produtos/**",
        // "/categorias/**",
    };

    private static final String[] PUBLIC_MATHERS_GET = {
        "/produtos/**",
        "/categorias/**",
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.csrf().disable();
        http.headers().frameOptions().disable();

        // this way only GET its allowed to no auth clients
        http.authorizeRequests().antMatchers(HttpMethod.GET, PUBLIC_MATHERS_GET).permitAll().anyRequest().authenticated();
        // http.authorizeRequests().antMatchers(PUBLIC_MATHERS).permitAll().anyRequest().authenticated();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
