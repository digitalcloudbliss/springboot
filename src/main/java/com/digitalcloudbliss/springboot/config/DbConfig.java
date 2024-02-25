package com.digitalcloudbliss.springboot.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    private final Environment env;

    public DbConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource dataSource() {

        return DataSourceBuilder
                .create()
                .url(env.getProperty("database.url"))
                .username(env.getProperty("database.username"))
                .password(env.getProperty("database.password"))
                .driverClassName(env.getProperty("database.driver"))
                .build();
    }
}
