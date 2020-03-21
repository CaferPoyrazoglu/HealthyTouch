package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JList;
import model.recete_sonuc;

public class recete_olustur {

    private double karbonhidrat;
    private double yag;
    private double protein;
    private String alerjen;

    ResultSet rs;
    PreparedStatement ps;

    public recete_sonuc olustur(JList<String> list, recete_sonuc rec) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:sqlserver://evected.duckdns.org:1433;databaseName=kar99", "evected", "123456");
        Statement stmt = con.createStatement();

        int size = list.getModel().getSize(); // 4
        karbonhidrat = 0.0;
        yag = 0.0;
        protein = 0.0;
        alerjen = "";
        
        double toplam_miktar = 0.0;

        for (int i = 0; i < size; i++) {
            /*System.out.println(list.getModel().getElementAt(i));*/

            String myString = list.getModel().getElementAt(i);

            String[] words = myString.split(" ");

            String miktar = words[0];
            String birim = words[1];
            String gida = words[2];

            

            ps = con.prepareStatement("select * from Kar99.gidalar where gida = ?");
            ps.setString(1, gida);
            rs = ps.executeQuery();

            while (rs.next()) {
                karbonhidrat = karbonhidrat + rs.getFloat("karbonhidrat");
                yag = yag + rs.getFloat("yag");
                protein = protein + rs.getFloat("protein");
                alerjen = alerjen + rs.getString("alerjen")+" ";
            }

            karbonhidrat = karbonhidrat / 100;
            yag = yag / 100;
            protein = protein / 100;

            double birim2 = 0;

            if (birim.equals("Gram")) {
                birim2 = 1;
            } else if (birim.equals("Mililitre")) {
                birim2 = 1;
            } else if (birim.equals("ÇayKaşığı")) {
                birim2 = 1.6;
            } else if (birim.equals("TatlıKaşığı")) {
                birim2 = 4.5;
            } else if (birim.equals("YemekKaşığı")) {
                birim2 = 10.4;
            } else if (birim.equals("SuBardağı")) {
                birim2 = 200;
            }

            karbonhidrat = karbonhidrat * birim2 * Double.parseDouble(miktar);
            yag = yag * birim2 * Double.parseDouble(miktar);
            protein = protein * birim2 * Double.parseDouble(miktar);
            
            toplam_miktar = toplam_miktar + birim2 * Double.parseDouble(miktar);

        }
        
        //System.out.println(toplam_miktar);
        
        
        
        rec.setKarbonhidrat(karbonhidrat);
        rec.setYag(yag);
        rec.setProtein(protein);
        rec.setAlerjen(alerjen.replace("null", ""));
        rec.setToplam_miktar(toplam_miktar);
        
        
        return rec;
        
        
        
        
        
        
        /*System.out.println("Karbonhidrat toplam: " + karbonhidrat);
        System.out.println("Yag toplam: " + yag);
        System.out.println("Protein toplam: " + protein);
        System.out.println("Alerjenler: " + alerjen);*/

    }

}
