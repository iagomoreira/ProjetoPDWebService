package app;

import CountryInfoService.CountryInfoService;
import CountryInfoService.CountryInfoServiceSoapType;
import GeoIpService.GeoIPService;
import GeoIpService.GeoIPServiceSoap;

public class AppImpl implements App {

	@Override
	public String getCapitalFromCountryIP(String ip) {
		GeoIPServiceSoap geoIP = ( new GeoIPService()).getGeoIPServiceSoap();
		CountryInfoServiceSoapType countryInfo = ( new CountryInfoService()).getCountryInfoServiceSoap();
		
		String codigo = geoIP.getGeoIP(ip).getCountryCode();
		String capital = countryInfo.capitalCity(codigo);
		
		return capital;
	}

}
