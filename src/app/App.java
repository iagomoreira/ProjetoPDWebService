package app;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface App {
	@WebMethod String getCapitalFromCountryIP(@WebParam(name = "ip") String ip);
	
}
