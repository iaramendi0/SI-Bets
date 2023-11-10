package gui;

import java.awt.Color;
import java.net.URL;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import businessLogic.Factory;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ApplicationLauncher { 
	
	
	
	public static void main(String[] args) {

		ConfigXML c=ConfigXML.getInstance();
	
		System.out.println(c.getLocale());
		
		Locale.setDefault(new Locale(c.getLocale()));
		
		System.out.println("Locale: "+Locale.getDefault());
		
		Hasierako_pantailaGUI a=new Hasierako_pantailaGUI();
		GroupLayout groupLayout = new GroupLayout(a.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 426, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 253, Short.MAX_VALUE)
		);
		a.getContentPane().setLayout(groupLayout);
		a.setVisible(true);


		try {
			
			BLFacade appFacadeInterface;
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			if (c.isBusinessLogicLocal()) {
				appFacadeInterface=Factory.createFactory(true);

				
			}
			
			else { //If remote
		         appFacadeInterface = Factory.createFactory(false);
			} 
			MainGUI.setBussinessLogic(appFacadeInterface);

		
			
			
		}catch (Exception e) {
			a.jLabelSelectOption.setText("Error: "+e.toString());
			a.jLabelSelectOption.setForeground(Color.RED);	
			
			System.out.println("Error in ApplicationLauncher: "+e.toString());
		}
		//a.pack();


	}

}
