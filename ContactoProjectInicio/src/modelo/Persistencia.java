/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joni-
 */
public class Persistencia {
    private Connection conn;
    
    private Persistencia(){
        try {
            this.conn = createConnection();
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Connection createConnection() throws SQLException, ClassNotFoundException{
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/miniagenda?serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
    
    public Connection getConn(){
        return this.conn;
    }
    
    
    void closeConection() throws SQLException{
        this.conn.close();
    }
    
    Statement createStatement() throws SQLException{
        return this.conn.createStatement();
    }
}
