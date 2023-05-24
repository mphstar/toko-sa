package src;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;

public class PopUpInput extends javax.swing.JDialog {

    int mouseX;
    int mouseY;
    int konfirm;
    
    public PopUpInput(java.awt.Frame parent, boolean modal, String title, String isi) {
       
        super(parent, modal);
        initComponents();
        this.getRootPane().setOpaque(false);
        this.getContentPane ().setBackground (new Color (0, 0, 0, 0));
        this.setBackground (new Color (0, 0, 0, 0));
        
        // isi
        
        this.title.setText(title);
        this.isi.setText(isi);
       
    }
    
    public int hasil(){
        return this.konfirm;
    }
    
    public String isi_nilai(){
        return String.valueOf(this.isi_input.getText());
    }
    
    
    
    
    
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        isi = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_ok = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JLabel();
        isi_input = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Toko SA");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Images/icon.png")).getImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jLabel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel3KeyPressed(evt);
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

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 165, 420, 2));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 420, 1));

        isi.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        isi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        isi.setText("Masukkan Input");
        getContentPane().add(isi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 440, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tekan OK untuk melanjutkan, atau tekan Cancel untuk membatalkan");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 440, -1));

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

        isi_input.setBackground(new java.awt.Color(247, 247, 247));
        isi_input.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        isi_input.setForeground(new java.awt.Color(153, 153, 153));
        isi_input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        isi_input.setBorder(null);
        isi_input.setOpaque(false);
        isi_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isi_inputActionPerformed(evt);
            }
        });
        isi_input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                isi_inputKeyPressed(evt);
            }
        });
        getContentPane().add(isi_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 420, 30));

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
        this.konfirm = 1;
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

    private void isi_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isi_inputActionPerformed
        this.konfirm = 0;
        this.dispose();
    }//GEN-LAST:event_isi_inputActionPerformed

    private void jLabel3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel3KeyPressed
             
    }//GEN-LAST:event_jLabel3KeyPressed

    private void isi_inputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isi_inputKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ESCAPE){
                this.konfirm = 1;
                this.dispose();
                 
             } else {
                 
             }
    }//GEN-LAST:event_isi_inputKeyPressed

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
            java.util.logging.Logger.getLogger(PopUpInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopUpInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopUpInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopUpInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopUpInput dialog = new PopUpInput(new javax.swing.JFrame(), true, null, null);
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
    private javax.swing.JLabel isi;
    private javax.swing.JTextField isi_input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
