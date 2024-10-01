package com.example.containertesting;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataConfig {

    @Bean
    protected DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(AbstractContainerDatabaseTest.db2.getJdbcUrl());
        hikariConfig.setUsername(AbstractContainerDatabaseTest.db2.getUsername());
        hikariConfig.setPassword(AbstractContainerDatabaseTest.db2.getPassword());
        hikariConfig.setDriverClassName(AbstractContainerDatabaseTest.db2.getDriverClassName());
        hikariConfig.setConnectionTimeout(2000L);
        hikariConfig.setMaximumPoolSize(5);
        return new HikariDataSource(hikariConfig);
    }
}
