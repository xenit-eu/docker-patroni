package eu.xenit.postgres;

import com.palantir.docker.compose.DockerComposeExtension;
import org.junit.jupiter.api.Test;
import java.sql.*;
import org.junit.jupiter.api.extension.RegisterExtension;

class PostgresTest {

    @RegisterExtension
    public static DockerComposeExtension docker = DockerComposeExtension.builder()
            .file("docker-compose.yml").build();

    private Connection getConnection() throws SQLException {
        Connection ret = null;
        try {
            Thread.sleep(1000 * 30);
            String connectionString = docker.containers().container("haproxy").port(5432)
                    .inFormat("jdbc:postgresql://$HOST:$EXTERNAL_PORT/postgres");
            String user = System.getProperty("postgres.username");
            String password = System.getProperty("postgres.password");
            ret = DriverManager.getConnection(connectionString, user, password);
        } finally {
            return ret;
        }
    }

    @Test
    void testConnection() throws SQLException {
        System.out.println("Executing testConnection");
        getConnection().close();
    }

    @Test
    void testReplication() {}

    @Test
    void testPromotion() {

    }

    @Test
    void testHighAvailability() {

    }
}
