/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CRUD {
private String nama,nim,kelas,semester,status,pesan,id,user,pass,matkul,dosen,akademik;

    public String getAkademik() {
        return akademik;
    }

    public void setAkademik(String akademik) {
        this.akademik = akademik;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    private Connection CRUDkoneksi;
    private PreparedStatement CRUDsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    public CRUD() {
//        try {
            KoneksiMysql connection = new KoneksiMysql();
            CRUDkoneksi = connection.getKoneksi();
//     } catch(SQLException ex) {
//            System.out.println(ex);
//        
     
    }
   
     public void setid (String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setnama (String nama) {
        this.nama = nama;
    }
    
    public String getnama() {
        return nama;
    }
    public void setnim (String nim) {
        this.nim = nim;
    }
    
    public String getnim() {
        return nim;
    }
    
    public void setkelas (String kelas) {
        this.kelas = kelas;
    }
    
    public String getkelas() {
        return kelas;
    }
    
    public void setsemester (String semester) {
        this.semester = semester;
    }
    
    public String getsemester() {
        return semester;
    }

    public void setstatus (String status) {
        this.status = status;
    }
    
    public String getstatus() {
        return status;
    }
    
    public ResultSet tampilData(String sql) {
        CRUDquery = sql;
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
    }
          return CRUDhasil;   
    }
    
    
     
     public void simpanmatkul (String matakul){
        CRUDquery = "insert into matkul(mata_kul) values (?)";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, matakul);
            
            CRUDsmt.executeUpdate();
            CRUDsmt.close(); 
            pesan = "berhsil";
    } catch (Exception e) {
       pesan = "data gagal disimpan";
    }
}
      public void simpandosen (String dosen){
        CRUDquery = "insert into instruktur(dosen) values (?)";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, dosen);
            
            CRUDsmt.executeUpdate();
            CRUDsmt.close(); 
            pesan = "berhsil";
    } catch (Exception e) {
       pesan = "data gagal disimpan";
    }
}
      
       public void simpanAkademik (String akademik){
        CRUDquery = "insert into akademik(tahun) values (?)";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, akademik);
            
            CRUDsmt.executeUpdate();
            CRUDsmt.close(); 
            pesan = "berhsil";
    } catch (Exception e) {
       pesan = "data gagal disimpan";
    }
}
    
     public void simpanuser (String user,String pass){
        CRUDquery = "insert into tbl_login(user,pass) values (?,?)";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, user);
            CRUDsmt.setString(2, pass);
            
            CRUDsmt.executeUpdate();
            CRUDsmt.close(); 
            pesan = "berhsil";
    } catch (Exception e) {
       pesan = "data gagal disimpan";
    }
}
    
    public void simpanData (String nama,String nim,String kelas,String semester,String status){
        CRUDquery = "insert into data (nama,nim,kelas,semester,status) values (?,?,?,?,?)";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, nama);
            CRUDsmt.setString(2, nim);
            CRUDsmt.setString(3, kelas);
            CRUDsmt.setString(4, semester);
            CRUDsmt.setString(5, status);
            
            CRUDsmt.executeUpdate();
            CRUDsmt.close(); 
            pesan = "berhsil";
    } catch (Exception e) {
       pesan = "data gagal disimpan";
    }
}
   public void simpanDataB (String nama,String nim,String kelas,String semester,String status){
        CRUDquery = "insert into data_b(nama,nim,kelas,semester,status) values (?,?,?,?,?)";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, nama);
            CRUDsmt.setString(2, nim);
            CRUDsmt.setString(3, kelas);
            CRUDsmt.setString(4, semester);
            CRUDsmt.setString(5, status);
            
            CRUDsmt.executeUpdate();
            CRUDsmt.close(); 
            pesan = "berhsil";
    } catch (Exception e) {
       pesan = "data gagal disimpan";
    }
}
  public void simpanDataC (String nama,String nim,String kelas,String semester,String status){
        CRUDquery = "insert into data_C(nama,nim,kelas,semester,status) values (?,?,?,?,?)";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, nama);
            CRUDsmt.setString(2, nim);
            CRUDsmt.setString(3, kelas);
            CRUDsmt.setString(4, semester);
            CRUDsmt.setString(5, status);
            
            CRUDsmt.executeUpdate();
            CRUDsmt.close(); 
            pesan = "berhsil";
    } catch (Exception e) {
       pesan = "data gagal disimpan";
    }
}
  public void simpanDataD (String nama,String nim,String kelas,String semester,String status){
        CRUDquery = "insert into data_d(nama,nim,kelas,semester,status) values (?,?,?,?,?)";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, nama);
            CRUDsmt.setString(2, nim);
            CRUDsmt.setString(3, kelas);
            CRUDsmt.setString(4, semester);
            CRUDsmt.setString(5, status);
            
            CRUDsmt.executeUpdate();
            CRUDsmt.close(); 
            pesan = "berhsil";
    } catch (Exception e) {
       pesan = "data gagal disimpan";
    }
}
  public void simpanDataE (String nama,String nim,String kelas,String semester,String status){
        CRUDquery = "insert into data_e(nama,nim,kelas,semester,status) values (?,?,?,?,?)";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, nama);
            CRUDsmt.setString(2, nim);
            CRUDsmt.setString(3, kelas);
            CRUDsmt.setString(4, semester);
            CRUDsmt.setString(5, status);
            
            CRUDsmt.executeUpdate();
            CRUDsmt.close(); 
            pesan = "berhsil";
    } catch (Exception e) {
       pesan = "data gagal disimpan";
    }
}
    
    public void ubahData (String id,String nama,String nim,String kelas,String semester,String status) {
//        CRUDquery = "Update 'data' SET 'nama'=? ,'status'=?  where id=? ";
        CRUDquery = "UPDATE `data` SET `nama`=?, `nim`=?, `kelas`=?, `semester`=?, `status`=? WHERE `id`=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, nama);
            CRUDsmt.setString(2, nim);
            CRUDsmt.setString(3, kelas);
            CRUDsmt.setString(4, semester);
            CRUDsmt.setString(5, status);
            CRUDsmt.setString(6, id);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void ubahDatab (String id,String nama,String nim,String kelas,String semester,String status) {
//        CRUDquery = "Update 'data' SET 'nama'=? ,'status'=?  where id=? ";
        CRUDquery = "UPDATE `data_b` SET `nama`=?, `nim`=?, `kelas`=?, `semester`=?, `status`=? WHERE `id`=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, nama);
            CRUDsmt.setString(2, nim);
            CRUDsmt.setString(3, kelas);
            CRUDsmt.setString(4, semester);
            CRUDsmt.setString(5, status);
            CRUDsmt.setString(6, id);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
     public void ubahDatac (String id,String nama,String nim,String kelas,String semester,String status) {
//        CRUDquery = "Update 'data' SET 'nama'=? ,'status'=?  where id=? ";
        CRUDquery = "UPDATE `data_c` SET `nama`=?, `nim`=?, `kelas`=?, `semester`=?, `status`=? WHERE `id`=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, nama);
            CRUDsmt.setString(2, nim);
            CRUDsmt.setString(3, kelas);
            CRUDsmt.setString(4, semester);
            CRUDsmt.setString(5, status);
            CRUDsmt.setString(6, id);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
     
     public void ubahDatad (String id,String nama,String nim,String kelas,String semester,String status) {
//        CRUDquery = "Update 'data' SET 'nama'=? ,'status'=?  where id=? ";
        CRUDquery = "UPDATE `data_d` SET `nama`=?, `nim`=?, `kelas`=?, `semester`=?, `status`=? WHERE `id`=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, nama);
            CRUDsmt.setString(2, nim);
            CRUDsmt.setString(3, kelas);
            CRUDsmt.setString(4, semester);
            CRUDsmt.setString(5, status);
            CRUDsmt.setString(6, id);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
     
     public void ubahDatae (String id,String nama,String nim,String kelas,String semester,String status) {
//        CRUDquery = "Update 'data' SET 'nama'=? ,'status'=?  where id=? ";
        CRUDquery = "UPDATE `data_e` SET `nama`=?, `nim`=?, `kelas`=?, `semester`=?, `status`=? WHERE `id`=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, nama);
            CRUDsmt.setString(2, nim);
            CRUDsmt.setString(3, kelas);
            CRUDsmt.setString(4, semester);
            CRUDsmt.setString(5, status);
            CRUDsmt.setString(6, id);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
     
     public void ubahDatauser (String id,String user,String pass) {
//        CRUDquery = "Update 'data' SET 'nama'=? ,'status'=?  where id=? ";
        CRUDquery = "UPDATE `tbl_login` SET `user`=?, `pass`=? WHERE `id`=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, user);
            CRUDsmt.setString(2, pass);
            CRUDsmt.setString(3, id);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
   public void ubahDatamatkul (String id,String matkul) {
//        CRUDquery = "Update 'data' SET 'nama'=? ,'status'=?  where id=? ";
        CRUDquery = "UPDATE `matkul` SET `mata_kul`=? WHERE `id`=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, id);
            CRUDsmt.setString(2, matkul);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }  
   
    public void ubahDatadosens (String id,String dosen) {
//        CRUDquery = "Update 'data' SET 'nama'=? ,'status'=?  where id=? ";
        CRUDquery = "UPDATE `instruktur` SET `dosen`=? WHERE `id`=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, id);
            CRUDsmt.setString(2, dosen);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e){
            System.out.println(e);
        }
    } 
    
    public void ubahDataAkademik (String id,String akademik) {
//        CRUDquery = "Update 'data' SET 'nama'=? ,'status'=?  where id=? ";
        CRUDquery = "UPDATE `akademik` SET `tahun`=? WHERE `id`=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, id);
            CRUDsmt.setString(2, akademik);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e){
            System.out.println(e);
        }
    } 
     
    public void hapusData (String nama) {
        CRUDquery = "delete from data where id=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, nama);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
     public void hapusDatauser (String user) {
        CRUDquery = "delete from tbl_login where id=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, user);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
     public void hapusdataMatkul (String matkul) {
        CRUDquery = "delete from matkul where id=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, matkul);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
    public void hapusdatadosen (String dosen) {
        CRUDquery = "delete from instruktur where id=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, dosen);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }  
    
    public void hapusdataAkademik (String akademik) {
        CRUDquery = "delete from akademik where id=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, akademik);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }  

}


