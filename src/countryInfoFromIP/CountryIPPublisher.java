package countryInfoFromIP;

import javax.xml.ws.Endpoint;

public class CountryIPPublisher {
	public static void main(String[ ] args) {
	      // 1st argument is the publication URL
	      // 2nd argument is an SIB instance
	      Endpoint.publish("http://127.0.0.1:9876/ServiceSoapCountryIP", new CountryIPImpl());
//	      Endpoint.publish("http://127.0.0.1:10000/ServiceRestCountryIP", new CountryIPImpl());
	    }
}
