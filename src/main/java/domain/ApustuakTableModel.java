package domain;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class ApustuakTableModel extends AbstractTableModel {
private String[] zutabeIzenak= {"Event","Question", "Bet(€)"};
private Vector<Apustua> datuak;

public ApustuakTableModel(Vector<Apustua> datuak) {
this.datuak=datuak;
}

public int getColumnCount() {
return zutabeIzenak.length;
}

public int getRowCount() {
int totalOptions=0;
for(Apustua dat:datuak) {
totalOptions=totalOptions+dat.getErantzunKop();
}
  return totalOptions;
}


public Object getValueAt(int row, int col) {
int currentRow = 0;
   
   for (Apustua apustua : datuak) {
       for (Aukera auk : apustua.getErantzunak()) {
           if (currentRow == row) {
               switch (col) {
                   case 0:
                       return auk.getGaldera().getEvent();
                   case 1:
                       return auk.getGaldera();
                   case 2:
                       return apustua.getZenbatekoa();
                   default:
                       return null;
               }
           }
           currentRow++;
           System.out.println("Event: " + auk.getGaldera().getEvent());
           System.out.println("Question: " + auk.getGaldera());
           System.out.println("Bet(€): " + apustua.getZenbatekoa());

       }
       
   }

   return null;
}
@Override
    public String getColumnName(int column) {
        return zutabeIzenak[column];
    }
}