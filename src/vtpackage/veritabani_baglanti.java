package vtpackage;
import java.sql.Connection; import java.sql.DriverManager;import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class veritabani_baglanti {
    
    
    public void baglan(){
try{           
            Connection con;
            con = DriverManager.getConnection( "jdbc:sqlserver://evected.duckdns.org:1433;databaseName=kar99", "evected", "123456" );
            Statement stmt = con.createStatement();                      
            con.close();
            System.out.print("baglandi");
            JOptionPane.showMessageDialog(null, "Baglanti basarili!");
}


catch(SQLException ex){        
            System.out.print(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Baglanti basarisiz!"+ex);
}

}
}