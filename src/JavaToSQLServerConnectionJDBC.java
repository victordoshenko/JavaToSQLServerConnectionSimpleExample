import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaToSQLServerConnectionJDBC {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:60655;databaseName=sql-ex;user=sqlex;password=simplepassword";
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM Battles";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
