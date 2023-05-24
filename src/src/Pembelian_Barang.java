package src;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
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

public class Pembelian_Barang extends javax.swing.JFrame {

    /**
     * Creates new form Pembelian_Barang
     * 
     */
    
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
    
    public Pembelian_Barang() {
        setRupiah();
        
        initComponents();
        txt_totalBayar.disable();
        id_transaksi();
        txt_id.disable();
        txt_kembalian.setText("0");
        txt_voucher.disable();
        //txt_totalBayar.disable();
        txt_kembalian.disable();
     
        
        tabel_kategori();
        tabel_barang();
        tabel_keranjang();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        
        txt_tanggal.setText(s.format(date));
 
    }

    
    
    public void tabel_kategori(){
        DefaultTableModel model = new DefaultTableModel();
        tabel_kategori.getTableHeader().setDefaultRenderer(new CustomTableHeader());
        tabel_kategori.setBorder(new EmptyBorder(10, 5, 10, 5));
        tabel_kategori.setDefaultEditor(Object.class, null);
        model.addColumn("ID Kategori");
        model.addColumn("Nama Kategori");

        try {
            
            String sql = "SELECT id_kategori, kategori FROM kategori "
                    + "WHERE id_kategori LIKE '%"+txt_searchKategori.getText()+"%' "
                    + "OR kategori LIKE '%"+txt_searchKategori.getText()+"%'";
            Connection conn = auth.Koneksi.configDB();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString(1), rs.getString(2)
                });
                
            }
            
            tabel_kategori.setModel(model);
            for (int i = 0; i <= 1; i++) {
                tabel_kategori.getColumnModel().getColumn(i).setCellRenderer(new CustomTable());
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
        public void tabel_barang(){
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
                    + "WHERE id_barang LIKE '%"+txt_searchBarang.getText()+"%' "
                    + "OR nama LIKE '%"+txt_searchBarang.getText()+"%'";
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UI();
        tabel_kategori = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        UI();
        tabel_barang = new javax.swing.JTable();
        txt_searchBarang = new javax.swing.JTextField();
        box_username = new javax.swing.JLabel();
        txt_searchKategori = new javax.swing.JTextField();
        box_username1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_totalBiaya = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_kembalian = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        validasi_voucher = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_totalBayar = new javax.swing.JFormattedTextField(numformatter);
        txt_tanggal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/444.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 160, -1, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/444.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, 20));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Bayar");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 520, 80, 30));

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
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 520, -1, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 48)); // NOI18N
        jLabel1.setText("Pilih Barang");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        tabel_kategori.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        tabel_kategori.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_kategori.setGridColor(new java.awt.Color(230, 230, 230));
        tabel_kategori.setRowHeight(30);
        tabel_kategori.setSelectionBackground(new java.awt.Color(247, 247, 247));
        tabel_kategori.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabel_kategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_kategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_kategori);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 400, 120));

        tabel_barang.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
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
        tabel_barang.setGridColor(new java.awt.Color(230, 230, 230));
        tabel_barang.setRowHeight(30);
        tabel_barang.setSelectionBackground(new java.awt.Color(247, 247, 247));
        tabel_barang.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabel_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_barangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_barang);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, -1, 160));

        txt_searchBarang.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txt_searchBarang.setBorder(null);
        txt_searchBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchBarangKeyReleased(evt);
            }
        });
        jPanel1.add(txt_searchBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 161, 120, 16));

        box_username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/searchbar4.png"))); // NOI18N
        jPanel1.add(box_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 210, 40));

        txt_searchKategori.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txt_searchKategori.setBorder(null);
        txt_searchKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKategoriKeyReleased(evt);
            }
        });
        jPanel1.add(txt_searchKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 161, 120, 16));

        box_username1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/searchbar4.png"))); // NOI18N
        jPanel1.add(box_username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 210, 40));

        tabel_keranjang.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        tabel_keranjang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_keranjang.setGridColor(new java.awt.Color(230, 230, 230));
        tabel_keranjang.setRowHeight(30);
        tabel_keranjang.setSelectionBackground(new java.awt.Color(247, 247, 247));
        tabel_keranjang.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabel_keranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_keranjangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel_keranjang);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 390, 140));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel4.setText("Kategori");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel6.setText("Keranjang");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, -1));

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Bersihkan");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 80, 30));

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
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, -1, -1));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Reset");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 80, 30));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png"))); // NOI18N
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel25MouseExited(evt);
            }
        });
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, -1, -1));

        txt_totalBiaya.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        txt_totalBiaya.setText(this.formatRupiah(0).replace(",00", ""));
        jPanel1.add(txt_totalBiaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, 170, 50));

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

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel7.setText("Total harga :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, -1, -1));

        jLabel29.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Pilih Voucher");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 460, 80, 30));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png"))); // NOI18N
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 460, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("ID Transaksi");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("Total Bayar");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, -1, 40));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setText("Voucher");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, -1, 20));

        txt_kembalian.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jPanel1.add(txt_kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 170, 20));

        txt_id.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt_id.setEnabled(false);
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 170, 20));

        txt_voucher.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txt_voucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_voucherActionPerformed(evt);
            }
        });
        jPanel1.add(txt_voucher, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, 170, 20));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel14.setText("Kembalian");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, -1, -1));

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Cek Voucher");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 460, 80, 30));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png"))); // NOI18N
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 460, -1, -1));

        validasi_voucher.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        validasi_voucher.setForeground(new java.awt.Color(51, 255, 0));
        jPanel1.add(validasi_voucher, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 484, 170, 20));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel3.setText("Barang");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, -1, -1));

        txt_totalBayar.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txt_totalBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_totalBayarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_totalBayarKeyReleased(evt);
            }
        });
        jPanel1.add(txt_totalBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 170, -1));

        txt_tanggal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txt_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 240, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tgl.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchBarangKeyReleased
        tabel_search_with_kategori();
    }//GEN-LAST:event_txt_searchBarangKeyReleased

    private void txt_searchKategoriKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKategoriKeyReleased
        tabel_kategori();
    }//GEN-LAST:event_txt_searchKategoriKeyReleased

    public static String username;
    
    public void bayar(){
        DefaultTableModel model = (DefaultTableModel) tabel_keranjang.getModel();
        Statement st;
        if(Integer.parseInt(txt_totalBayar.getText().replaceAll("\\.", "")) < Integer.parseInt(txt_totalBiaya.getText().replace("Rp", "").replaceAll("\\s+", "").replaceAll("\\.", ""))  ){
            
            new PopUpMessages(this, true, "Informasi", "Total bayar yang dimasukkan kurang", 0).setVisible(true);
        } else {
            if(model.getRowCount()==0){
                System.out.println("error");
            } else {
                try {
                    PopUp popup = new PopUp(this, true, "Konfirmasi", "Apakah yakin ingin melakukan pembayaran?", 0);
                    popup.setVisible(true);
                    int hasil = popup.hasil();
                    
                    if(hasil==0){
                        String id_transaksi, id_barang, jumlah, subTotal;
                        Connection conn = auth.Koneksi.configDB();
                        st = conn.createStatement();

                        for (int i = 0; i < model.getRowCount(); i++) {
                            id_transaksi = txt_id.getText();
                            id_barang = model.getValueAt(i, 0).toString();
                            jumlah = model.getValueAt(i, 3).toString();
                            subTotal = model.getValueAt(i, 4).toString().replace("Rp", "").replaceAll("\\s+", "").replaceAll("\\.", "");
                            String sql = "INSERT INTO detail_barang(`id_transaksi`, `id_barang`, `jumlah`, `subTotal`) "
                                    + "VALUES('"+id_transaksi+"', '"+id_barang+"', '"+jumlah+"', '"+subTotal+"')";
                            st.addBatch(sql);
                             
                        }
                        st.executeBatch();
                   
                        // Insert to table transaksi
                        int totalHarga = Integer.parseInt(txt_totalBiaya.getText().replace("Rp", "").replaceAll("\\s+", "").replaceAll("\\.", ""));
                        int totalBayar = Integer.parseInt(txt_totalBayar.getText().replaceAll("\\.", ""));
                        int kembalian = Integer.parseInt(txt_kembalian.getText().replaceAll("\\.", ""));
                        String query_addTransaksi = "INSERT INTO transaksi(`id_transaksi`, `username`, `tanggal`, "
                                + "`totalHarga`, `totalBayar`, `totalKembalian`, `voucher`) "
                                + "VALUES('"+txt_id.getText()+"', '"+username+"', '"+txt_tanggal.getText()+"', "
                                + ""+totalHarga+", "+totalBayar+", "+kembalian+", "+voucher+")";
                        PreparedStatement pst3 = conn.prepareStatement(query_addTransaksi);
                        pst3.execute();
                        
                        // delete voucher jika ada
                        
                        String query_voucher = "DELETE FROM voucher WHERE id_voucher = '"+txt_voucher.getText()+"'";
                        PreparedStatement pstvoucher = conn.prepareStatement(query_voucher);
                        pstvoucher.execute();
                        
                        new PopUpMessages(this, true, "Berhasil", "Pembayaran berhasil", 1).setVisible(true);
                        // disini
                        InputStream struk = getClass().getResourceAsStream("/iReport/strukPembelian.jrxml");
                        try {
                            
                            JasperDesign jd = JRXmlLoader.load(struk);
                            String sql = "SELECT transaksi.id_transaksi, barang.id_barang, barang.nama, "
                                    + "detail_barang.jumlah, detail_barang.subTotal, transaksi.totalHarga, "
                                    + "transaksi.totalBayar, transaksi.totalKembalian, transaksi.tanggal, "
                                    + "barang.harga_satuan FROM detail_barang, barang, transaksi "
                                    + "WHERE detail_barang.id_barang = barang.id_barang "
                                    + "AND detail_barang.id_transaksi = transaksi.id_transaksi "
                                    + "AND transaksi.id_transaksi = '"+txt_id.getText()+"'";
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
                        tabel_keranjang();
                        tabel_barang();
                        bersihkan();
                        
                    } else {
                        
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            
            }
            
        }

    }
    
    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        if(txt_totalBayar.getText().equals("")){
            new PopUpMessages(this, true, "Informasi", "Total pembayaran harus dimasukkan", 0).setVisible(true);
        } else {
            
                bayar();
           
        }
    }//GEN-LAST:event_jLabel21MouseClicked

    public int voucher = 0;
    
    public void voucher(){
        try {
        if(txt_voucher.getText().equals("")){
            voucher = 0;
            
        } else {
            
                Connection conn = auth.Koneksi.configDB();
                String sql = "SELECT * FROM voucher WHERE id_voucher = '"+txt_voucher.getText()+"'";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);
                if(rs.next()){
                    if(txt_voucher.getText().equals(rs.getString("id_voucher"))){
                        if(Integer.parseInt(rs.getString("nilai")) > Integer.parseInt(txt_totalBiaya.getText().replace("Rp", "").replaceAll("\\s+", "").replaceAll("\\.", "")) ){
                            new PopUpMessages(this, true, "Gagal", "Voucher tidak dapat digunakan", 2).setVisible(true);
                            txt_voucher.setText("");
                        } else {
                            voucher = Integer.parseInt(rs.getString("nilai"));
                            new PopUpMessages(this, true, "Informasi", "Voucher berhasil digunakan", 0).setVisible(true);

                            validasi_voucher.setText("Voucher : " + this.formatRupiah(Integer.parseInt(rs.getString("nilai"))).replace(",00", ""));
                            voucher = Integer.parseInt(rs.getString("nilai"));
                            txt_totalBayar.setText("0");
                            kembalian();
                            jumlahBiaya();
                        }
                        
                    } 
               
                } else {
                    new PopUpMessages(this, true, "Informasi", "Voucher tidak ditemukan", 0).setVisible(true);
                    txt_voucher.setText("");
                }
                 }
            } catch (Exception e) {
                System.out.println(e);
            }
    }
    
    public void id_transaksi(){
        try {
            String sql = "SELECT id_transaksi FROM detail_barang ORDER BY id_transaksi DESC";
            java.sql.Connection conn=(Connection)auth.Koneksi.configDB();
            java.sql.PreparedStatement ps=conn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery(sql);
            if ( rs.next()){
                String idTransaksi = rs.getString("id_transaksi").substring(2);
                String tr = "TR" +(Integer.parseInt(idTransaksi)+1);
                txt_id.setText(tr);
            } else {
                txt_id.setText("TR100");
            }
        } catch (Exception e) {
            System.out.println("Koneksi gagal");
        }
    }
    
    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));

    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
       jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));

    }//GEN-LAST:event_jLabel21MouseExited

    
    public void bersihkan(){
        id_transaksi();
        tabel_keranjang();
        txt_totalBiaya.setText("0");
        voucher = 0;
        txt_voucher.setText("");
        validasi_voucher.setText("");
        txt_totalBayar.setText("0");
        txt_kembalian.setText("0");
        txt_searchBarang.setText("");
        txt_searchKategori.setText("");
        txt_voucher.disable();

        txt_totalBayar.disable();

    }
    
    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        bersihkan();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        txt_searchKategori.setText("");
        this.save_id_kategori = "";
        txt_searchBarang.setText("");
        tabel_kategori();
        tabel_barang();
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseEntered
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
    }//GEN-LAST:event_jLabel25MouseEntered

    private void jLabel25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseExited
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
                                      
    }//GEN-LAST:event_jLabel25MouseExited

    public void tabel_search_with_kategori(){
        if (txt_searchBarang.getText().equals("")){
            txt_searchKategori.setText("");
            this.save_id_kategori = "";
            tabel_kategori();
            tabel_barang();
        } else {
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
                String sql = "SELECT id_barang, nama, kategori, harga_satuan, stok FROM barang JOIN kategori ON barang.id_kategori = kategori.id_kategori WHERE kategori.id_kategori = '"+save_id_kategori+"' AND nama LIKE '%"+txt_searchBarang.getText()+"%' OR nama LIKE '%"+txt_searchBarang.getText()+"%'";
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
    }
    
    private void tabel_kategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_kategoriMouseClicked
        int baris = tabel_kategori.rowAtPoint(evt.getPoint());
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
                    + "WHERE kategori.id_kategori = '"+tabel_kategori.getValueAt(baris, 0).toString()+"'";
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
            this.save_id_kategori = tabel_kategori.getValueAt(baris, 0).toString();
            for (int i = 0; i <= 4; i++) {
                tabel_barang.getColumnModel().getColumn(i).setCellRenderer(new CustomTable());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_tabel_kategoriMouseClicked

    public void jumlahBiaya(){
        int jumlahBaris = tabel_keranjang.getRowCount();
        int jumlahBiaya = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(tabel_keranjang.getValueAt(i, 3).toString());
            hargaBarang = Integer.parseInt(tabel_keranjang.getValueAt(i, 2).toString().replace("Rp", "").replaceAll("\\s+", "").replaceAll("\\.", ""));
            jumlahBiaya = jumlahBiaya + (jumlahBarang * hargaBarang);
            
        }
        txt_totalBiaya.setText(this.formatRupiah(jumlahBiaya).replace(",00", ""));
        //txt_totalBiaya.setText(String.valueOf(jumlahBiaya));
        if (voucher==0){
            // ??
        } else {
            jumlahBiaya = jumlahBiaya - voucher;
            txt_totalBiaya.setText(this.formatRupiah(jumlahBiaya).replace(",00", ""));
            //txt_totalBiaya.setText(String.valueOf(jumlahBiaya));
        }
    }
    
 
    private void tabel_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barangMouseClicked
        txt_totalBayar.enable();
        txt_voucher.enable();
   
        int baris = tabel_barang.rowAtPoint(evt.getPoint());

        DefaultTableModel model = (DefaultTableModel) tabel_keranjang.getModel();
         
        try {
            PopUpInput popup = new PopUpInput(this, true, "Konfirmasi", "Masukkan Jumlah Barang");
            popup.setVisible(true);
            String jumlah_barang = popup.isi_nilai();
    
            int hasil = popup.hasil();
       
                if ( hasil == 0){
                    if(jumlah_barang.equals("")){
                    jumlah_barang = "1";
                }
                if(Integer.parseInt(jumlah_barang) > Integer.parseInt(tabel_barang.getValueAt(baris, 4).toString())){
                    PopUpMessages message = new PopUpMessages(this, true, "Gagal", "Jumlah yang anda masukkan lebih dari stok barang yang ada!", 2);
                    message.setFontSize(16);
                    message.setVisible(true);
            
                } else {

                    int subTotal, harga, jumlah;
                    
                    String hargaa = tabel_barang.getValueAt(baris, 3).toString().replace("Rp", "").replaceAll("\\s+", "").replaceAll("\\.", "");
                    harga = Integer.parseInt(hargaa);
                    
                    
                    jumlah = Integer.parseInt(jumlah_barang);
                    subTotal = harga * jumlah;

                    model.addRow(new Object[]{
                        tabel_barang.getValueAt(baris, 0).toString(),
                        tabel_barang.getValueAt(baris, 1).toString(),
                        this.formatRupiah(harga).replace(",00", "").toString(),
                        jumlah_barang,
                        this.formatRupiah(subTotal).replace(",00", "").toString()
                        });
                jumlahBiaya();
                }
            }
            
            
        } catch (Exception e) {
         
            System.out.println(e);
        }

        for (int i = 0; i <= 4; i++) {
                tabel_keranjang.getColumnModel().getColumn(i).setCellRenderer(new CustomTable());
            }

        //tabel_keranjang();
    }//GEN-LAST:event_tabel_barangMouseClicked

    private void tabel_keranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_keranjangMouseClicked
        
        int baris = tabel_keranjang.rowAtPoint(evt.getPoint());
        String nama_barang = tabel_keranjang.getValueAt(baris, 1).toString();
        try {
            PopUp popup = new PopUp(this, true, "Konfirmasi", "Apakah anda yakin ingin menghapus data?", 0);
            popup.setVisible(true);
            int hasil = popup.hasil();
            
            if(hasil == 0){
                DefaultTableModel model = (DefaultTableModel) tabel_keranjang.getModel();
                int row = tabel_keranjang.getSelectedRow();
                model.removeRow(row);
                jumlahBiaya();
            }
        } catch (Exception e) {
            e.getMessage();
        }                             
    }//GEN-LAST:event_tabel_keranjangMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        this.dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back_hover.png")));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png")));
    }//GEN-LAST:event_jLabel12MouseExited

    
    
    public void kembalian(){
        int jumlahHarga, kembalian, totalBayar;
        
        jumlahHarga = Integer.parseInt(txt_totalBiaya.getText().replace("Rp", "").replaceAll("\\s+", "").replaceAll("\\.", ""));
        totalBayar = Integer.parseInt(txt_totalBayar.getText().replace("Rp", "").replaceAll("\\s+", "").replaceAll("\\.", ""));
        
        try {
        
                if (totalBayar < jumlahHarga){
                    txt_kembalian.setText("0");
                } else {
                    
                    try {
                        kembalian = totalBayar - jumlahHarga;
                        String kembaliannya = this.formatRupiah(kembalian).replace("Rp.", "").replaceAll("\\s+", "").replace(",00", "");
                        txt_kembalian.setText(kembaliannya);
                    } catch (Exception e) {
                        System.out.println("error");
                    }    
            }     
        } catch (Exception e) {
            System.out.println("error");
        }

    }
    
    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        voucher();
