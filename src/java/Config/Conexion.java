
package Config;

import java.sql.*;

public class Conexion {
    Connection con;
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blaze");            
        } catch (Exception e) {
            System.out.println("no se puede conectar"+e.getLocalizedMessage());
        }
    }
    public Connection getConnection(){
        return con;
    }
}
