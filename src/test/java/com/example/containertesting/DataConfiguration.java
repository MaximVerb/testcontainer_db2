//package com.example.containertesting;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import jakarta.annotation.PostConstruct;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.testcontainers.containers.Db2Container;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataConfiguration {
//
//    @Bean
//    public Db2Container db2() {
//        Db2Container db2Container = new Db2Container(Db2TestImage.DB2_IMAGE).acceptLicense();
//        db2Container.start();  // Ensure that the container starts
//        return db2Container;
//    }
//
//    @Bean
//    @DependsOn("db2")
//    public DataSource dataSource(Db2Container db2) {
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl(db2.getJdbcUrl());
//        hikariConfig.setUsername(db2.getUsername());
//        hikariConfig.setPassword(db2.getPassword());
//        hikariConfig.setDriverClassName(db2.getDriverClassName());  // Use the correct DB2 driver class
//        return new HikariDataSource(hikariConfig);
//    }
//}
