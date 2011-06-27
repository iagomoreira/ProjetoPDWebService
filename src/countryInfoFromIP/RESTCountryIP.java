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
@ServiceMode(value = javax.xml.ws.Service.Mode.MESSAGE)
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class RESTCountryIP implements Provider<Source>{

	@Resource
	protected WebServiceContext ws_ctx;
	protected static final CountryIPImpl countryIP = new CountryIPImpl();
	
	@Override
	public Source invoke(Source arg0) {
		
		if( ws_ctx == null ){
			throw new RuntimeException("Injection failed on ws_ctx");
		}
		
		MessageContext msg_ctx = ws_ctx.getMessageContext();
		String http_verb = (String) msg_ctx.get(MessageContext.HTTP_REQUEST_METHOD);
		http_verb = http_verb.trim().toUpperCase();
		
		if( http_verb.equals("GET")){
			return doGet(msg_ctx);
		}
		else{
			throw new HTTPException(405);
		}
		
	}
	
	private Source doGet( MessageContext msg_ctx ){
		String query_string = ( String ) msg_ctx.get(MessageContext.QUERY_STRING);
		String[] particaoQString = query_string.split("=");
		String parametro;
		
		if( particaoQString[0].toLowerCase() != "ip"){
			throw new HTTPException(400);
		}
		else{
			parametro = particaoQString[1].trim();
		}
		
		ByteArrayInputStream inputStream = encode_to_stream(countryIP.getCapitalFromCountryIP(parametro));
		
		return new StreamSource(inputStream);		
	}
	
	private ByteArrayInputStream encode_to_stream( Object object ){
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		XMLEncoder xmlEnc = new XMLEncoder(outStream);
		
		xmlEnc.writeObject(object);
		xmlEnc.close();
		
		return new ByteArrayInputStream(outStream.toByteArray());
	}

}
