package com.example.containertesting;

import org.testcontainers.utility.DockerImageName;

public interface Db2TestImage {
    DockerImageName DB2_IMAGE = DockerImageName.parse("ibmcom/db2:11.5.0.0a");
}
