package src;


import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mphstar
 */


   
public class tambah_barang extends javax.swing.JFrame {

    /**
     * Creates new form tambah_barang
     */
    
    public void pilih_kategori(){
        try {
            String sql = "SELECT * FROM kategori";
            Connection conn = auth.Koneksi.configDB();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()){
                txt_kategori.addItem(rs.getString("kategori"));
            }
        } catch (Exception e) {
        }
    }
    
    private String formatRupiah(int nilai){
        DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols simbol = format.getDecimalFormatSymbols();
        simbol.setCurrencySymbol("Rp. ");
        simbol.setMonetaryDecimalSeparator(',');
        simbol.setGroupingSeparator('.');
        format.setDecimalFormatSymbols(simbol);
        return format.format(nilai);
    }
    
    NumberFormat numformat = NumberFormat.getInstance(new Locale("ca", "CA"));
    
    NumberFormatter numformatter;
        
    private void setRupiah(){
        
        
        numformat.setMaximumFractionDigits(0);
        
        numformatter = new NumberFormatter(numformat);
        numformatter.setAllowsInvalid(false);

    }
    
    public void tabel(){
        DefaultTableModel model = new DefaultTableModel();
        
        tabel_barang.getTableHeader().setDefaultRenderer(new CustomTableHeader());
 
        tabel_barang.setBorder(new EmptyBorder(10, 5, 10, 5));
        tabel_barang.setDefaultEditor(Object.class, null);

        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Kategori");
        model.addColumn("Harga");
        model.addColumn("Stok");
        
        try {
            
            String sql = "SELECT id_barang, nama, kategori, harga_satuan, stok "
                    + "FROM barang JOIN kategori ON barang.id_kategori = kategori.id_kategori "
                    + "WHERE id_barang LIKE '%"+txt_search.getText()+"%' "
                    + "OR nama LIKE '%"+txt_search.getText()+"%'";
            Connection conn = auth.Koneksi.configDB();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3), 
                    this.formatRupiah(Integer.parseInt(rs.getString(4))).replace(",00", ""), rs.getString(5)
                });
                
            }
            
            tabel_barang.setModel(model);
            for (int i = 0; i <= 4; i++) {
                tabel_barang.getColumnModel().getColumn(i).setCellRenderer(new CustomTable());
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void kosongkan(){
        id_barang();
        txt_namabarang.setText("");
        txt_kategori.setSelectedItem(this);
        txt_harga.setText("0");
        txt_stok.setText("");
        txt_validation.setText("");
        txt_search.setText("");
        tabel();
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
    
    public tambah_barang() {
        setRupiah();

        initComponents();
        
        
        tabel();
        
        txt_kategori.setBackground(Color.WHITE);
        pilih_kategori();
        id_barang();
        txt_id.disable();
        
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
        txt_namabarang = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_id = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        txt_stok = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        box_username = new javax.swing.JLabel();
        txt_harga = new javax.swing.JFormattedTextField(numformatter);
        box_id = new javax.swing.JLabel();
        UI();
        txt_kategori = new javax.swing.JComboBox<>();
        box_username2 = new javax.swing.JLabel();
        box_username3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        box_username4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_validation = new javax.swing.JLabel();
        UI();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_barang = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

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

        txt_namabarang.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txt_namabarang.setBorder(null);
        txt_namabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarangActionPerformed(evt);
            }
        });
        jPanel1.add(txt_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 170, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/444.png"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 130, -1, 30));

        txt_id.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 174, 170, 40));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 48)); // NOI18N
        jLabel1.setText("Tambah Barang");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 62, -1, -1));

        txt_search.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txt_search.setBorder(null);
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        jPanel1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 136, 120, 16));

        txt_stok.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txt_stok.setBorder(null);
        txt_stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stokActionPerformed(evt);
            }
        });
        jPanel1.add(txt_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 170, 30));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        jLabel2.setText("ID Barang");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        jLabel3.setText("Stok");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        jLabel4.setText("Nama Barang");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        jLabel5.setText("Kategori");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, 50));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        jLabel6.setText("Harga Satuan");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        box_username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/searchbar4.png"))); // NOI18N
        jPanel1.add(box_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 210, 50));

        txt_harga.setBorder(null);
        txt_harga.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txt_harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_hargaKeyPressed(evt);
            }
        });
        jPanel1.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 170, 30));

        box_id.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Rounded TextBox.png"))); // NOI18N
        jPanel1.add(box_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 210, 50));

        txt_kategori.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txt_kategori.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(txt_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 190, 40));

        box_username2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Rounded TextBox.png"))); // NOI18N
        jPanel1.add(box_username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 210, 50));

        box_username3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Rounded TextBox.png"))); // NOI18N
        jPanel1.add(box_username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 210, 50));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Cek Barang");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 470, 80, 30));

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
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 470, -1, -1));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Ubah");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 70, 30));

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Bersihkan");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 80, 30));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Hapus");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 80, 30));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Tambah");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 80, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, -1, -1));

        box_username4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Rounded TextBox.png"))); // NOI18N
        jPanel1.add(box_username4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 210, 50));

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Refresh");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 470, 80, 30));

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
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 470, -1, -1));

        txt_validation.setForeground(new java.awt.Color(204, 0, 0));
        txt_validation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(txt_validation, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 260, 30));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        tabel_barang.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tabel_barang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_barang.setAlignmentX(0.0F);
        tabel_barang.setAlignmentY(0.0F);
        tabel_barang.setGridColor(new java.awt.Color(230, 230, 230));
        tabel_barang.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabel_barang.setRowHeight(40);
        tabel_barang.setSelectionBackground(new java.awt.Color(247, 247, 247));
        tabel_barang.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabel_barang.setShowVerticalLines(false);
        tabel_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_barang);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 500, 270));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stokActionPerformed

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void tabel_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barangMouseClicked
        int baris = tabel_barang.rowAtPoint(evt.getPoint());
        txt_id.setText(tabel_barang.getValueAt(baris, 0).toString());
        txt_id.disable();
        txt_namabarang.setText(tabel_barang.getValueAt(baris, 1).toString());
        txt_kategori.setSelectedItem(tabel_barang.getValueAt(baris, 2).toString());
        txt_harga.setText(tabel_barang.getValueAt(baris, 3).toString().replace("Rp", "").replaceAll("\\s+", "").replaceAll("\\.", ""));
        
        txt_stok.setText(tabel_barang.getValueAt(baris, 4).toString());
    }//GEN-LAST:event_tabel_barangMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        kosongkan();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // Tambah data
        if ( txt_namabarang.getText().length() > 40 ){
            new PopUpMessages(this, true, "Informasi", "Cek panjang length pada tiap Field", 0).setVisible(true);
           
        } else {
            if(txt_namabarang.getText().equals("") || txt_harga.getText().equals("") || txt_stok.getText().equals("")){
            new PopUpMessages(this, true, "Informasi", "Data Wajib diisi!", 0).setVisible(true);

        } else { 
            PopUp popup = new PopUp(this, true, "Konfirmasi", "Apakah anda yakin ingin menambahkan data?", 0);
            popup.setVisible(true);
            int hasil = popup.hasil();
            if ( hasil == 0){
                try {
            
                    Connection conn = auth.Koneksi.configDB();
                    String pilih_kategori = "SELECT * FROM kategori WHERE kategori = '"+txt_kategori.getSelectedItem().toString()+"'";

                    PreparedStatement p = conn.prepareStatement(pilih_kategori);
                    ResultSet r = p.executeQuery(pilih_kategori);
                    if (r.next()){
                        String kategori = r.getString("id_kategori");

                        String sql = "INSERT into barang VALUES ('"+txt_id.getText()+"', '"+txt_namabarang.getText()+"', "
                                + "'"+kategori+"', '"+Integer.parseInt(txt_harga.getText().replaceAll("\\.", ""))+"', "
                                + "'"+txt_stok.getText()+"')";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.execute();
                        new PopUpMessages(this, true, "Berhasil", "Berhasil Menambahkan Data", 1).setVisible(true);


                    } 
                    kosongkan();
                    tabel();
            } catch (Exception e) {
                 
                    new PopUpMessages(this, true, "Gagal", "ID Barang yang sudah ada, tidak bisa ditambahkan lagi!", 2).setVisible(true);

                    kosongkan();
                    tabel();
                }
            } else {
                
            }
            
        }
        }
        
    }//GEN-LAST:event_jLabel8MouseClicked

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        tabel();
    }//GEN-LAST:event_txt_searchKeyReleased

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
         if ( txt_namabarang.getText().length() > 40 ){
            new PopUpMessages(this, true, "Informasi", "Cek panjang length pada tiap Field", 0).setVisible(true);
           
        } else {
             if(txt_namabarang.getText().equals("") || txt_harga.getText().equals("") || txt_stok.getText().equals("")){
            new PopUpMessages(this, true, "Informasi", "Data Wajib diisi!", 0).setVisible(true);

        } else { 
            PopUp popup = new PopUp(this, true, "Konfirmasi", "Apakah anda yakin ingin mengubah data?", 0);
            popup.setVisible(true);
            int hasil = popup.hasil();
            if ( hasil == 0 ){
                try {
                    Connection conn = auth.Koneksi.configDB();
                    String pilih_kategori = "SELECT id_kategori FROM kategori WHERE kategori = '"+txt_kategori.getSelectedItem()+"'";
                    PreparedStatement p = conn.prepareStatement(pilih_kategori);
                    ResultSet r = p.executeQuery(pilih_kategori);
                    if (r.next()){
                        String kategori = r.getString("id_kategori");
                        try {
                            String sql = "UPDATE barang "
                                    + "SET nama = '"+txt_namabarang.getText()+"', "
                                    + "id_kategori = '"+kategori+"', "
                                    + "harga_satuan = '"+txt_harga.getText().replaceAll("\\.", "")+"', "
                                    + "stok = '"+txt_stok.getText()+"' "
                                    + "WHERE id_barang = '"+txt_id.getText()+"'";
                            PreparedStatement ps = conn.prepareStatement(sql);
                            ps.execute();
                            new PopUpMessages(this, true, "Berhasil", "Berhasil mengubah data", 1).setVisible(true);

                        } catch (Exception e) {
                            new PopUpMessages(this, true, "Gagal", "Gagal mengubah data", 2).setVisible(true);

                        }

                    }
                    kosongkan();
                    tabel();
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                //nothing:)
            }
            }
         }

    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
         if(txt_namabarang.getText().equals("") || txt_harga.getText().equals("") || txt_stok.getText().equals("")){
            new PopUpMessages(this, true, "Informasi", "Data Wajib diisi!", 0).setVisible(true);

        } else { 
             PopUp popup = new PopUp(this, true, "Konfirmasi", "Apakah anda yakin ingin menghapus data?", 0);
        popup.setVisible(true);
        int hasil = popup.hasil();
        
        if (hasil == 0){
        try {
            String sql = "DELETE FROM barang WHERE id_barang = '"+txt_id.getText()+"'";
            Connection conn = auth.Koneksi.configDB();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            new PopUpMessages(this, true, "Berhasil", "Berhasil menghapus data", 1).setVisible(true);

            kosongkan();
            tabel();
            } catch (Exception e) {
                new PopUpMessages(this, true, "Gagal", "Data gagal dihapus", 2).setVisible(true);

            }
        }
         }
        
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
      
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
      
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
       
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
       
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
       
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
       
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
      
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
       
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        
        txt_search.setText("");
        tabel();

    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
      
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
        
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
         jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back_hover.png")));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png")));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        this.dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void txt_hargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hargaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE){
            if(txt_harga.getText().length() == 1){
                txt_harga.setText("0");
            }
        }
    }//GEN-LAST:event_txt_hargaKeyPressed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // Cek Barang
        new DialogCekBarang(this, true).setVisible(true);
        
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
    }//GEN-LAST:event_jLabel21MouseExited

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
      
    public void id_barang(){
        try {
            String sql = "SELECT id_barang FROM barang ORDER BY id_barang DESC";
            java.sql.Connection conn=(Connection)auth.Koneksi.configDB();
            java.sql.PreparedStatement ps=conn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery(sql);
            if ( rs.next()){
                String idBarang = rs.getString("id_barang").substring(2);
                String br = "BR" +(Integer.parseInt(idBarang)+1);
                txt_id.setText(br);
            } else {
                txt_id.setText("BR100");
            }
        } catch (Exception e) {
            System.out.println("Koneksi gagal");
        }
    }
    
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

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel box_id;
    private javax.swing.JLabel box_username;
    private javax.swing.JLabel box_username2;
    private javax.swing.JLabel box_username3;
    private javax.swing.JLabel box_username4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_barang;
    private javax.swing.JFormattedTextField txt_harga;
    private javax.swing.JLabel txt_id;
    private javax.swing.JComboBox<String> txt_kategori;
    private javax.swing.JTextField txt_namabarang;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_stok;
    private javax.swing.JLabel txt_validation;
    // End of variables declaration//GEN-END:variables
}
