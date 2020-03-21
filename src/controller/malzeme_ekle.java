
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;


public class malzeme_ekle {

    

    public void ekle(JTextField malzeme_ad_field, JTextField karbon_field, JTextField pro_field, JTextField yag_field, JTextField alergen_field) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:sqlserver://evected.duckdns.org:1433;databaseName=kar99", "evected", "123456");
        Statement stmt = con.createStatement();
        
        ResultSet rs;
        PreparedStatement ps;
        
        
       // " insert into users (first_name, last_name, date_created, is_admin, num_points)" + " values (?, ?, ?, ?, ?)";
        
        ps = con.prepareStatement("insert into Kar99.gidalar (gida,karbonhidrat,protein,yag,alerjen) values (?,?,?,?,?)");
        
        String malzeme =malzeme_ad_field.getText();
        malzeme.replace(" ", "");
        
        ps.setString(1, malzeme);
        ps.setString(2, karbon_field.getText());
        ps.setString(3, pro_field.getText());
        ps.setString(4, yag_field.getText());
        ps.setString(5, alergen_field.getText());
        
        ps.execute();
        
        
  
        
    }
    
}
