package controller;

import gui.anaEkran;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.oturum;

public class giris_yap {

    ResultSet rs;
    PreparedStatement ps;

    public boolean giris(String kullanici_adi, String sifre, JFrame frame) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:sqlserver://evected.duckdns.org:1433;databaseName=kar99", "evected", "123456");
        Statement stmt = con.createStatement();

        ps = con.prepareStatement("select kad from Kar99.kullanicilar where ksifre = ? and kad = ?");

        ps.setString(1, sifre);
        ps.setString(2, kullanici_adi);
        rs = ps.executeQuery();
        while (rs.next()) {

            String ka = rs.getString("kad");
            if (ka.equals(kullanici_adi)) {
                

                ps = con.prepareStatement("select * from Kar99.kullanicilar where kad = ? and ksifre = ?");
                ps.setString(1, kullanici_adi);
                ps.setString(2, sifre);
                rs = ps.executeQuery();

                oturum ot = new oturum();

                while (rs.next()) {
                    ot.setKad(rs.getString("kad"));
                    ot.setKsifre(rs.getString("ksifre"));
                    ot.setAd(rs.getString("ad"));
                    ot.setSoyad(rs.getString("soyad"));
                    ot.setYas(rs.getString("yas"));
                    ot.setBoy(rs.getString("boy"));
                    ot.setKilo(rs.getString("kilo"));
                    ot.setCinsiyet(rs.getString("cinsiyet"));
                    ot.setKilotercih(rs.getString("kilotercih"));
                    ot.setNo(rs.getString("no"));
                }
                if(ot.getCinsiyet().equals("erkek")){
                    JOptionPane.showMessageDialog(null, "        √ Başarıyla giriş yaptınız, "+ot.getAd()+" Bey √","Healthy Touch",JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Başarıyla giriş yaptınız, "+ot.getAd()+" Hanım","Healthy Touch v1.0",JOptionPane.PLAIN_MESSAGE);
                }
                
                

                anaEkran ae = new anaEkran(ot);
                ae.show();
                frame.setVisible(false);

                return true;

            } else {

                JOptionPane.showMessageDialog(null, "hata");
                return false;

            }

        }
        return false;

    }

}
