package shitul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    public Connection c;
    public Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?useSSL=false&serverTimezone=UTC", "root", "shitul");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
