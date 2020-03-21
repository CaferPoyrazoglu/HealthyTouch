package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

public class gida_listele {
    
    
    
 
    public static JComboBox<String> listele(JComboBox<String> gida_combobox) throws SQLException {
        
        Connection con = DriverManager.getConnection("jdbc:sqlserver://evected.duckdns.org:1433;databaseName=kar99", "evected", "123456");
        Statement stmt = con.createStatement();
        
        ResultSet rs;
        PreparedStatement ps;
        
        ps = con.prepareStatement("select gida from Kar99.gidalar ORDER BY gida");
        rs = ps.executeQuery();
        
        while (rs.next()) {
        
        String gida = rs.getString("gida");
        gida_combobox.addItem(gida);
        
        
        }
        
        
        return gida_combobox;
        
        
    }
    
}
