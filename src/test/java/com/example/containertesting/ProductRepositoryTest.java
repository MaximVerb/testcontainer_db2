
package com.example.containertesting;

import com.example.containertesting.repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@Import({AbstractContainerDatabaseTest.class})
public class ProductRepositoryTest extends AbstractContainerDatabaseTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DataSource dataSource; // Inject the DataSource to get the database connection

    @Test
    void shouldGetAllProducts() {
        var products = productRepository.findAll();
        assertEquals(3, products.size());
    }

    @Test
    void checkExistenceTable() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            // Specify the schema and the table name to search for
            ResultSet tables = metaData.getTables(null, null, "PRODUCTS", null);

            // Check if the table exists by verifying the ResultSet is not empty
            assertTrue(tables.next(), "The PRODUCTS table should exist");
        }
    }

}

