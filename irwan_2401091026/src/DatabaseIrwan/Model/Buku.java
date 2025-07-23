/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseIrwan.Model;

public class Buku {
    private String kode;
    private String pengarang;
    private String penerbit;
    private String judul;
    private int tahun;

    public Buku() {
   
    }

    
    //accessor
    public String getKode() {
        return kode;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahun() {
        return tahun;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    
    //mutator
    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }
    
    
}

