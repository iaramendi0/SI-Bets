package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import businessLogic.BLFacade;
import businessLogic.Factory;

public class IteratorTest {

	public static void main(String [] args) {
		boolean isLocal = true;
		//Facade objektua lortu
		BLFacade blFacade = (new Factory()).createFactory(isLocal);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
		date = sdf.parse("17/12/2020");
		ExtendedIterator<Event> iterator = blFacade.getEventsIterator(date);
		Event e;
		System.out.println("_____________________");
		System.out.println("ATZETIK AURRERAKA");
		iterator.goLast();//Azkeneko elementuan kokatu
		while (iterator.hasPrevious()) {
			e = iterator.previous();
			System.out.println(e.toString());
			}
	
		System.out.println();
		System.out.println("_____________________");
		System.out.println("AURRETIK ATZERAKA");
		iterator.goFirst(); // Lehen elem. kokatu
		while (iterator.hasNext()) {
		e = iterator.next();
		System.out.println(e.toString());
		}
		
	    }catch(ParseException e) {
	    	e.getMessage();
	    }
   }
}
	

