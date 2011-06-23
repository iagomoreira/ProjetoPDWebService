package application;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface Application {
	@WebMethod String getCountryNameFromIP( @WebParam( name = "ip") String ip);
	@WebMethod String getCapitalFromCountryIP(@WebParam(name = "ip") String ip);
	
}
