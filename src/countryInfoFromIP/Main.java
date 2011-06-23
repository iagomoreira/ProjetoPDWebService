package countryInfoFromIP;

public class Main {
	public static void main(String[] args) {
		CountryIPImpl app = new CountryIPImpl();
		System.out.println( app.getCapitalFromCountryIP("173.142.186.20"));
	}
}
