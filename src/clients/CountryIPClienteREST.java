package clients;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CountryIPClienteREST {
	private static final String endpoint = "http://localhost:8080/countryIP-REST/restCountryIP";
	
	public static void main(String[] args) {
		new CountryIPClienteREST().send_requests();
	}
	
	private void send_requests(){
		try{
			HttpURLConnection conn = getConnection( endpoint + "?name=Iago", "GET");
			conn.connect();
			System.out.println( conn.getContent() );
		}catch( IOException e ){
			System.err.println(e);
		}catch( NullPointerException e ){
			System.err.println(e);
		}
	}
	
	private HttpURLConnection getConnection( String url_string, String verb ){
		HttpURLConnection conn = null;
		try{
			URL url = new URL(url_string);
			conn = ( HttpURLConnection ) url.openConnection();
			conn.setRequestMethod(verb);
		}catch( MalformedURLException e ){
			System.err.println(e);
		}catch( IOException e ){
			System.err.println(e);
		}
		
		return conn;
	}
}
