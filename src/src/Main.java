package src;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mphstar
 */
public class Main {
    
  
     public static void Splash_Loading(){
        Splash splash = new Splash();
        splash.setVisible(true);
         try {
             for (int i = 0; i <= 100; i++) {
                 Thread.sleep(35);
                 splash.loading_value.setText(i + "%");
                 if ( i == 0){
                     splash.text_loading.setText("Loading....");
                 } else if ( i == 20 ){
                     splash.text_loading.setText("Menghubungkan ke Database....");
                 } else if ( i == 50 ){
                     splash.text_loading.setText("Menyiapkan Aplikasi....");
                 } else if ( i == 100 ){
                     splash.text_loading.setText("Selesai....");
                 }
                splash.bar_loading.setValue(i);
             }
             
             try {
                 FileReader fr = new FileReader("konfigurasi.txt");
                 splash.dispose();
                 
                new Form_Login().setVisible(true);
             } catch (Exception e) {
                 
                 splash.dispose();
                 new KonfigurasiDatabase(null, true).setVisible(true);
                 new Form_Login().setVisible(true);
             }
             
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(splash, e);
         }
    }
    
    public static void main(String[] args) {
        Splash_Loading();
    }
}
