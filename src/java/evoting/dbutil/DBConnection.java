/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dbutil;

/**
 *
 * @author Shrasti
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{

private static Connection conn =null;
static
{
    try {
        Class.forName("oracle.jdbc.OracleDriver");
        System.out.println("Driver loaded successfully!");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-7FKSER5:1521/xe", "evoting","password");

        }
 catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
    catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();    //close method ? of which class
            }

}
catch(SQLException ex)
{
ex.printStackTrace();
}



}


}
