package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Please see the README for more information.
 */
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    private static final String JDBC_URL = "jdbc:postgresql:mydb";

    private final Connection connection;

    public App(Connection connection) {
        this.connection = connection;
    }

    public static void main(String... args) throws SQLException {
        var connection = DriverManager.getConnection(JDBC_URL, "postgres", null);
        var app = new App(connection);

        var observation = app.selectAnObservation();
        log.info("Found this observation: {}", observation);
    }

    private static final String SQL = "SELECT description, notes FROM myschema.observations limit 1";

    public Observation selectAnObservation() throws SQLException {
        try (var stmt = connection.createStatement();
             var rs = stmt.executeQuery(SQL)) {

            rs.next();
            var description = rs.getString("description");
            var notes = (String[]) rs.getArray("notes").getArray();
            return new Observation(description, Arrays.asList(notes));
        }
    }
}
