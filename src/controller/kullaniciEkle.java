package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.yeni_kullanici;


public class kullaniciEkle {
    
    PreparedStatement ps;
    
    public boolean vbEkle(yeni_kullanici yk){
        
        try
        {
            Connection con = DriverManager.getConnection( "jdbc:sqlserver://evected.duckdns.org:1433;databaseName=kar99", "evected", "123456" ); 
            Statement stmt = con.createStatement();   
                    
            ps = con.prepareStatement("insert into Kar99.kullanicilar  (kad,ksifre,ad,soyad,yas,boy,kilo,cinsiyet,kilotercih) values (?,?,?,?,?,?,?,?,?)"); 
            
            ps.setString(1,yk.getKad());
            ps.setString(2,yk.getKsifre()); 
            ps.setString(3,yk.getAd()); 
            ps.setString(4,yk.getSoyad()); 
            ps.setString(5,yk.getYas()); 
            ps.setString(6,yk.getBoy()); 
            ps.setString(7,yk.getKilo()); 
            ps.setString(8,yk.getCinsiyet()); 
            ps.setString(9,yk.getKilotercih()); 
            
            
            ps.execute();
            JOptionPane.showMessageDialog(null,yk.getAd()+" Başarıyla kayıt oldunuz.");
            
            
            return true;                
        }
        
        
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }
        
        
    }

        
    }
    
    

