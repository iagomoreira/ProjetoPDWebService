package countryInfoFromIP;

import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.http.HTTPException;
import javax.annotation.Resource;

@WebServiceProvider
@ServiceMode( value = javax.xml.ws.Service.Mode.MESSAGE)
@BindingType( value = HTTPBinding.HTTP_BINDING)
public class RESTCountryIP implements Provider<Source>{

	@Resource
	protected WebServiceContext webServiceContext;
	protected static final CountryIPImpl countryIP = new CountryIPImpl();
	
	@Override
	public Source invoke(Source arg0) {
		
		if( webServiceContext == null ){
			throw new RuntimeException();
		}
		
		MessageContext msgContext = webServiceContext.getMessageContext();
		String metodoHTTP = (String) msgContext.get(MessageContext.HTTP_REQUEST_METHOD);
		metodoHTTP = metodoHTTP.toUpperCase().trim();
		
		if( metodoHTTP.equals("GET")){
			return get(msgContext);
		}
		else{
			throw new HTTPException(405);
		}
		
	}
	
	private Source get( MessageContext msg ){
		String qString = ( String ) msg.get(MessageContext.QUERY_STRING);
		String[] particaoQString = qString.split("=");
		String parametro;
		if( particaoQString[0].toLowerCase() != "ip"){
			throw new HTTPException(400);
		}
		else{
			parametro = particaoQString[1].trim();
		}
		
		ByteArrayInputStream inputStream = objToStream(countryIP.getCapitalFromCountryIP(parametro));
		
		return new StreamSource(inputStream);		
	}
	
	private ByteArrayInputStream objToStream( Object object ){
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		XMLEncoder xmlEnc = new XMLEncoder(outStream);
		
		xmlEnc.writeObject(object);
		xmlEnc.close();
		
		return new ByteArrayInputStream(outStream.toByteArray());
	}

}
