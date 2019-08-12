package crud;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.*;
import java.awt.print.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.util.JRLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import net.sf.jasperreports.compilers.GroovyEvaluator;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */


public class mahasiswa extends javax.swing.JFrame {
    private DefaultTableModel tabmode;
    private ResultSet hasil;
    private String nama,nim,kelas,semester,status,pesan;
    File imageFile = null;
    private String file;
    CRUD ob = new CRUD();
    
    /**
     * Creates new form mahasiswa
     */
    public mahasiswa() throws SQLException{
        initComponents();
        tampil_database();
        tampilmatkul();
        tampilInstruktur();
        tampilTAkademik();
        
        txt_id.setVisible(false);
    }
    
    public void otomatis()
    {
        int z = tbl_maha.getRowCount()+1;
        String ba = Integer.toString(z);
        txt_id.setText(ba);
        
//        try{
//            Connection con = KoneksiMysql.getKoneksi();
//            Statement stt = con.createStatement();
//            String sql = "SELECT id from data order by id desc";
//            ResultSet res=stt.executeQuery(sql);
//            
//            if (res.next()){
//                int no_t = Integer.parseInt(res.getString("id"))+1;
//                txt_id.setText(Integer.toString(no_t));
//            }else{
//                int no_t = 1;
//                txt_id.setText(Integer.toString(no_t));
//            }
//            res.close();
//        }catch(Exception e){
//            
//        }
        
    }
    
