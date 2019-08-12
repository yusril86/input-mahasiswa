/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KoneksiMysql {
    private static Connection conn;
//    private String driverName = "com.mysql.jdbc.Driver";
//    private String jdbc = "jdbc:mysql://";
//    private String host = "localhost:";
//    private String port = "3306/";
//    private String database = "web_db";
//    private String url = jdbc + host + port + database;
//    private String username = "root";
//    private String password = "";
//    public Connection getKoneksi() throws SQLException {
//        if (connect == null) {
//            try {
//                Class.forName(driverName);
//                System.out.println("Class Driver Ditemukan");
//                try {
//                    connect = DriverManager.getConnection(url,username,password);
//                    System.out.println("Koneksi Database Sukses");
//                } catch (SQLException e) {
//                    System.out.println("Koneksi DatabaseGagal : "+e);
//                    System.exit(0);
//                }
//            } catch (ClassNotFoundException e) {
//                System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : "+e);
//                System.exit(0);
//            }
//        }
//        return connect;
//    }
    
    
    public static Connection getKoneksi(){
        //isian untuk server
        String  host = "jdbc:mysql://localhost/web_db",
                user = "root",
                pass = "";
        
        //ujilah koneksi dengan pernyataan try catch
        try{
            conn = (Connection) DriverManager.getConnection(host, user, pass);
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return conn;
    }
    
    
//    public static Connection getConnection() {
//        Connection connection = null;
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/web_db"; //ganti dengan database mu
//        String user = "root";
//        String password = "";
//        if (connection == null) {
//            try {
//                Class.forName(driver);
//                connection = DriverManager.getConnection(url, user, password);
//            } catch (ClassNotFoundException | SQLException error) {
//               System.exit(0);
//            }
//
//        }
//        return connection;
//    }
}