//        kembalian();
//        jumlahBiaya();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
    }//GEN-LAST:event_jLabel27MouseExited

    private void txt_totalBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalBayarKeyReleased
        try {
            kembalian();
        } catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_txt_totalBayarKeyReleased

    private void txt_totalBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalBayarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE){
            if(txt_totalBayar.getText().length() == 1){
                txt_totalBayar.setText("0");
            }
        }
    }//GEN-LAST:event_txt_totalBayarKeyPressed

    private void txt_voucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_voucherActionPerformed
        voucher();
        kembalian();
        jumlahBiaya();
    }//GEN-LAST:event_txt_voucherActionPerformed

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

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        Pilih_Voucher pilihVoucher = new Pilih_Voucher(this, true);
        pilihVoucher.setVisible(true);
        voucher();
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_hover_00000.png")));
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_action_00000.png")));
    }//GEN-LAST:event_jLabel28MouseExited

    public void tabel_keranjang(){
        DefaultTableModel model = new DefaultTableModel();
        
        tabel_keranjang.getTableHeader().setDefaultRenderer(new CustomTableHeader());
        tabel_keranjang.setBorder(new EmptyBorder(10, 5, 10, 5));
        tabel_keranjang.setDefaultEditor(Object.class, null);
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        model.addColumn("Sub Total");
        
        tabel_keranjang.setModel(model);
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
            java.util.logging.Logger.getLogger(Pembelian_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembelian_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembelian_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembelian_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembelian_Barang().setVisible(true);
            }
        });
    }

    public String save_id_kategori;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel box_username;
    private javax.swing.JLabel box_username1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabel_barang;
    private javax.swing.JTable tabel_kategori;
    public final javax.swing.JTable tabel_keranjang = new javax.swing.JTable();
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_kembalian;
    private javax.swing.JTextField txt_searchBarang;
    private javax.swing.JTextField txt_searchKategori;
    private javax.swing.JLabel txt_tanggal;
    private javax.swing.JFormattedTextField txt_totalBayar;
    private javax.swing.JLabel txt_totalBiaya;
    public static final javax.swing.JTextField txt_voucher = new javax.swing.JTextField();
    private javax.swing.JLabel validasi_voucher;
    // End of variables declaration//GEN-END:variables
}
