package countryInfoFromIP;

import CountryInfoService.CountryInfoService;
import CountryInfoService.CountryInfoServiceSoapType;
import GeoIpService.GeoIPService;
import GeoIpService.GeoIPServiceSoap;

public class CountryIPImpl implements CountryIP {

	@Override
	public String getCapitalFromCountryIP(String ip) {
		GeoIPServiceSoap geoIP = ( new GeoIPService()).getGeoIPServiceSoap();
		CountryInfoServiceSoapType countryInfo = ( new CountryInfoService()).getCountryInfoServiceSoap();
		
		String codigo = geoIP.getGeoIP(ip).getCountryCode();
		String capital = countryInfo.capitalCity(codigo);
		
		return capital;
	}
	
	@Override
	public String getCountryNameFromIP(String ip) {
		GeoIPServiceSoap geoIP = ( new GeoIPService()).getGeoIPServiceSoap();
		String countryName = geoIP.getGeoIP(ip).getCountryName();
		
		return countryName;
	}
	
	@Override
	public String getLinkToAFlagFromIP(String ip) {
		GeoIPServiceSoap geoIP = ( new GeoIPService()).getGeoIPServiceSoap();
		CountryInfoServiceSoapType countryInfo = ( new CountryInfoService()).getCountryInfoServiceSoap();
		
		String codigo = geoIP.getGeoIP(ip).getCountryCode();
		String linkToFlag = countryInfo.countryFlag(codigo);
		
		return linkToFlag;
	}
}
