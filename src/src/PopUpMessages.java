package src;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

public class PopUpMessages extends javax.swing.JDialog {

    int mouseX;
    int mouseY;
    
    
    
    public PopUpMessages(java.awt.Frame parent, boolean modal, String title, String isi, int icon) {
       
        super(parent, modal);
        initComponents();
      
        this.getRootPane().setOpaque(false);
        this.getContentPane ().setBackground (new Color (0, 0, 0, 0));
        this.setBackground (new Color (0, 0, 0, 0));
        // isi
        this.title.setText(title);
        this.info.setText(isi);
       if ( icon == 0 ){
           this.icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/popup_info.png")));
       } else if ( icon == 1 ){
           this.icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/popup_done.png")));
       } else if ( icon == 2 ){
           this.icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/popup_error.png")));
       } else {
           System.out.println("error");
       }
        
    }
    
    Float opacity;
    int anu;
 
            
  public Float setOpacity(){
      if(this.anu == 1){
          try {
            for (float i = 0.0f; i <= 1f; i++) {
                Thread.sleep(10000);
                this.opacity = i;
            }
            } catch (Exception e) {
                System.out.println("ee");
        }
      } else {
          this.opacity = 1f;
      }
      return this.opacity;
  }
  
  public void setFontSize(int fontsize){
        
        this.info.setFont(new java.awt.Font("SansSerif", 0, fontsize));
    }
  
  public void setLoad(int anu){
      this.anu = anu;
  }
    
    
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_ok = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Toko SA");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Images/icon.png")).getImage());
        setUndecorated(true);
        setOpacity(setOpacity());
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 440, 50));

        title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        title.setForeground(new java.awt.Color(153, 153, 153));
        title.setText("Judul");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 360, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 420, 1));

        info.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("Berhasil dilakukan");
        getContentPane().add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 440, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tekan OK untuk melanjutkan");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 440, -1));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/popup_info.png"))); // NOI18N
        getContentPane().add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("OK");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 60, 30));

        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png"))); // NOI18N
        btn_ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_okMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_okMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_okMouseExited(evt);
            }
        });
        jPanel2.add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 420, 60));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/popup_00000.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 10, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - mouseX, y - mouseY);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btn_okMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okMouseEntered
        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
    }//GEN-LAST:event_btn_okMouseEntered

    private void btn_okMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okMouseExited
        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
    }//GEN-LAST:event_btn_okMouseExited

    private void btn_okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_okMouseClicked
    
    int konfirm;
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            this.dispose();
        } else {
                 
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PopUpMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopUpMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopUpMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopUpMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopUpMessages dialog = new PopUpMessages(new javax.swing.JFrame(), true, null, null, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btn_ok;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
