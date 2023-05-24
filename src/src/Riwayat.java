package src;


import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mphstar
 */



public class Riwayat extends javax.swing.JFrame {

    /**
     * Creates new form tambah_barang
     */
    
    public static String formatRupiah(int nilai){
        DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols simbol = format.getDecimalFormatSymbols();
        simbol.setCurrencySymbol("Rp. ");
        simbol.setMonetaryDecimalSeparator(',');
        simbol.setGroupingSeparator('.');
        format.setDecimalFormatSymbols(simbol);
        return format.format(nilai);
    }
    
    public String tabel(String sql){
        DefaultTableModel model = new DefaultTableModel();
        tabel_riwayat.getTableHeader().setDefaultRenderer(new CustomTableHeader());
        tabel_riwayat.setBorder(new EmptyBorder(10, 5, 10, 5));
        tabel_riwayat.setDefaultEditor(Object.class, null);
        model.addColumn("ID Trasaksi");
        model.addColumn("Username");
        model.addColumn("Total Harga");
        model.addColumn("Total Bayar");
        model.addColumn("Kembalian");
        model.addColumn("Tanggal");
        
        try {
            Connection conn = auth.Koneksi.configDB();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), this.formatRupiah(Integer.parseInt(rs.getString(3))).replace(",00", ""), this.formatRupiah(Integer.parseInt(rs.getString(4))).replace(",00", ""),
                    this.formatRupiah(Integer.parseInt(rs.getString(5))).replace(",00", ""), rs.getString(6)
                });
                
            }
            
            tabel_riwayat.setModel(model);
            for (int i = 0; i <= 5; i++) {
                tabel_riwayat.getColumnModel().getColumn(i).setCellRenderer(new CustomTable());
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal");
        }
        return sql;
    }
    
    public void kosongkan(){
        
        txt_search.setText("");
        //tabel();
    }
    
    public void UI(){
        //setUI(new ModernScrollBarUI());
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if ("Windows".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    boolean isAdded = false;

    public boolean isOnTheScreen()
    {
       return isAdded;
    }

    public void setOnTheScreen(boolean isAdded)
    {
       this.isAdded = isAdded;
    }
    
  
    
    public Riwayat(){
        
        initComponents();
   
        String sql = "SELECT transaksi.id_transaksi, transaksi.username, "
                + "transaksi.totalHarga, transaksi.totalBayar, "
                + "transaksi.totalKembalian, transaksi.tanggal "
                + "FROM transaksi JOIN detail_akun ON transaksi.username = detail_akun.username "
                + "WHERE transaksi.id_transaksi LIKE '%"+txt_search.getText()+"%' "
                + "ORDER BY transaksi.id_transaksi ASC";
        tabel(sql);
        
        
        this.setVisible(true);
       
         try {
            Connection conn = auth.Koneksi.configDB();
            String cek = "SELECT SUM(totalHarga) FROM transaksi";
            PreparedStatement pst = conn.prepareStatement(cek);
            ResultSet rs = pst.executeQuery(cek);
            if(rs.next()){
              
                PopUpMessages messages = new PopUpMessages(this, true, "Pendapatan", "Total pendapatan sebesar: " +this.formatRupiah(Integer.parseInt(rs.getString(1))).replace(",00", ""), 0);
                messages.setAlwaysOnTop(true);
                messages.setLoad(1);
                messages.setVisible(true);
                 
                
               
            }
            } catch (Exception e) {
                
            }
      
            
      
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        box_username = new javax.swing.JLabel();
        UI();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_riwayat = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        date2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        date1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Toko SA");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Images/icon.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1090, 610));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/444.png"))); // NOI18N
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 140, -1, 30));

        txt_search.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txt_search.setBorder(null);
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        jPanel1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 146, 120, 16));

        box_username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/searchbar4.png"))); // NOI18N
        jPanel1.add(box_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 210, 50));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        tabel_riwayat.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tabel_riwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_riwayat.setAlignmentX(0.0F);
        tabel_riwayat.setAlignmentY(0.0F);
        tabel_riwayat.setGridColor(new java.awt.Color(230, 230, 230));
        tabel_riwayat.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabel_riwayat.setRowHeight(40);
        tabel_riwayat.setSelectionBackground(new java.awt.Color(247, 247, 247));
        tabel_riwayat.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabel_riwayat.setShowVerticalLines(false);
        tabel_riwayat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_riwayatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_riwayat);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 930, 300));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Cetak");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 500, 80, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 500, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("-");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 10, 40));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel2.setText("Riwayat Transaksi");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, 50));

        date2.setDateFormatString("yyyy-MM-dd");
        date2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        date2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                date2MouseClicked(evt);
            }
        });
        date2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                date2KeyReleased(evt);
            }
        });
        jPanel1.add(date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 120, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setText("Sort by date");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 40));

        date1.setDateFormatString("yyyy-MM-dd");
        date1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        date1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                date1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                date1KeyReleased(evt);
            }
        });
        jPanel1.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 120, -1));

        jButton2.setText("Sort");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Reset");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 80, 30));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, -1, -1));

        panel_hapus.setBackground(new java.awt.Color(255, 255, 255));
        panel_hapus.setLayout(null);

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Hapus");
        panel_hapus.add(jLabel22);
        jLabel22.setBounds(20, 0, 60, 30);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
        });
        panel_hapus.add(jLabel23);
        jLabel23.setBounds(10, 0, 80, 30);

        jPanel1.add(panel_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 500, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png")));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back_hover.png")));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        this.dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    
    public static int nilai_opsi;
    private void tabel_riwayatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_riwayatMouseClicked
  
       int baris = tabel_riwayat.rowAtPoint(evt.getPoint());
        if(nilai_opsi == 0){
            PopUp popup = new PopUp(this, true, "Menu", "Silahkan pilih menu dibawah", 0);
            popup.customOption("Detail", "Hapus", "Tekan Detail untuk melihat Detail Transaksi, atau Hapus untuk menghapus transaksi", "");
            popup.setVisible(true);
            int hasil = popup.hasil();
            
            if(hasil == 0){
          
                try {
                    InputStream struk = getClass().getResourceAsStream("/iReport/strukPembelian.jrxml");
                    Connection conn = auth.Koneksi.configDB();
                    //HashMap m  = new HashMap();
                    
                    JasperDesign jd = JRXmlLoader.load(struk);
                    String sql = "SELECT transaksi.id_transaksi, barang.id_barang, barang.nama, detail_barang.jumlah, detail_barang.subTotal, transaksi.totalHarga, transaksi.totalBayar, transaksi.totalKembalian, transaksi.tanggal, barang.harga_satuan FROM detail_barang, barang, transaksi WHERE detail_barang.id_barang = barang.id_barang AND detail_barang.id_transaksi = transaksi.id_transaksi AND transaksi.id_transaksi = '"+tabel_riwayat.getValueAt(baris, 0).toString()+"'";
                    JRDesignQuery newQuery = new JRDesignQuery();
                    newQuery.setText(sql);
                    jd.setQuery(newQuery);
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperPrint jp = JasperFillManager.fillReport(jr, null,conn);
                                    //JasperViewer.viewReport(jp);
                    JasperViewer jv = new JasperViewer(jp, false);
                    jv.setVisible(true);
                } catch (Exception e) {
                    System.out.println("error" +e);
                    e.getMessage();

                }
            } else if (hasil == 1){
                PopUp popup1 = new PopUp(this, true, "Konfirmasi", "Apakah anda yakin ingin menghapus transaksi ini?", 0);
                popup1.setVisible(true);
                int konfirm = popup1.hasil();
                if ( konfirm == 0 ){
                    try {

                        Connection conn = auth.Koneksi.configDB();
                        String sql = "DELETE FROM transaksi WHERE id_transaksi = '"+tabel_riwayat.getValueAt(baris, 0).toString()+"'";
                        PreparedStatement pst = conn.prepareStatement(sql);
                        pst.execute();
                        new PopUpMessages(this, true, "Berhasil", "Berhasil menghapus transaksi", 1).setVisible(true);

                        reset();
                    } catch (Exception e) {
                        System.out.println("gagal hapus");
                    }
                } else {
                    
                }
                
            }
       } else {
          
                try {
                    InputStream struk = getClass().getResourceAsStream("/iReport/strukPembelian.jrxml");
                    Connection conn = auth.Koneksi.configDB();
                    HashMap m  = new HashMap();

                    JasperDesign jd = JRXmlLoader.load(struk);
                    String sql = "SELECT transaksi.id_transaksi, barang.id_barang, barang.nama, "
                            + "detail_barang.jumlah, detail_barang.subTotal, transaksi.totalHarga, "
                            + "transaksi.totalBayar, transaksi.totalKembalian, transaksi.tanggal, barang.harga_satuan "
                            + "FROM detail_barang, barang, transaksi WHERE detail_barang.id_barang = barang.id_barang "
                            + "AND detail_barang.id_transaksi = transaksi.id_transaksi "
                            + "AND transaksi.id_transaksi = '"+tabel_riwayat.getValueAt(baris, 0).toString()+"'";
                    JRDesignQuery newQuery = new JRDesignQuery();
                    newQuery.setText(sql);
                    jd.setQuery(newQuery);
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperPrint jp = JasperFillManager.fillReport(jr, null,conn);
                                    //JasperViewer.viewReport(jp);
                    JasperViewer jv = new JasperViewer(jp, false);
                    jv.setVisible(true);
                } catch (Exception e) {
                    System.out.println("error" +e);
                    e.getMessage();

                }
            } 
    }//GEN-LAST:event_tabel_riwayatMouseClicked

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
       // if(jButton2.isSelected()){
            
          
           if (date1.getDate() == null || date2.getDate() == null){
               String sql = "SELECT transaksi.id_transaksi, transaksi.username, transaksi.totalHarga, transaksi.totalBayar, transaksi.totalKembalian, transaksi.tanggal FROM transaksi JOIN detail_akun ON transaksi.username = detail_akun.username WHERE transaksi.id_transaksi LIKE '%"+txt_search.getText()+"%' ORDER BY transaksi.id_transaksi ASC";
               tabel(sql);
           } else {
               validasi();
           }
            
            
