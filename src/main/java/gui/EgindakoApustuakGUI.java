package gui;
import java.awt.BorderLayout;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.BLFacade;
import domain.Apustua;
import domain.ApustuakTableModel;
import domain.Erregistratua;

public class EgindakoApustuakGUI extends JFrame {

    // Código existente...

    /**
*
*/
private static final long serialVersionUID = 1L;
private JTable table;
    private ApustuakTableModel modeloTabla;
    private JFrame nirePantaila;
private BLFacade negozioLogika;

    // Código existente...

    public EgindakoApustuakGUI(String log) {
        super();
        nirePantaila=this;
        nirePantaila.setTitle(ResourceBundle.getBundle("Etiquetas").getString("Ban"));
        table = new JTable();
        this.negozioLogika=MainGUI.getBusinessLogic();
        Erregistratua e=negozioLogika.erregistratuaItzuli(log);
        Vector<Apustua> apustuak=e.getApustuak();
        modeloTabla = new ApustuakTableModel(apustuak);
        table.setModel(modeloTabla);
        // Agrega la tabla al GUI
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        pack(); 
        setLocationRelativeTo(null);
    }

    // Código existente...

}