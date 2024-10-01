package com.example.containertesting;

import org.testcontainers.containers.Db2Container;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class AbstractContainerDatabaseTest {

    @Container
    public static Db2Container db2 = new Db2Container(Db2TestImage.DB2_IMAGE)
            .acceptLicense();
}
