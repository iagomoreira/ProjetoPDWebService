
package CountryInfoService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This Visual DataFlex Web Service opens up country information. 2 letter ISO codes are used for Country code. There are functions to retrieve the used Currency, Language, Capital City, Continent and Telephone code.
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "CountryInfoService", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", wsdlLocation = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL")
public class CountryInfoService
    extends Service
{

    private final static URL COUNTRYINFOSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(CountryInfoService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = CountryInfoService.class.getResource(".");
            url = new URL(baseUrl, "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL', retrying as a local file");
            logger.warning(e.getMessage());
        }
        COUNTRYINFOSERVICE_WSDL_LOCATION = url;
    }

    public CountryInfoService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CountryInfoService() {
        super(COUNTRYINFOSERVICE_WSDL_LOCATION, new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoService"));
    }

    /**
     * 
     * @return
     *     returns CountryInfoServiceSoapType
     */
    @WebEndpoint(name = "CountryInfoServiceSoap")
    public CountryInfoServiceSoapType getCountryInfoServiceSoap() {
        return super.getPort(new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoServiceSoap"), CountryInfoServiceSoapType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CountryInfoServiceSoapType
     */
    @WebEndpoint(name = "CountryInfoServiceSoap")
    public CountryInfoServiceSoapType getCountryInfoServiceSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoServiceSoap"), CountryInfoServiceSoapType.class, features);
    }

}