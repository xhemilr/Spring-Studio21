package com.studio21.seucrityconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("besim").password("{noop}besim123").roles("USER")
                .and()
                .withUser("xhemil").password("{noop}xhemil123").roles("USER","ADMIN");

    }

    // Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/service").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/service").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/service").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/service").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/config").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/config").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/config").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/config").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
