package com.makemytrip.makemytrip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {

            public void addCorsMapping(CorsRegistry registry){
                registry.addMapping("/**") //allow all endpoints
                        .allowedOrigins("*") // allow all origins
                        .allowedMethods("GET","POST","DELETE","OPTIONS") //allow specfic HTTP methods
                        .allowedHeaders("*") // allow all headers
                        .allowCredentials(false); //disallow the credentails for safety
            }
        };

    }


}