//        } else {
//            String sql = "SELECT transaksi.id_transaksi, transaksi.username, transaksi.totalHarga, transaksi.totalBayar, transaksi.totalKembalian, transaksi.tanggal FROM transaksi JOIN detail_akun ON transaksi.username = detail_akun.username WHERE transaksi.id_transaksi LIKE '%"+txt_search.getText()+"%';";
//            tabel(sql);
//        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
    }//GEN-LAST:event_jLabel19MouseEntered

    private void hapus(){
        try {
             if (date1.getDate() == null || date2.getDate() == null){
                PopUp popup = new PopUp(this, true, "Konfirmasi", "Apakah anda yakin ingin menghapus data?", 0);
                popup.customKeterangan("Semua transaksi akan terhapus");
                popup.setVisible(true);
                
                int hasil = popup.hasil();
                if ( hasil == 0 ){
                    String sql = "DELETE FROM transaksi;";
                    Connection conn = auth.Koneksi.configDB();
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.execute();
                    new PopUpMessages(this, true, "Berhasil", "Data berhasil dihapus", 1).setVisible(true);
                    reset();
                } else {
                    
                }

            } else {
                PopUp popup = new PopUp(this, true, "Konfirmasi", "Apakah anda yakin ingin menghapus data?", 0);
                popup.customKeterangan("Transaksi yang telah disorting sesuai tanggal akan terhapus");
                popup.setVisible(true);
                
                int hasil = popup.hasil();
                if ( hasil == 0 ){
                    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                    String sql = "DELETE FROM transaksi WHERE transaksi.tanggal BETWEEN '"+date.format(date1.getDate())+"' AND '"+date.format(date2.getDate())+"' AND transaksi.id_transaksi LIKE '%"+txt_search.getText()+"%';";
                    Connection conn = auth.Koneksi.configDB();
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.execute();
                    new PopUpMessages(this, true, "Berhasil", "Data berhasil dihapus", 1).setVisible(true);
                    reset();
                } else {
                    
                }

            }
        } catch (Exception e) {
            
        }
    }
    
    private void cetak(){
        if (date1.getDate() == null || date2.getDate() == null){
        
            try {
                //String path = request
                InputStream laporan =  getClass().getResourceAsStream("/iReport/riwayatPemesanan.jrxml");
              
                JasperDesign jd = JRXmlLoader.load(laporan);
                String sql = "SELECT * FROM transaksi JOIN detail_akun ON transaksi.username = detail_akun.username WHERE transaksi.id_transaksi LIKE '%"+txt_search.getText()+"%' ORDER BY transaksi.id_transaksi ASC";
                Connection conn = auth.Koneksi.configDB();
                JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);
                JasperReport jr = JasperCompileManager.compileReport(jd);
                //JasperReport jr = JasperCompileManager.compileReport(new File("").getAbsolutePath()+"/iReport/riwayatPemesanan.jrxml");
                JasperPrint jp = JasperFillManager.fillReport(jr, null,conn);
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
            
        } else {

            try {
                InputStream laporan = getClass().getResourceAsStream("/iReport/riwayatPemesanan.jrxml");
                JasperDesign jd = JRXmlLoader.load(laporan);
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                String sql = "SELECT * FROM transaksi JOIN detail_akun ON transaksi.username = detail_akun.username WHERE transaksi.tanggal BETWEEN '"+date.format(date1.getDate())+"' AND '"+date.format(date2.getDate())+"' AND transaksi.id_transaksi LIKE '%"+txt_search.getText()+"%' ORDER BY transaksi.id_transaksi ASC";
                Connection conn = auth.Koneksi.configDB();
                
 
                JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);
                JasperReport jr = JasperCompileManager.compileReport(jd);
                //JasperReport jr = JasperCompileManager.compileReport(new File("").getAbsolutePath()+"/iReport/riwayatPemesanan.jrxml");
                JasperPrint jp = JasperFillManager.fillReport(jr, null,conn);
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        cetak();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void date2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_date2KeyReleased
        
    }//GEN-LAST:event_date2KeyReleased

    private void date1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_date1KeyReleased
        //tabel();
    }//GEN-LAST:event_date1KeyReleased

    private void date1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_date1KeyPressed
        
    }//GEN-LAST:event_date1KeyPressed

    private void date2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_date2MouseClicked
        
    }//GEN-LAST:event_date2MouseClicked

    private void validasi(){
        if (date1.getDate() == null || date2.getDate() == null){
            new PopUpMessages(this, true, "Informasi", "Date tidak boleh kosong!", 0).setVisible(true);
            
        } else {
            
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String sql = "SELECT transaksi.id_transaksi, transaksi.username, transaksi.totalHarga, "
                    + "transaksi.totalBayar, transaksi.totalKembalian, transaksi.tanggal "
                    + "FROM transaksi JOIN detail_akun ON transaksi.username = detail_akun.username "
                    + "WHERE transaksi.tanggal BETWEEN '"+date.format(date1.getDate())+"' "
                    + "AND '"+date.format(date2.getDate())+"' AND transaksi.id_transaksi LIKE '%"+txt_search.getText()+"%' "
                    + "ORDER BY transaksi.id_transaksi ASC";
            tabel(sql);
        }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        validasi();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void reset(){
        txt_search.setText("");
        String sql = "SELECT transaksi.id_transaksi, transaksi.username, transaksi.totalHarga, transaksi.totalBayar, transaksi.totalKembalian, transaksi.tanggal FROM transaksi JOIN detail_akun ON transaksi.username = detail_akun.username ORDER BY transaksi.id_transaksi ASC";
        tabel(sql);
        
        date1.setDate(null);
        date2.setDate(null);
    }
    
    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        reset();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
    }//GEN-LAST:event_jLabel21MouseExited

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // hapus
        
   
                hapus();
                reset();
        
        
        
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
                                       
    }//GEN-LAST:event_jLabel23MouseExited

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        if (date1.getDate() == null || date2.getDate() == null){
               String sql = "SELECT transaksi.id_transaksi, transaksi.username, transaksi.totalHarga, transaksi.totalBayar, transaksi.totalKembalian, transaksi.tanggal FROM transaksi JOIN detail_akun ON transaksi.username = detail_akun.username WHERE transaksi.id_transaksi LIKE '%"+txt_search.getText()+"%' ORDER BY transaksi.id_transaksi ASC";
               tabel(sql);
           } else {
               validasi();
           }
    }//GEN-LAST:event_txt_searchActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        PopUp popup = new PopUp(this, true, "Konfirmasi", "Apakah anda yakin ingin keluar?", 0);
        popup.setVisible(true);
        int hasil = popup.hasil();
        
        if(hasil == 0){
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing


            
   
    
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
            java.util.logging.Logger.getLogger(tambah_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tambah_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tambah_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tambah_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tambah_barang().setVisible(true);
                
                
            }
        });
    }
    public InputStream stuk = getClass().getResourceAsStream("/iReport/strukPembelian.jrxml");
    public InputStream cetakriwayat = getClass().getResourceAsStream("/iReport/riwayatPemesanan.jrxml");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel box_username;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JPanel panel_hapus = new javax.swing.JPanel();
    private javax.swing.JTable tabel_riwayat;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
