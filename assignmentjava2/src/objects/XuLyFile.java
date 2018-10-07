/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author tvmin
 */
public class XuLyFile {

    public ArrayList<nhanVien> getStaffFromFile(String filePath) {
        ArrayList<nhanVien> nhanViens = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            nhanVien nvArr[] = (nhanVien[]) ois.readObject();
            nhanViens.addAll(Arrays.asList(nvArr));
            fis.close();
            ois.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XuLyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhanViens;
    }

    public void saveStaff(ArrayList<nhanVien> staffs) {
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\tvmin\\Desktop\\Java\\nhanvien.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            nhanVien nv[] = new nhanVien[staffs.size()];
            nv = staffs.toArray(nv);
            oos.writeObject(nv);
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e);
        }
    }

    public void timMaSo(String maNV, ArrayList<nhanVien> listNV) {
        int index = 0;
        ArrayList<nhanVien> nvs = new ArrayList<>();
        for (int i = 0; i < listNV.size(); i++) {
            nhanVien nv = listNV.get(i);
            if (maNV.equalsIgnoreCase(nv.maNV)) {
                index = i;
                nvs.add(nv);
                this.saveStaff(nvs);
                break;
            }
        }
    }
}
