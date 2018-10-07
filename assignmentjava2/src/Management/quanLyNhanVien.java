/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objects.XuLyFile;
import objects.nhanVien;

/**
 *
 * @author tvmin
 */
public class quanLyNhanVien extends javax.swing.JFrame {

    ArrayList<nhanVien> list = new ArrayList<>();
    int index;

    /**
     * Creates new form quanLyNhanVien
     */
    public quanLyNhanVien() {
        initComponents();
        list.add(new nhanVien("ph01", "nguyen thu thao", 17, "thao@fpt.edu.vn", 6000000));
        index = 0;
        fillToTable();
        getTime();
        setLocationRelativeTo(null);
    }

    private void getTime(){
        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    try{
                        SimpleDateFormat sdf = new SimpleDateFormat();
                        sdf.applyPattern("hh:mm  ss aa");
                        Date date = new Date();
                        String time = sdf.format(date);
                        lblTIme.setText(time);
                        //t1.sleep(1000);
                    }catch(Exception e){
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        t1.start();
    }
    
    public void addEmployee() {
        nhanVien nv = new nhanVien();
        nv.maNV = txt_manv.getText();
        nv.hoTen = txt_hoten.getText();
        nv.tuoi = Double.parseDouble(txt_tuoi.getText());
        nv.email = txt_email.getText();
        nv.luong = Double.parseDouble(txt_luong.getText());
        list.add(nv);
    }

    public void removeEmployee() {
        int index = tbl_qlsv.getSelectedRow();
        JOptionPane.showMessageDialog(null, " Xoa thanh cong");
        list.remove(index);
    }

    public void updateEmployee() {
        int index = tbl_qlsv.getSelectedRow();
        nhanVien nv = new nhanVien();
        nv.maNV = txt_manv.getText();
        nv.hoTen = txt_hoten.getText();
        nv.tuoi = Double.parseDouble(txt_tuoi.getText());
        nv.email = txt_email.getText();
        nv.luong = Double.parseDouble(txt_luong.getText());
    }

    public void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_qlsv.getModel();
        model.setRowCount(0);
        for (nhanVien nv : list) {
            Object[] row = new Object[]{nv.getMaNV(), nv.getHoTen(), nv.getTuoi(), nv.getEmail(), nv.getLuong()};
            model.addRow(row);
        }
    }

    public void showDetail(int index) {
        
        nhanVien nv = new nhanVien();
        txt_manv.setText(tbl_qlsv.getValueAt(index, 0).toString());
        txt_hoten.setText(tbl_qlsv.getValueAt(index, 1).toString());
        txt_tuoi.setText(tbl_qlsv.getValueAt(index, 2).toString());
        txt_email.setText(tbl_qlsv.getValueAt(index, 3).toString());
        txt_luong.setText(tbl_qlsv.getValueAt(index, 4).toString());
        tbl_qlsv.setRowSelectionInterval(index, index);
    }

    public void saveFile() {
        try{
            if (isNullOrEmptyString(txt_manv.getText())) {
                JOptionPane.showMessageDialog(null, "Ma nhan vien khong de trong");
                txt_manv.requestFocus();
                return;
            }
            if (isNullOrEmptyString(txt_hoten.getText())) {
                JOptionPane.showMessageDialog(null, "Ho ten khong de trong");
                txt_hoten.requestFocus();
                return;
            }
            if (isNullOrEmptyString(txt_tuoi.getText()) || !validateTuoi(Double.parseDouble(txt_tuoi.getText()))) {
                JOptionPane.showMessageDialog(null, "Tuoi khong duoc de trong va tuoi nhap tu 16 den 55");
                txt_tuoi.requestFocus();
                return;
            }
            if (isNullOrEmptyString(txt_email.getText()) || !validateMail(txt_email.getText())) {
                JOptionPane.showMessageDialog(null, "Email khong duoc de trong va nhap dung dinh dang");
                txt_email.requestFocus();
                return;
            }
            if (isNullOrEmptyString(txt_luong.getText()) || !validateLuong(Double.parseDouble(txt_luong.getText()))) {
                JOptionPane.showMessageDialog(null, "Luong khong dc de trong va lon hon 5000000");
                txt_luong.requestFocus();
                return;
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "loi sai dinh dang");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }

    public boolean isNullOrEmptyString(String v) {
        boolean check;
        check = v.trim().isEmpty() || v.isEmpty();
        return check;
    }

    public boolean validateTuoi(double v) {
        boolean check = true;
        if (v < 16 || v > 55) {
            check = false;
        }
        return check;
    }

    public boolean validateLuong(double v) {
        boolean check = true;
        if (v < 5000000) {
            check = false;
        }
        return check;
    }

    public boolean validateMail(String v) {
        return v.matches("\\w+@\\w+\\.+\\w+.+\\w+");
    }

    
    private int findE(String id){
        for(nhanVien x : list){
            if(x.getMaNV().equalsIgnoreCase(id)){
                return x.getMaNV().indexOf(id);
            }
            
        }
        return -1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_manv = new javax.swing.JTextField();
        txt_hoten = new javax.swing.JTextField();
        txt_tuoi = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_luong = new javax.swing.JTextField();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_find = new javax.swing.JButton();
        btn_open = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_qlsv = new javax.swing.JTable();
        lblTIme = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Mã nhân viên");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Họ và tên");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Tuổi");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Lương");

