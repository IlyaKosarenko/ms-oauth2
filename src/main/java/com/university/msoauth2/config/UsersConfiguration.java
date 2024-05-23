package com.university.msoauth2.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class UsersConfiguration {

    private final PasswordEncoder passwordEncoder;

    public UsersConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    ApplicationRunner usersRunner(UserDetailsManager userDetailsManager) {
        return args -> {
            var builder = User.builder();
            var users = Map.of(
                    "ilya", "{bcrypt}$2a$10$7aDC00HWBWHpJWjeo5CqJeWa0AfTBR6lrl7P36dy5diUJu/bZEXe.",
                    "roma", "{bcrypt}$2a$10$7aDC00HWBWHpJWjeo5CqJeWa0AfTBR6lrl7P36dy5diUJu/bZEXe.");
            users.forEach((username, password) -> {
                if (!userDetailsManager.userExists(username)) {
                    var user = builder
                            .username(username)
                            .password(password)
                            .authorities(new SimpleGrantedAuthority(Roles.CLIENT.name()))
                            .build();
                    userDetailsManager.createUser(user);
                }
            });
            var admin = Map.of("admin", "{bcrypt}$2a$10$oteVSfTNq2igCMYabv6W8eCWz47Zpb0JSrCXzeyiM5iqXE.c1izvG");
            admin.forEach((username, password) -> {
                if (!userDetailsManager.userExists(username)) {
                    var user = builder
                            .username(username)
                            .password(password)
                            .authorities(new SimpleGrantedAuthority(Roles.ADMIN.name()))
                            .build();
                    userDetailsManager.createUser(user);
                }
            });
        };
    }
}
