/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseIrwan.Dao;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Suga
 */
public class Connection {
    private final String url = "jdbc:mysql://localhost/pbo_2401093018";
    private final String username = "root";
    private final String password = "";
    
    public java.sql.Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
    
    public static void main(String[] args){
        Connection connect = new Connection();
        
        try {
            connect.getConnection();
            JOptionPane.showMessageDialog(null, "Koneksi Ok!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex.getMessage());
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
