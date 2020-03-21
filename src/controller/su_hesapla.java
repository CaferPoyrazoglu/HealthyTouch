package controller;

import javax.swing.JComboBox;
import model.oturum;

public class su_hesapla  {

    public su_hesapla() {
        
    }

   

    public String hesap2(oturum yo, JComboBox<String> hareket_combo) {
        double su = Integer.parseInt(yo.getKilo()) / 30;

        if (yo.getCinsiyet().equals("erkek")) {
            su = su + 0.5;
        } else {
            su = su + 0.3;
        }
       
        if (String.valueOf(hareket_combo.getSelectedItem()).equals("Az hareketliyim.")) {
            su = su + 0.2;
        } else if (String.valueOf(hareket_combo.getSelectedItem()).equals("Orta hareketliyim.")) {
            su = su + 0.5;
        } else {
            su = su + 0.7;
        }
        
        return Double.toString(su);
        
        
        
        
        
        
        
        
        
        
    }

   
 
    
}
