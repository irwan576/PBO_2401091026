/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseIrwan.Dao;

import DatabaseIrwan.Model.Anggota;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suga
 */
public class AnggotaDb {
    public void insert(Anggota anggota) throws Exception{
        java.sql.Connection con = new Connection().getConnection();
        String sql = "insert into anggota values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, anggota.getAlamat());
        ps.setString(2, anggota.getKode());
        ps.setString(3, anggota.getNama());
        ps.setString(4, anggota.getJekel());
        ps.executeUpdate();
    }
    
    public void update(Anggota anggota) throws Exception{
        java.sql.Connection con = new Connection().getConnection();
        String sql = "update anggota set nama=?, jekel=?, alamat=? where kode=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, anggota.getAlamat());
        ps.setString(2, anggota.getKode());
        ps.setString(3, anggota.getNama());
        ps.setString(4, anggota.getJekel());
        
        ps.executeUpdate();
    }
    
    public void delete(Anggota anggota) throws Exception{
        java.sql.Connection con = new Connection().getConnection();
        String sql = "delete from anggota where kode=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, anggota.getKode());
        
        ps.executeUpdate();
    }
    
    public Anggota getAnggota(String kode) throws Exception{
        java.sql.Connection con = new Connection().getConnection();
        String sql = "select * from anggota where kode=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        Anggota anggota  = null;
        
        if(rs.next()){
            anggota = new Anggota();
            anggota.setAlamat(rs.getString(1));
            anggota.setKode(rs.getString(2));
            anggota.setNama(rs.getString(3));
            anggota.setJekel(rs.getString(4));
        }
        
        return anggota;
    }
    
    public List<Anggota> getAllAnggota() throws Exception{
        java.sql.Connection con = new Connection().getConnection();
        String sql = "select * from anggota";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Anggota> list = new ArrayList<>();
        Anggota anggota= null;
        
        while (rs.next()){
            anggota = new Anggota();
            anggota.setAlamat(rs.getString(1));
            anggota.setKode(rs.getString(2));
            anggota.setNama(rs.getString(3));
            anggota.setJekel(rs.getString(4));
            list.add(anggota);
        }
        return list;
    }
    
    
    public static void main(String[] args){
        AnggotaDb anggotaDb = new AnggotaDb();
        Anggota anggota = new Anggota();
        anggota.setAlamat("Padang");
        anggota.setKode("A001");
        anggota.setNama("Hartono");
        anggota.setJekel("L");
        try{
//           anggotaDb.getAnggota("A001");
//           System.out.println("Alamat       :" + anggota.getAlamat());
//           System.out.println("NOBP         :" + anggota.getKode());
//           System.out.println("Nama         :" + anggota.getNama());
//           System.out.println("Jekel        :" + anggota.getJekel());
//           
//           System.out.println(" ");
//           System.out.println("Get Data Ok");

            anggotaDb.update(anggota);
            System.out.println("update Ok");
        }catch (Exception ex){
            System.out.println("Error : " + ex.getMessage());
            Logger.getLogger(AnggotaDb.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
