package src;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class PopUp extends javax.swing.JDialog {

    int mouseX;
    int mouseY;
    int konfirm;
    
    public PopUp(java.awt.Frame parent, boolean modal, String title, String isi, int icon) {
       
        super(parent, modal);
        initComponents();
        this.getRootPane().setOpaque(false);
        this.getContentPane ().setBackground (new Color (0, 0, 0, 0));
        this.setBackground (new Color (0, 0, 0, 0));
         
        // isi
        this.title.setText(title);
        this.isi.setText(isi);
       if ( icon == 0 ){
           this.icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/popup_questions.png")));
       } else {
           System.out.println("error");
       }
    }
    
    
    public int hasil(){
        
        return this.konfirm;
    }
    
 
    
    public void customOption(String opsi1, String opsi2, String keterangan, String keterangan1){
        this.jLabel7.setText(opsi1);
        this.jLabel8.setText(opsi2);
        this.ket.setText(keterangan);
        this.ket1.setText(keterangan1);
    }
    
    public void customKeterangan(String ket){
        this.keterangan.setText(ket);
    }
    
    
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        isi = new javax.swing.JLabel();
        keterangan = new javax.swing.JLabel();
        ket1 = new javax.swing.JLabel();
        ket = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_ok = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Toko SA");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Images/icon.png")).getImage());
        setUndecorated(true);
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

        isi.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        isi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        isi.setText("Apakah kamu yakin ingin menghapus");
        getContentPane().add(isi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 440, -1));

        keterangan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        keterangan.setForeground(new java.awt.Color(102, 102, 102));
        keterangan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 440, 30));

        ket1.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        ket1.setForeground(new java.awt.Color(153, 153, 153));
        ket1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(ket1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 440, -1));

        ket.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        ket.setForeground(new java.awt.Color(153, 153, 153));
        ket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ket.setText("Tekan OK untuk melanjutkan, atau tekan Cancel untuk membatalkan");
        getContentPane().add(ket, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 440, -1));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/popup_questions.png"))); // NOI18N
        getContentPane().add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("OK");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 60, 30));

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
        jPanel2.add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(99, 159, 227));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cancel");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 60, 30));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_light_fix_00000_00000.png"))); // NOI18N
        btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelMouseExited(evt);
            }
        });
        jPanel2.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

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
        this.konfirm = 5;
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btn_okMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okMouseEntered
        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
    }//GEN-LAST:event_btn_okMouseEntered

    private void btn_okMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okMouseExited
        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
    }//GEN-LAST:event_btn_okMouseExited

    private void btn_cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseEntered
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_light_00000.png")));
        
    }//GEN-LAST:event_btn_cancelMouseEntered

    private void btn_cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseExited
        
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_light_fix_00000_00000.png")));
        
    }//GEN-LAST:event_btn_cancelMouseExited

    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseClicked
        // true or false
        this.konfirm = 1; 
      
        // mphstar
        
        this.dispose();
    }//GEN-LAST:event_btn_cancelMouseClicked

    private void btn_okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okMouseClicked
        this.konfirm = 0;
    
        this.dispose();
    }//GEN-LAST:event_btn_okMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ESCAPE){
                this.konfirm = 5;
                this.dispose();
                 
             } else if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
                this.konfirm = 0;
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
            java.util.logging.Logger.getLogger(PopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopUp dialog = new PopUp(new javax.swing.JFrame(), true, null, null, 0);
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
    private javax.swing.JLabel btn_cancel;
    private javax.swing.JLabel btn_ok;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel isi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel ket;
    private javax.swing.JLabel ket1;
    private javax.swing.JLabel keterangan;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
