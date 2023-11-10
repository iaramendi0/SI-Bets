package businessLogic;
import java.net.URL;

import javax.xml.namespace.*;
import javax.xml.ws.Service;

import configuration.ConfigXML;


public class Factory {

		public static BLFacade createFactory(boolean local){
			if(local) {
				return new BLFacadeImplementation();
			}
			if(!local) {
				try {
					ConfigXML c = ConfigXML.getInstance();
					String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
					 
					//URL url = new URL("http://localhost:9999/ws/ruralHouses?wsdl");
					URL url = new URL(serviceName);

			 
			        //1st argument refers to wsdl document above
					//2nd argument is service name, refer to wsdl document above
//			        QName qname = new QName("http://businessLogic/", "FacadeImplementationWSService");
			        QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
			 
			        Service service = Service.create(url, qname);

			         return service.getPort(BLFacade.class);
				}catch(Exception e) {
					System.out.println("Error connecting: " + e.toString());
				}
			}
			return null;
		}
}
