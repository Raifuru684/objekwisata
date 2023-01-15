/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wisata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raifuru
 */
public class Wisata extends javax.swing.JFrame {
    Koneksi koneksi = new Koneksi();

    private DefaultTableModel model;
    
    private void autonumber(){
        try{
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM daftar ORDER BY id DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()){
                String IdPelanggan = r.getString("id").substring(2);
                String KP = "" + (Integer.parseInt(IdPelanggan) + 1);
                String Nol = "";
                
                if(KP.length()==1){
                    Nol = "00";
                }else if(KP.length()==2){
                    Nol = "0";
                }else if(KP.length()==3){
                    Nol = "";
                }
                
                txId.setText("KP" + Nol + KP);
                
            }else{
                txId.setText("KP001");
            }
            r.close();
            s.close();
        }catch(Exception e){
            System.out.println("autonumber error");
        }
    }
    
    public void clear(){
        txNama.setText("");
        txNoTelp.setText("");
        txHarga.setText("");
    }
    
    public void loadData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM daftar";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                Object[] o = new Object[6];
                o [0] = r.getString("id");
                o [1] = r.getString("nama");
                o [2] = r.getString("jenis_kelamin");
                o [3] = r.getString("tujuan");
                o [4] = r.getString("no_telp");
                o [5] = r.getString("harga");
                
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch(SQLException e){
            System.err.println("Terjadi Kesalahan");
        }
    }
    
    public Wisata() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        txId.setEnabled(false);
        
        model = new DefaultTableModel();
        
        jTable1.setModel(model);
        
        model.addColumn("ID Pelanggan");
        model.addColumn("Nama");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Tujuan");
        model.addColumn("No Telpon");
        model.addColumn("Harga");
        
        loadData();
        autonumber();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbJenisKelamin = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbTujuan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txNoTelp = new javax.swing.JTextField();
        txHarga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonSimpan = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txCari = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(130, 94, 114));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TOUR WISATA INDONESIA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 701, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 149, -1, -1));

        txNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNamaActionPerformed(evt);
            }
        });
        getContentPane().add(txNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 146, 140, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jenis Kelamin");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 184, -1, -1));

        cbJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki Laki", "Perempuan", " " }));
        cbJenisKelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJenisKelaminActionPerformed(evt);
            }
        });
        getContentPane().add(cbJenisKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 184, 140, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tujuan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 216, -1, -1));

        cbTujuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bali", "Lombok", "Jakarta", "Samarinda" }));
        getContentPane().add(cbTujuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 215, 140, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No Telpon");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Harga");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 288, -1, -1));

        txNoTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNoTelpActionPerformed(evt);
            }
        });
        getContentPane().add(txNoTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 247, 140, -1));
        getContentPane().add(txHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 285, 140, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 670, 130));

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 166, -1, -1));

        buttonEdit.setText("Edit");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });
        getContentPane().add(buttonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 207, 67, -1));

        buttonHapus.setText("Hapus");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });
        getContentPane().add(buttonHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 248, 67, -1));

        buttonBatal.setText("Batal");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
            }
        });
        getContentPane().add(buttonBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 282, 67, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID Pelanggan");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 116, -1, -1));
        getContentPane().add(txId, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 113, 139, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cari Data");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 116, -1, -1));

        txCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCariKeyTyped(evt);
            }
        });
        getContentPane().add(txCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 113, 139, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\62822\\Documents\\Latihan 1 dan 2\\objekwisata\\bg.png")); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 700, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNamaActionPerformed

    private void txNoTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNoTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNoTelpActionPerformed

    private void cbJenisKelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJenisKelaminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJenisKelaminActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        String id = txId.getText();
        String nama = txNama.getText();
        String jenis_kelamin = (String)cbJenisKelamin.getSelectedItem();
        String tujuan = (String)cbTujuan.getSelectedItem();
        String no_telp = txNoTelp.getText();
        String harga = txHarga.getText();
        
        try{
            Connection c = Koneksi.getKoneksi();
            String sql = "INSERT INTO daftar VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, nama);
            p.setString(3, jenis_kelamin);
            p.setString(4, tujuan);
            p.setString(5, no_telp);
            p.setString(6, harga);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
        }catch(SQLException e){
            System.out.println("Terjadi Kesalahan");
        }finally{
            loadData();
            autonumber();
            clear();
        }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        int i = jTable1.getSelectedRow();
        if(i == -1){
            return;
        }
        String id = (String)model.getValueAt(i, 0);
        String nama = txNama.getText();
        String jenis_kelamin = (String)cbJenisKelamin.getSelectedItem();
        String tujuan = (String)cbTujuan.getSelectedItem();
        String no_telp = txNoTelp.getText();
        String harga = txHarga.getText();
        
        try{
            Connection c = Koneksi.getKoneksi();
            String sql = "UPDATE daftar SET nama = ?, jenis_kelamin = ?, tujuan = ?, no_telp = ?, harga = ? WHERE id = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, nama);
            p.setString(2, jenis_kelamin);
            p.setString(3, tujuan);
            p.setString(4, no_telp);
            p.setString(5, harga);
            p.setString(6, id);
            
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dirubah");
            buttonSimpan.setEnabled(true);
            clear();
        }catch(SQLException e){
            System.out.println("Update Error");
        }finally{
            loadData();
            autonumber();
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        int i = jTable1.getSelectedRow();
        if(i == -1){
            return;
        }
        
        String id = (String)model.getValueAt(i, 0);
        
        int question = JOptionPane.showConfirmDialog(null, "Anda Yakin Ingin Menghapus Data?","Konfirmasi", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(question == JOptionPane.OK_OPTION){
            try{
                Connection c = Koneksi.getKoneksi();
                String sql = "DELETE FROM daftar WHERE id = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, id);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            }catch(SQLException e){
                System.out.println("Terjadi Kesalahan");
            }finally{
                loadData();
                autonumber();
                clear();
            }
        }
        if(question == JOptionPane.CANCEL_OPTION){
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        
        clear();
        loadData();
        buttonSimpan.setEnabled(true);
        autonumber();
    }//GEN-LAST:event_buttonBatalActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        buttonSimpan.setEnabled(false);
        int i = jTable1.getSelectedRow();
        if (i == -1){
            return;
        }
        
        String id = (String)model.getValueAt(i, 0);
        txId.setText(id);
        String nama = (String)model.getValueAt(i, 1);
        txNama.setText(nama);
        String jenis_kelamin = (String)model.getValueAt(i, 2);
        cbJenisKelamin.setSelectedItem(jenis_kelamin);
        String tujuan = (String)model.getValueAt(i, 3);
        cbTujuan.setSelectedItem(tujuan);
        String no_telp = (String)model.getValueAt(i, 4);
        txNoTelp.setText(no_telp);
        String harga = (String)model.getValueAt(i, 5);
        txHarga.setText(harga);
    }//GEN-LAST:event_jTable1MouseClicked

    private void txCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCariKeyTyped
        DefaultTableModel tabel = new DefaultTableModel();
        
        tabel.addColumn("ID Pelanggan");
        tabel.addColumn("Nama");
        tabel.addColumn("Jenis Kelamin");
        tabel.addColumn("Tujuan");
        tabel.addColumn("No Telpon");
        tabel.addColumn("Harga");
        
        try{
            Connection c = Koneksi.getKoneksi();
            String sql = "Select * from daftar where nama like '%" + txCari.getText() + "%'";
            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                tabel.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                });
            }
            jTable1.setModel(tabel);
            loadData();
        }catch(Exception e){
           System.out.println("Cari Data Error");
        }finally{
        }
    }//GEN-LAST:event_txCariKeyTyped

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
            java.util.logging.Logger.getLogger(Wisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wisata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox<String> cbJenisKelamin;
    private javax.swing.JComboBox<String> cbTujuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txCari;
    private javax.swing.JTextField txHarga;
    private javax.swing.JTextField txId;
    private javax.swing.JTextField txNama;
    private javax.swing.JTextField txNoTelp;
    // End of variables declaration//GEN-END:variables
}
