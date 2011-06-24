package clients;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import countryInfoFromIP.CountryIP;

public class CountryIPClienteSOAP {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8080/countryIP-SOAP/countryIP?wsdl");
		QName qname = new QName ("http://countryInfoFromIP/", "CountryIPImplService" );
		
		Service service = Service.create(url, qname);
		
		CountryIP eif = service.getPort(CountryIP.class);
		
		System.out.println(eif.getCapitalFromCountryIP("173.126.143.20"));
	}
}
