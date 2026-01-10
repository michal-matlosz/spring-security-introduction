package pl.umk.workshop.springintroduction.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize ->
                authorize
                        .requestMatchers(HttpMethod.GET, "/deposit/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/deposit").permitAll()
                        .anyRequest().authenticated()
        );
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
