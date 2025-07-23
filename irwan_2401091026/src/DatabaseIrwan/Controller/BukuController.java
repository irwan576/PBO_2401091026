/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseIrwan.Controller;

import DatabaseIrwan.Dao.BukuDb;
import DatabaseIrwan.Model.Buku;
import DatabaseIrwan.View.FormBuku;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suga
 */
public class BukuController {
    
    private FormBuku formBuku;
    private Buku buku;
    private BukuDb dao;
    
    public BukuController(FormBuku formBuku) {
        this.formBuku = formBuku;
        dao = new BukuDb();
    }
    
    public void clearScreen() {
        formBuku.getTxtKode().setText("");
        formBuku.getTxtPengarang().setText("");
        formBuku.getTxtPenerbit().setText("");
        formBuku.getTxtJudul().setText("");
        formBuku.getTxtTahun().setText("");
    }
    
    public void insert(){
        buku = new Buku();
        buku.setKode(formBuku.getTxtKode().getText());
        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
        buku.setPengarang(formBuku.getTxtPengarang().getText());
        buku.setJudul(formBuku.getTxtJudul().getText());
        buku.setTahun(Integer.parseInt(formBuku.getTxtTahun().getText()));
        
        
        try{
            dao.insert(buku);
            JOptionPane.showMessageDialog(formBuku, "Entry Data Ok!");
        }catch (Exception Ex){
            JOptionPane.showMessageDialog(formBuku, Ex.getMessage());
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, Ex);
        }
    }
    
    public void update(){
        buku = new Buku();
        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
        buku.setPengarang(formBuku.getTxtPengarang().getText());
        buku.setJudul(formBuku.getTxtJudul().getText());
        buku.setTahun(Integer.parseInt(formBuku.getTxtTahun().getText()));
        buku.setKode(formBuku.getTxtKode().getText());
        
        
        try{
            dao.update(buku);
            JOptionPane.showMessageDialog(formBuku, "Update Data Ok!");
        }catch (Exception Ex){
            JOptionPane.showMessageDialog(formBuku, Ex.getMessage());
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, Ex);
        }
    }
    
    public void delete(){
        try {
            if(buku!=null){   
                dao.delete(buku);
            }else{
                JOptionPane.showMessageDialog(formBuku, "Data Not Found");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void search(){
        try {
            String kode = formBuku.getTxtKode().getText();
            buku = dao.getBuku(kode);
            
            if (buku != null){
                formBuku.getTxtPenerbit().setText(buku.getPenerbit());
                formBuku.getTxtPengarang().setText(buku.getPengarang());
                formBuku.getTxtJudul().setText(buku.getPengarang());
                formBuku.getTxtTahun().setText(String.valueOf(buku.getTahun()));
            }else{
                JOptionPane.showMessageDialog(formBuku, "Data not found!");
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void viewData() {
        
        try {
            DefaultTableModel model = (DefaultTableModel)
                    formBuku.getBukuTable().getModel();
            
            model.setNumRows(0);
            List<Buku> list = dao.getAllBuku();
            for (Buku buku : list) {
                Object[] data = {
                    buku.getKode(),
                    buku.getPengarang(),
                    buku.getPenerbit(),
                    buku.getJudul(),
                    buku.getTahun(),
                };
                model.addRow(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
