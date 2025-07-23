/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseIrwan.Model;

public class Anggota {
    private String kode;
    private String nama;
    private String jekel;
    private String alamat;

    public Anggota() {
    }

    

    //accessor
    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getJekel() {
        return jekel;
    }

    public String getAlamat() {
        return alamat;
    }
    
    //mutator

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJekel(String jekel) {
        this.jekel = jekel;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
}