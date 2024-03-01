package com.praveen.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(HttpMethod.GET,"/hotels/findAllHotels").hasAnyRole("ADMIN","USER")
                                .requestMatchers(HttpMethod.GET,"/hotels/*").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET,"/hotels/viewRooms/*").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET,"/rooms/availability/*").hasAnyRole("ADMIN","USER")
                                .requestMatchers(HttpMethod.GET,"/rooms/roomById/*").hasAnyRole("ADMIN","USER")
                                .requestMatchers(HttpMethod.PUT,"/rooms/manage/*").hasAnyRole("ADMIN","USER")
                                .requestMatchers(HttpMethod.GET,"/rooms/hotelFromRoomId/*").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/hotels/update/*").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST,"/hotels/saveHotel").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST,"/hotels/addRoom/*").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST,"/rooms/saveRoom").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/rooms/deleteByRoomId/*").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/hotels/delete/*").hasRole("ADMIN"));
                http.httpBasic(Customizer.withDefaults());

                //disable cross Site request Forgery(CSRF)
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager(
                org.springframework.security.core.userdetails.User.withUsername("admin")
                        .password(passwordEncoder().encode("praveen"))
                        .roles("ADMIN")
                        .build(),
                org.springframework.security.core.userdetails.User.withUsername("user")
                        .password(passwordEncoder().encode("user123"))
                        .roles("USER")
                        .build()
        );
    }
}
