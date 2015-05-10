/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

/**
 *
 * @author sourav
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JConn {
    public static Connection dbconnection() {
        Connection newconn = null;
        try {
            Class.forName("org.postgresql. Driver");
            newconn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/sms", "postgres", "password");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JConn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newconn;
    }
}
