/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseIrwan.Dao;

import DatabaseIrwan.Model.Buku;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Suga
 */
public class BukuDb {
    public void insert(Buku buku) throws Exception{
        java.sql.Connection con = new Connection().getConnection();
        String sql = "insert into buku values (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, buku.getKode());
        ps.setString(2, buku.getPengarang());
        ps.setString(3, buku.getPenerbit());
        ps.setString(4, buku.getJudul());
        ps.setInt(5, buku.getTahun());
        ps.executeUpdate();
    }
    
    public void update(Buku buku) throws Exception{
        java.sql.Connection con = new Connection().getConnection();
        String sql = "update buku set pengarang=?,penerbit=?, judul=? , tahun=? where kode=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, buku.getPengarang());
        ps.setString(2, buku.getPenerbit());
        ps.setString(3, buku.getJudul());
        ps.setInt(4, buku.getTahun());
        ps.setString(5, buku.getKode());
        
        ps.executeUpdate();
    }
    
    public void delete(Buku buku) throws Exception{
        java.sql.Connection con = new Connection().getConnection();
        String sql = "delete from buku where kode=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, buku.getKode());
        
        ps.executeUpdate();
    }
    
    public Buku getBuku(String kode) throws Exception{
        java.sql.Connection con = new Connection().getConnection();
        String sql = "select * from buku where kode=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        Buku buku  = null;
        
        if(rs.next()){
            buku = new Buku();
            buku.setKode(rs.getString(1));
            buku.setPengarang(rs.getString(2));
            buku.setPenerbit(rs.getString(3));
            buku.setJudul(rs.getString(4));
            buku.setTahun(rs.getInt(5));
        }
        
        return buku;
    }
    
    public List<Buku> getAllBuku() throws Exception{
        java.sql.Connection con = new Connection().getConnection();
        String sql = "select * from buku";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Buku> list = new ArrayList<>();
        Buku buku= null;
        
        while (rs.next()){
            buku = new Buku();
            buku.setKode(rs.getString(1));
            buku.setPengarang(rs.getString(2));
            buku.setPenerbit(rs.getString(3));
            buku.setJudul(rs.getString(4));
            buku.setTahun(rs.getInt(5));
            list.add(buku);
        }
        return list;
    }
}
