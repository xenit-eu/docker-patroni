package eu.xenit.postgres;

import org.junit.jupiter.api.Test;
import java.sql.*;

class PostgresTest {

    private Connection getConnection() throws SQLException {
        String connectionString = System.getProperty("connectionString");
        String user = System.getProperty("postgres.username");
        String password = System.getProperty("postgres.password");
        return DriverManager.getConnection(connectionString, user, password);
    }

    @Test
    void testConnection() throws SQLException {
        System.out.println("Executing testConnection");
        getConnection().close();
    }
}