    public void tampilmatkul(){
        try{
            //tes koneksi
            Statement stat = (Statement) KoneksiMysql.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel 
            String sql = "SELECT * FROM matkul";
            ResultSet res = stat.executeQuery(sql);
//                         cb_matkul.addItem("--Mata Kuliah--");   
            //baca data dan tampilkan pada text produk dan harga
           while(res.next())
            {
                cb_matkul.addItem(res.getString("mata_kul"));
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
       public void tampilInstruktur(){
        try{
            //tes koneksi
            Statement stat = (Statement) KoneksiMysql.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel 
            String sql = "SELECT * FROM instruktur";
            ResultSet res = stat.executeQuery(sql);
//                         cb_matkul.addItem("--Mata Kuliah--");   
            //baca data dan tampilkan pada text produk dan harga
           while(res.next())
            {
                cb_instruktur.addItem(res.getString("dosen"));
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
       
       public void tampilTAkademik(){
        try{
            //tes koneksi
            Statement stat = (Statement) KoneksiMysql.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel 
            String sql = "SELECT * FROM akademik";
            ResultSet res = stat.executeQuery(sql);
//                         cb_matkul.addItem("--Mata Kuliah--");   
            //baca data dan tampilkan pada text produk dan harga
           while(res.next())
            {
                cb_akademik.addItem(res.getString("tahun"));
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    
    public void cetakA()
    {
         try {
       JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("kelasA.jasper"), null, KoneksiMysql.getKoneksi());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
      public void cetakB()
    {
         try {
       JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("kelasB.jasper"), null, KoneksiMysql.getKoneksi());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
      
       public void cetakC()
    {
         try {
       JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("kelasC.jasper"), null, KoneksiMysql.getKoneksi());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
       
    public void cetakD()
    {
         try {
       JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("kelasD.jasper"), null, KoneksiMysql.getKoneksi());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
     public void cetakE()
    {
         try {
       JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("kelasE.jasper"), null, KoneksiMysql.getKoneksi());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    public void FilterAngka (KeyEvent b)
    {
        if (Character.isAlphabetic(b.getKeyChar())){
        b.consume();
        JOptionPane.showMessageDialog(null, "Masukkan Angka saja ", "Peringatan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
      public void FilterHuruf (KeyEvent a)
    {
        if (Character.isDigit(a.getKeyChar())){
        a.consume();
        JOptionPane.showMessageDialog(null, "Masukkan Huruf saja ", "Peringatan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void cariA()
    {
          Object[]baris={"nama","nim","kelas","semester","status"};
        tabmode = new DefaultTableModel(null,baris);
        tbl_maha.setModel(tabmode);
        try{
            hasil = ob.tampilData("select * from data where nim='"+cari.getText()+"'");
            while (hasil.next()){
            ob.setnama(hasil.getString("nama"));
            ob.setnim(hasil.getString("nim"));
            ob.setkelas(hasil.getString("kelas"));
            ob.setsemester(hasil.getString("semester"));
            ob.setstatus(hasil.getString("status"));
        String[] data = {ob.getnama(),ob.getnim(),ob.getkelas(),ob.getsemester(),ob.getstatus()};
        tabmode.addRow (data);
            }
        }catch (Exception e){
        
        }
    }
    
    public void cariB()
    {
          Object[]baris={"nama","nim","kelas","semester","status"};
        tabmode = new DefaultTableModel(null,baris);
        tbl_maha.setModel(tabmode);
        try{
            hasil = ob.tampilData("select * from data_b where nim='"+cari.getText()+"'");
            while (hasil.next()){
            ob.setnama(hasil.getString("nama"));
            ob.setnim(hasil.getString("nim"));
            ob.setkelas(hasil.getString("kelas"));
            ob.setsemester(hasil.getString("semester"));
            ob.setstatus(hasil.getString("status"));
        String[] data = {ob.getnama(),ob.getnim(),ob.getkelas(),ob.getsemester(),ob.getstatus()};
        tabmode.addRow (data);
            }
        }catch (Exception e){
        
        }
    }
    
     public void cariC()
    {
          Object[]baris={"nama","nim","kelas","semester","status"};
        tabmode = new DefaultTableModel(null,baris);
        tbl_maha.setModel(tabmode);
        try{
            hasil = ob.tampilData("select * from data_c where nim='"+cari.getText()+"'");
            while (hasil.next()){
            ob.setnama(hasil.getString("nama"));
            ob.setnim(hasil.getString("nim"));
            ob.setkelas(hasil.getString("kelas"));
            ob.setsemester(hasil.getString("semester"));
            ob.setstatus(hasil.getString("status"));
        String[] data = {ob.getnama(),ob.getnim(),ob.getkelas(),ob.getsemester(),ob.getstatus()};
        tabmode.addRow (data);
            }
        }catch (Exception e){
        
        }
    }
     
      public void cariD()
    {
          Object[]baris={"nama","nim","kelas","semester","status"};
        tabmode = new DefaultTableModel(null,baris);
        tbl_maha.setModel(tabmode);
        try{
            hasil = ob.tampilData("select * from data_d where nim='"+cari.getText()+"'");
            while (hasil.next()){
            ob.setnama(hasil.getString("nama"));
            ob.setnim(hasil.getString("nim"));
            ob.setkelas(hasil.getString("kelas"));
            ob.setsemester(hasil.getString("semester"));
            ob.setstatus(hasil.getString("status"));
        String[] data = {ob.getnama(),ob.getnim(),ob.getkelas(),ob.getsemester(),ob.getstatus()};
        tabmode.addRow (data);
            }
        }catch (Exception e){
        
        }
    }
      
        public void cariE()
    {
          Object[]baris={"nama","nim","kelas","semester","status"};
        tabmode = new DefaultTableModel(null,baris);
        tbl_maha.setModel(tabmode);
        try{
            hasil = ob.tampilData("select * from data_d where nim='"+cari.getText()+"'");
            while (hasil.next()){
            ob.setnama(hasil.getString("nama"));
            ob.setnim(hasil.getString("nim"));
            ob.setkelas(hasil.getString("kelas"));
            ob.setsemester(hasil.getString("semester"));
            ob.setstatus(hasil.getString("status"));
        String[] data = {ob.getnama(),ob.getnim(),ob.getkelas(),ob.getsemester(),ob.getstatus()};
        tabmode.addRow (data);
            }
        }catch (Exception e){
        
        }
    }
   
   public void printB()
   {
        JasperReport jasRep;
        JasperPrint jasPri;
        Map<String, Object> nik = new HashMap<String, Object>();
        JasperDesign jasDes;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/web_db", "root", "");
 
            File report = new File("src/crud/lap3.jrxml");
            jasDes = JRXmlLoader.load(report);
            nik.put("klsb", txtnama.getText());
            nik.put("matkul", cb_matkul.getSelectedItem());
            nik.put("instruktur", cb_instruktur.getSelectedItem());
            nik.put("ta", cb_akademik.getSelectedItem());
            nik.put("jadwal", cb_hari.getSelectedItem());
            nik.put("jam", cb_jam.getSelectedItem());
             nik.put("gambar", txt_gambar.getIcon());
            jasRep = JasperCompileManager.compileReport(jasDes);
            jasPri = JasperFillManager.fillReport(jasRep, nik, con);
            JasperViewer.viewReport(jasPri, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
   }
    
     public void printC()
   {
        JasperReport jasRep;
        JasperPrint jasPri;
        Map<String, Object> nik = new HashMap<String, Object>();
        JasperDesign jasDes;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/web_db", "root", "");
 
            File report = new File("src/crud/lap4.jrxml");
            jasDes = JRXmlLoader.load(report);
            nik.put("klsc", txtnama.getText());
            nik.put("matkul", cb_matkul.getSelectedItem());
            nik.put("instruktur", cb_instruktur.getSelectedItem());
            nik.put("ta", cb_akademik.getSelectedItem());
            nik.put("jadwal", cb_hari.getSelectedItem());
            nik.put("jam", cb_jam.getSelectedItem());
             nik.put("gambar", txt_gambar.getIcon());
            jasRep = JasperCompileManager.compileReport(jasDes);
            jasPri = JasperFillManager.fillReport(jasRep, nik, con);
            JasperViewer.viewReport(jasPri, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
   }
     
     
    public void printD()
   {
        JasperReport jasRep;
        JasperPrint jasPri;
        Map<String, Object> nik = new HashMap<String, Object>();
        JasperDesign jasDes;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/web_db", "root", "");
 
            File report = new File("src/crud/lap5.jrxml");
            jasDes = JRXmlLoader.load(report);
            nik.put("klsd", txtnama.getText());
            nik.put("matkul", cb_matkul.getSelectedItem());
            nik.put("instruktur", cb_instruktur.getSelectedItem());
            nik.put("ta", cb_akademik.getSelectedItem());
            nik.put("jadwal", cb_hari.getSelectedItem());
            nik.put("jam", cb_jam.getSelectedItem());
             nik.put("gambar", txt_gambar.getIcon());
            jasRep = JasperCompileManager.compileReport(jasDes);
            jasPri = JasperFillManager.fillReport(jasRep, nik, con);
            JasperViewer.viewReport(jasPri, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
   }  
    
    
     public void printE()
   {
        JasperReport jasRep;
        JasperPrint jasPri;
        Map<String, Object> nik = new HashMap<String, Object>();
        JasperDesign jasDes;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/web_db", "root", "");
 
            File report = new File("src/crud/lap6.jrxml");
            jasDes = JRXmlLoader.load(report);
            nik.put("klse", txtnama.getText());
            nik.put("matkul", cb_matkul.getSelectedItem());
            nik.put("instruktur", cb_instruktur.getSelectedItem());
            nik.put("ta", cb_akademik.getSelectedItem());
            nik.put("jadwal", cb_hari.getSelectedItem());
            nik.put("jam", cb_jam.getSelectedItem());
            nik.put("gambar", txt_gambar.getIcon());
            jasRep = JasperCompileManager.compileReport(jasDes);
            jasPri = JasperFillManager.fillReport(jasRep, nik, con);
            JasperViewer.viewReport(jasPri, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
   }   
   
   
   public void printA()
   {
        JasperReport jasRep;
        JasperPrint jasPri;
        Map<String, Object> nik = new HashMap<String, Object>();
        JasperDesign jasDes;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/web_db", "root", "");
 
            File report = new File("src/crud/lap.jrxml");
            jasDes = JRXmlLoader.load(report);
            nik.put("ok", txtnama.getText());
            nik.put("matkul", cb_matkul.getSelectedItem());
            nik.put("Instruktur", cb_instruktur.getSelectedItem());
            nik.put("ta", cb_akademik.getSelectedItem());
            nik.put("jadwal", cb_hari.getSelectedItem());
            nik.put("jam", cb_jam.getSelectedItem());
            nik.put("gambar", txt_gambar.getIcon());
            jasRep = JasperCompileManager.compileReport(jasDes);
            jasPri = JasperFillManager.fillReport(jasRep, nik, con);
            JasperViewer.viewReport(jasPri, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
   }
   
   
    public void combo(){
        comkelas.addItem("A");
        comkelas.addItem("B");
        comkelas.addItem("C");
        comkelas.addItem("D");
        comkelas.addItem("E");
        comkelas.addItem("F");
        
        comsemes.addItem("I");
        comsemes.addItem("II");
        comsemes.addItem("III");
        comsemes.addItem("IV");
        comsemes.addItem("V");
        comsemes.addItem("VI");
        
        comstats.addItem("lunas");
        comstats.addItem("belum");
       
    }
    
    
    
    
    public void updatea()
    {
          if (txtnama.getText().trim().equals("")){
       JOptionPane.showMessageDialog(null, "mohon di isi");
       txtnama.requestFocus();
       }else if  (txtnim.getText().trim().equals("")){
       JOptionPane.showMessageDialog(null, "mohon di isi");
       txtnim.requestFocus();
       }else{
           try{
//       ob.setid(txt_id.getText());
       ob.setnama(txtnama.getText());
       ob.setnim(txtnim.getText());
       ob.setkelas(comkelas.getSelectedItem().toString());
       ob.setsemester(comsemes.getSelectedItem().toString());
       ob.setstatus(comstats.getSelectedItem().toString());
       ob.ubahData(txt_id.getText(),ob.getnama(), ob.getnim(), ob.getkelas(), ob.getsemester(),ob.getstatus());
       
                JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Informasi",JOptionPane.INFORMATION_MESSAGE);
                  tampil_database();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal diubah","Informasi",JOptionPane.INFORMATION_MESSAGE);
            }
        }    
    }
    
    public void updateb()
    {
          if (txtnama.getText().trim().equals("")){
       JOptionPane.showMessageDialog(null, "mohon di isi");
       txtnama.requestFocus();
       }else if  (txtnim.getText().trim().equals("")){
       JOptionPane.showMessageDialog(null, "mohon di isi");
       txtnim.requestFocus();
       }else{
           try{
//       ob.setid(txt_id.getText());
       ob.setnama(txtnama.getText());
       ob.setnim(txtnim.getText());
       ob.setkelas(comkelas.getSelectedItem().toString());
       ob.setsemester(comsemes.getSelectedItem().toString());
       ob.setstatus(comstats.getSelectedItem().toString());
       ob.ubahDatab(txt_id.getText(),ob.getnama(), ob.getnim(), ob.getkelas(), ob.getsemester(),ob.getstatus());
       
                JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Informasi",JOptionPane.INFORMATION_MESSAGE);
                  tampil_databaseB();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal diubah","Informasi",JOptionPane.INFORMATION_MESSAGE);
            }
        }    
    }
    
    public void updatec()
    {
          if (txtnama.getText().trim().equals("")){
       JOptionPane.showMessageDialog(null, "mohon di isi");
       txtnama.requestFocus();
       }else if  (txtnim.getText().trim().equals("")){
       JOptionPane.showMessageDialog(null, "mohon di isi");
       txtnim.requestFocus();
       }else{
           try{
//       ob.setid(txt_id.getText());
       ob.setnama(txtnama.getText());
       ob.setnim(txtnim.getText());
       ob.setkelas(comkelas.getSelectedItem().toString());
       ob.setsemester(comsemes.getSelectedItem().toString());
       ob.setstatus(comstats.getSelectedItem().toString());
       ob.ubahDatac(txt_id.getText(),ob.getnama(), ob.getnim(), ob.getkelas(), ob.getsemester(),ob.getstatus());
       
                JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Informasi",JOptionPane.INFORMATION_MESSAGE);
                  tampil_databaseC();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal diubah","Informasi",JOptionPane.INFORMATION_MESSAGE);
            }
        }    
    }
    
     public void updated()
    {
          if (txtnama.getText().trim().equals("")){
       JOptionPane.showMessageDialog(null, "mohon di isi");
       txtnama.requestFocus();
       }else if  (txtnim.getText().trim().equals("")){
       JOptionPane.showMessageDialog(null, "mohon di isi");
       txtnim.requestFocus();
       }else{
           try{
//       ob.setid(txt_id.getText());
       ob.setnama(txtnama.getText());
       ob.setnim(txtnim.getText());
       ob.setkelas(comkelas.getSelectedItem().toString());
       ob.setsemester(comsemes.getSelectedItem().toString());
       ob.setstatus(comstats.getSelectedItem().toString());
       ob.ubahDatac(txt_id.getText(),ob.getnama(), ob.getnim(), ob.getkelas(), ob.getsemester(),ob.getstatus());
       
                JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Informasi",JOptionPane.INFORMATION_MESSAGE);
                  tampil_databaseC();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal diubah","Informasi",JOptionPane.INFORMATION_MESSAGE);
            }
        }    
    }
    
     public void updatee()
    {
          if (txtnama.getText().trim().equals("")){
       JOptionPane.showMessageDialog(null, "mohon di isi");
       txtnama.requestFocus();
       }else if  (txtnim.getText().trim().equals("")){
       JOptionPane.showMessageDialog(null, "mohon di isi");
       txtnim.requestFocus();
       }else{
           try{
//       ob.setid(txt_id.getText());
       ob.setnama(txtnama.getText());
       ob.setnim(txtnim.getText());
       ob.setkelas(comkelas.getSelectedItem().toString());
       ob.setsemester(comsemes.getSelectedItem().toString());
       ob.setstatus(comstats.getSelectedItem().toString());
       ob.ubahDatac(txt_id.getText(),ob.getnama(), ob.getnim(), ob.getkelas(), ob.getsemester(),ob.getstatus());
       
                JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Informasi",JOptionPane.INFORMATION_MESSAGE);
                  tampil_databaseC();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal diubah","Informasi",JOptionPane.INFORMATION_MESSAGE);
            }
        }    
    }
    
    public void reset_text(){
    txtnama.setText("");
    txtnim.setText("");
    comkelas.setSelectedItem("A");
    comsemes.setSelectedItem("I");
    comstats.setSelectedItem("lunas");
    }
    
    public void tampil_database(){
        Object[]baris={"no","nama","nim","kelas","semester","status"};
        tabmode = new DefaultTableModel(null,baris);
        tbl_maha.setModel(tabmode);
        try{
            hasil = ob.tampilData("select * from data");
            while (hasil.next()){
            ob.setid(hasil.getString("id"));
            ob.setnama(hasil.getString("nama"));
            ob.setnim(hasil.getString("nim"));
            ob.setkelas(hasil.getString("kelas"));
            ob.setsemester(hasil.getString("semester"));
            ob.setstatus(hasil.getString("status"));
        String[] data = {ob.getId(),ob.getnama(),ob.getnim(),ob.getkelas(),ob.getsemester(),ob.getstatus()};
        tabmode.addRow (data);
            }
        }catch (Exception e){
        
        }
    }
    
    public void tampil_databaseB(){
        Object[]baris={"no","nama","nim","kelas","semester","status"};
        tabmode = new DefaultTableModel(null,baris);
        tbl_maha.setModel(tabmode);
        try{
            hasil = ob.tampilData("select * from data_b");
            while (hasil.next()){
            ob.setid(hasil.getString("id"));
            ob.setnama(hasil.getString("nama"));
            ob.setnim(hasil.getString("nim"));
            ob.setkelas(hasil.getString("kelas"));
            ob.setsemester(hasil.getString("semester"));
            ob.setstatus(hasil.getString("status"));
        String[] data = {ob.getId(),ob.getnama(),ob.getnim(),ob.getkelas(),ob.getsemester(),ob.getstatus()};
        tabmode.addRow (data);
            }
        }catch (Exception e){
        
        }
    }
    public void tampil_databaseC(){
        Object[]baris={"no","nama","nim","kelas","semester","status"};
        tabmode = new DefaultTableModel(null,baris);
        tbl_maha.setModel(tabmode);
        try{
            hasil = ob.tampilData("select * from data_c");
            while (hasil.next()){
            ob.setid(hasil.getString("id"));
            ob.setnama(hasil.getString("nama"));
            ob.setnim(hasil.getString("nim"));
            ob.setkelas(hasil.getString("kelas"));
            ob.setsemester(hasil.getString("semester"));
            ob.setstatus(hasil.getString("status"));
        String[] data = {ob.getId(),ob.getnama(),ob.getnim(),ob.getkelas(),ob.getsemester(),ob.getstatus()};
        tabmode.addRow (data);
            }
        }catch (Exception e){
        
        }
    }
    
    public void tampil_databaseD(){
        Object[]baris={"no","nama","nim","kelas","semester","status"};
        tabmode = new DefaultTableModel(null,baris);
        tbl_maha.setModel(tabmode);
        try{
            hasil = ob.tampilData("select * from data_d");
            while (hasil.next()){
            ob.setid(hasil.getString("id"));
            ob.setnama(hasil.getString("nama"));
            ob.setnim(hasil.getString("nim"));
            ob.setkelas(hasil.getString("kelas"));
            ob.setsemester(hasil.getString("semester"));
            ob.setstatus(hasil.getString("status"));
        String[] data = {ob.getId(),ob.getnama(),ob.getnim(),ob.getkelas(),ob.getsemester(),ob.getstatus()};
        tabmode.addRow (data);
            }
        }catch (Exception e){
        
        }
    }
     public void tampil_databaseE(){
        Object[]baris={"no","nama","nim","kelas","semester","status"};
        tabmode = new DefaultTableModel(null,baris);
        tbl_maha.setModel(tabmode);
        try{
            hasil = ob.tampilData("select * from data_e");
            while (hasil.next()){
            ob.setid(hasil.getString("id"));
            ob.setnama(hasil.getString("nama"));
            ob.setnim(hasil.getString("nim"));
            ob.setkelas(hasil.getString("kelas"));
            ob.setsemester(hasil.getString("semester"));
            ob.setstatus(hasil.getString("status"));
        String[] data = {ob.getId(),ob.getnama(),ob.getnim(),ob.getkelas(),ob.getsemester(),ob.getstatus()};
        tabmode.addRow (data);
            }
        }catch (Exception e){
        
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

        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        gambar = new javax.swing.JTextField();
        txt_gambar2 = new javax.swing.JTextField();
        txt_gambar = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        txtstts = new javax.swing.JLabel();
        txtsmstr = new javax.swing.JLabel();
        txtkls = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comstats = new javax.swing.JComboBox<String>();
        comsemes = new javax.swing.JComboBox<String>();
        comkelas = new javax.swing.JComboBox<String>();
        txtnim = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        cb_matkul = new javax.swing.JComboBox();
        cb_instruktur = new javax.swing.JComboBox();
        cb_akademik = new javax.swing.JComboBox();
        cb_jam = new javax.swing.JComboBox();
        cb_hari = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cari = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_maha = new javax.swing.JTable();
        cb_kelas = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu8.setText("File");
        jMenuBar5.add(jMenu8);

        jMenu9.setText("Edit");
        jMenuBar5.add(jMenu9);

        jMenu10.setText("File");
        jMenuBar6.add(jMenu10);

        jMenu11.setText("Edit");
        jMenuBar6.add(jMenu11);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(8, 157, 247));

        jPanel1.setBackground(new java.awt.Color(122, 157, 204));

        jPanel2.setBackground(new java.awt.Color(155, 180, 231));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(245, 231, 231), java.awt.Color.white, java.awt.Color.white));
        jPanel2.setForeground(java.awt.SystemColor.control);

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel6.setText("MAHASISWA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        gambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gambarActionPerformed(evt);
            }
        });

        txt_gambar2.setEditable(false);
        txt_gambar2.setBackground(new java.awt.Color(204, 204, 204));
        txt_gambar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_gambar2ActionPerformed(evt);
            }
        });

        txt_gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_gambar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anonym\\Documents\\BelajarJava\\CRUD\\src\\doctor (1).png")); // NOI18N

        jButton8.setText("Browse");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Foto");

        jButton5.setText("print");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("Print Data Kelas");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_gambar2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(txt_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_gambar2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(txt_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        txtstts.setText("Status");

        txtsmstr.setText("Semester");

        txtkls.setText("Kelas");

        jLabel2.setText("NIM");

        jLabel1.setText("Nama ");

        comstats.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "lunas", "belum" }));

        comsemes.setFont(new java.awt.Font("Perpetua Titling MT", 0, 11)); // NOI18N
        comsemes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "I", "II", "III", "IV", "V", "VI", " " }));

        comkelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "F", " " }));

        txtnim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnimKeyTyped(evt);
            }
        });

        txtnama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnamaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnamaKeyTyped(evt);
            }
        });

        cb_matkul.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Mata Kuliah--" }));

        cb_instruktur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Instruktur--" }));

        cb_akademik.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Tahun Akademik--" }));

        cb_jam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jam :", "01.00", "02.00", "03.00", "04.00", "05.00", "06.00", "07.00", "08.00", "09.00", "10.00", "11.00", "12.00" }));

        cb_hari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih Hari--", "Senin", "Selasa", "Rabu", "kamis", "Jum'at", "Sabtu", "Ahad" }));
        cb_hari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_hariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cb_hari, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_jam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cb_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_instruktur, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_akademik, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_instruktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_akademik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_hari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_jam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        jButton6.setText("Ubah");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setText("delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtkls)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(txtsmstr)
                            .addComponent(txtstts))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comstats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comsemes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnim, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comkelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkls)
                    .addComponent(comkelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsmstr)
                    .addComponent(comsemes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstts)
                    .addComponent(comstats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(66, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(938, 938, 938))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(155, 180, 231));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jButton3.setText("cari");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tbl_maha.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_maha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_mahaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_maha);

        cb_kelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Kelas", "A", "B", "C", "D", "E" }));
        cb_kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_kelasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton3)
                        .addGap(74, 74, 74)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222)
                        .addComponent(cb_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jMenu1.setText("User");
        jMenu1.setActionCommand("User\n");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Log in");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);
        jMenu1.getAccessibleContext().setAccessibleName("User\n");

        jMenu12.setText("Tambah Data");
        jMenu12.setActionCommand("User\n");
        jMenu12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu12ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Mata Kuliah");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem2);

        jMenuItem3.setText("Instruktur");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem3);

        jMenuItem4.setText("Tahun Akademik");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem4);

        jMenuBar1.add(jMenu12);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     
         if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("A")){
             cariA();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("B")){
             cariB();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("C")){
           cariC();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("D")){
             cariD();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("E")){
            cariE();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cb_kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_kelasActionPerformed
    if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("A")){
            tampil_database();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("B")){
           tampil_databaseB();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("C")){
            tampil_databaseC();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("D")){
            tampil_databaseD();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("E")){
            tampil_databaseE();
        }
    
// TODO add your handling code here:
    }//GEN-LAST:event_cb_kelasActionPerformed

    private void tbl_mahaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_mahaMouseClicked
        // TODO add your handling code here:
        try { int row = tbl_maha.rowAtPoint(evt.getPoint());
             String id = tbl_maha.getValueAt(row, 0).toString();
            String nama = tbl_maha.getValueAt(row, 1).toString();
            String nim = tbl_maha.getValueAt(row, 2).toString();
            String kelas = tbl_maha.getValueAt(row, 3).toString();
            String semester = tbl_maha.getValueAt(row, 4).toString();
            String status = tbl_maha.getValueAt(row, 5).toString();
//            String gmb = tbl_maha.getValueAt(row, 6).toString();
           
            
            txt_id.setText(String.valueOf(id));
            txtnama.setText(String.valueOf(nama)); 
            txtnim.setText(String.valueOf(nim));
            comkelas.setSelectedItem(String.valueOf(kelas));
            comsemes.setSelectedItem(String.valueOf(semester));
            comstats.setSelectedItem(String.valueOf(status));
//            txt_gambar2.setText(String.valueOf(gmb));
//
//            ImageIcon icon = new ImageIcon(txt_gambar2.getText()); // jangan lupa import class ImageIcon
//            txt_gambar.setIcon(icon);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_tbl_mahaMouseClicked

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
      
// TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     try {
          user form = new user();
          form.setVisible(true);
      }catch(Exception ex){
      }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
 try {
          matkul form = new matkul();
          form.setVisible(true);
      }catch(Exception ex){
      }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu12ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         try {
          instruktur form = new instruktur();
          form.setVisible(true);
      }catch(Exception ex){
      }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
 try {
          akademik form = new akademik();
          form.setVisible(true);
      }catch(Exception ex){
      }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void txt_gambar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_gambar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_gambar2ActionPerformed

    private void gambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gambarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gambarActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jFileChooser1.setSelectedFile(null);
        jFileChooser1.showOpenDialog(this);
        file = jFileChooser1.getSelectedFile().toString();

        file = file.replace('\\', '/');
        gambar.setText(file);

        ImageIcon icon = new ImageIcon(file); // jangan lupa import class ImageIcon
        txt_gambar.setIcon(icon);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("A")){
            updatea();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("B")){
            updateb();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("C")){
            updatec();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("D")){
            updated();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("E")){
            updatee();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //           MessageFormat judul = new MessageFormat ("Data Kartu Kontrol");
        //        MessageFormat footer = new MessageFormat ("page {0,number,integer})");
        //
        //         try {
            //           tbl_maha.print(JTable.PrintMode.FIT_WIDTH,judul,footer);
            //           // TODO add your handling code here:
            //       } catch (PrinterException ex) {
            //            System.err.print("erro print");
            //      }

        if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("A")){
            cetakA();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("B")){
            cetakB();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("C")){
            cetakC();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("D")){
            cetakD();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("E")){
            cetakE();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //        MessageFormat judul = new MessageFormat ("Kartu Kontrol");
        //        MessageFormat footer = new MessageFormat ("page {0,number,integer})");

        //        JasperReport jasRep;
        //        JasperPrint jasPri;
        //        Map<String, Object> nik = new HashMap<String, Object>();
        //        JasperDesign jasDes;
        //        try {
            //            Class.forName("com.mysql.jdbc.Driver");
            //            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/web_db", "root", "");
            //
            //            File report = new File("src/crud/lap.jrxml");
            //            jasDes = JRXmlLoader.load(report);
            //            nik.put("ok", txtnama.getText());
            //            jasRep = JasperCompileManager.compileReport(jasDes);
            //            jasPri = JasperFillManager.fillReport(jasRep, nik, con);
            //            JasperViewer.viewReport(jasPri, false);
            //        } catch (Exception e) {
            //            JOptionPane.showMessageDialog(null, e.getMessage());
            //        }

        if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("A")){
            printA();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("B")){
            printB();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("C")){
            printC();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("D")){
            printD();
        }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("E")){
            printE();
        }

        //
        //        try {
            //       JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("laporan.jasper"), null, KoneksiMysql.getKoneksi());
            //        JasperViewer.viewReport(jp, false);
            //        } catch(Exception e) {
            //            JOptionPane.showMessageDialog(rootPane, e);
            //        }

        //         try {
            //       JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("lap3.jasper"), null, KoneksiMysql.getKoneksi());
            //        JasperViewer.viewReport(jp, false);
            //        } catch(Exception e) {
            //             System.out.println(rootPane+""+ e);
            //
            //        }
        //

        //       try {
            //            String namafile = "src/crud/laporan.jasper";
            //            HashMap hash = new HashMap();
            //            File file = new File(namafile);
            //            JasperReport jasper = (JasperReport) JRLoader.loadObject(file.getPath());
            //            JasperPrint print = JasperFillManager.fillReport(jasper, hash, KoneksiMysql.getKoneksi());
            //            JasperViewer.viewReport(print,false);
            //            } catch (JRException ex) {
            //            JOptionPane.showMessageDialog(null,ex);
            //        }

        //          try {
            //        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("laporan.jasper"), null, KoneksiMysql.getKoneksi());
            ////        JasperExportManager.exportReportToPdfFile(jp, "sample.pdf");
            //        JasperViewer.viewReport(jp, false);
            //        } catch(Exception e) {
            //            JOptionPane.showMessageDialog(rootPane,"Error" + e);
            //        }

        //          JasperPrint jasperPrint;
        //        try {
            //            jasperPrint = JasperFillManager.fillReport("laporan.jasper",  new HashMap<String, Object>(),new JREmptyDataSource());
            //             JasperExportManager.exportReportToPdfFile(jasperPrint, "sample.pdf");
            //        } catch (JRException ex) {
            //            Logger.getLogger(mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            //        }

        //        try {
            ////            tbl_maha.print(JTable.PrintMode.FIT_WIDTH,judul,footer);
            ////            // TODO add your handling code here:
            ////        } catch (PrinterException ex) {
            ////            System.err.print("erro print");
            //
            //        }
        //        String reportsrc=null;
        //        String reportdest=null;

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int baris = tbl_maha.getSelectedRow();
        if (baris != -1) {
            String nama = tbl_maha.getValueAt(baris, 0).toString();
            ob.setnama(nama);
            ob.hapusData(ob.getnama());
            tampil_database();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        reset_text();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtnama.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "mohon di isi");
            txtnama.requestFocus();
        }else if  (txtnim.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "mohon di isi");
            txtnim.requestFocus();
        }else{

            try{
                ob.setnama(txtnama.getText());
                ob.setnim(txtnim.getText());
                ob.setkelas(comkelas.getSelectedItem().toString());
                ob.setsemester(comsemes.getSelectedItem().toString());
                ob.setstatus(comstats.getSelectedItem().toString());
                if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("A")){
                    ob.simpanData(ob.getnama(), ob.getnim(), ob.getkelas(), ob.getsemester(),ob.getstatus());
                    tampil_database();
                }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("B")) {
                    ob.simpanDataB(ob.getnama(), ob.getnim(), ob.getkelas(), ob.getsemester(),ob.getstatus());
                    tampil_databaseB();
                }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("C")) {
                    ob.simpanDataC(ob.getnama(), ob.getnim(), ob.getkelas(), ob.getsemester(),ob.getstatus());
                    tampil_databaseC();
                }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("D")) {
                    ob.simpanDataD(ob.getnama(), ob.getnim(), ob.getkelas(), ob.getsemester(),ob.getstatus());
                    tampil_databaseD();
                }else if (cb_kelas.getSelectedItem().toString().equalsIgnoreCase("E")) {
                    ob.simpanDataE(ob.getnama(), ob.getnim(), ob.getkelas(), ob.getsemester(),ob.getstatus());
                    tampil_databaseE();
                }

                //       tampil_database();

                JOptionPane.showMessageDialog(null, "tersimpan","informasi", JOptionPane.INFORMATION_MESSAGE);
                //       tampil_database();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "gagal","informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        reset_text();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtnimKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnimKeyTyped
        FilterAngka(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnimKeyTyped

    private void txtnamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamaKeyTyped
        FilterHuruf(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaKeyTyped

    private void txtnamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamaKeyReleased
        txt_gambar2.setText("C:/gambar/" + txtnama.getText() + ".jpg");
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaKeyReleased

    private void cb_hariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_hariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_hariActionPerformed

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
            java.util.logging.Logger.getLogger(mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new mahasiswa().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox cb_akademik;
    private javax.swing.JComboBox cb_hari;
    private javax.swing.JComboBox cb_instruktur;
    private javax.swing.JComboBox cb_jam;
    private javax.swing.JComboBox cb_kelas;
    private javax.swing.JComboBox cb_matkul;
    private javax.swing.JComboBox<String> comkelas;
    private javax.swing.JComboBox<String> comsemes;
    private javax.swing.JComboBox<String> comstats;
    private javax.swing.JTextField gambar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_maha;
    private javax.swing.JLabel txt_gambar;
    private javax.swing.JTextField txt_gambar2;
    private javax.swing.JTextField txt_id;
    private javax.swing.JLabel txtkls;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnim;
    private javax.swing.JLabel txtsmstr;
    private javax.swing.JLabel txtstts;
    // End of variables declaration//GEN-END:variables
}