        txt_manv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_manv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_manvActionPerformed(evt);
            }
        });

        txt_hoten.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txt_tuoi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txt_email.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txt_luong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_luong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_luongActionPerformed(evt);
            }
        });

        btn_new.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_new.setText("New");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_save.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_find.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_find.setText("Find");
        btn_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findActionPerformed(evt);
            }
        });

        btn_open.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_open.setText("Open");
        btn_open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importStaffFromFile(evt);
            }
        });

        btn_exit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_exit.setText("Exit");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        tbl_qlsv.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl_qlsv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ và tên", "Tuổi", "Email", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_qlsv.setShowHorizontalLines(false);
        tbl_qlsv.setShowVerticalLines(false);
        tbl_qlsv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_qlsvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_qlsv);

        lblTIme.setText("jLabel10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(44, 44, 44))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(76, 76, 76)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_hoten)
                                            .addComponent(txt_tuoi, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(63, 63, 63)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_email)
                                            .addComponent(txt_luong))))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_find, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_open, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(txt_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(125, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(124, 124, 124))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTIme)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTIme))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_new))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_save))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_tuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_find))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_open)
                    .addComponent(txt_luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(btn_exit)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_luongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_luongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_luongActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        txt_manv.setText("");
        txt_hoten.setText("");
        txt_tuoi.setText("");
        txt_email.setText("");
        txt_luong.setText("");
    }//GEN-LAST:event_btn_newActionPerformed

    private void txt_manvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_manvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_manvActionPerformed

    private void tbl_qlsvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_qlsvMouseClicked
        // TODO add your handling code here:
        try{
            index = tbl_qlsv.getSelectedRow();
            this.showDetail(index);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_tbl_qlsvMouseClicked

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        this.saveFile();
        this.updateEmployee();
        this.addEmployee();
        this.fillToTable();
        XuLyFile xl = new XuLyFile();
        xl.saveStaff(list);
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        this.removeEmployee();
        this.fillToTable();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void importStaffFromFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importStaffFromFile
        JFileChooser chooser = new JFileChooser();
        chooser.setSize(500, 400);
        int value = chooser.showOpenDialog(this);
        if (value == JFileChooser.OPEN_DIALOG) {
            File file = chooser.getSelectedFile();
            String filePath = file.getPath();
            XuLyFile xl = new XuLyFile();
            list = xl.getStaffFromFile(filePath);
            this.fillToTable();
        }
    }//GEN-LAST:event_importStaffFromFile

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
        try {
            System.exit(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findActionPerformed
        // TODO add your handling code here:
        try{
            String test = JOptionPane.showInputDialog(null,"hay nhap ma nhan vien can tim","thong bao",JOptionPane.INFORMATION_MESSAGE);
            if(findE(test) != -1){
                showDetail(findE(test));
                JOptionPane.showMessageDialog(null, "Da tim thay nhan vien");
            }else{
                JOptionPane.showMessageDialog(null, "khong tim thay nhan vien");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Loi " + e);
        }
//        this.fillToTable();
//        XuLyFile x1 = new XuLyFile();
//        String maNV = txt_manv.getText();
//        x1.timMaSo(maNV, list);
        
    }//GEN-LAST:event_btn_findActionPerformed

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
            java.util.logging.Logger.getLogger(quanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quanLyNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_find;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_open;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTIme;
    private javax.swing.JTable tbl_qlsv;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_luong;
    private javax.swing.JTextField txt_manv;
    private javax.swing.JTextField txt_tuoi;
    // End of variables declaration//GEN-END:variables
}
