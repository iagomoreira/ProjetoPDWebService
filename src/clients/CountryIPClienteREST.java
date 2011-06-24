package clients;

import java.beans.XMLDecoder;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

public class CountryIPClienteREST {
	private static final String endpoint = "http://localhost:8080/countryIP-REST/restCountryIP";
	
	public static void main(String[] args) {
		
		Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("iago","testando".toCharArray());
            }
        });
		
		new CountryIPClienteREST().send_requests();
	}
	
	private void send_requests(){
		try{
			HttpURLConnection conn = getConnection( endpoint + "?ip=173.126.132.20", "GET");
			conn.connect();
			print_and_parse(conn);
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
	
	private void print_and_parse(HttpURLConnection conn) {
		try {
		String xml = "";

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String next = null;
		while ((next = reader.readLine()) != null){
			xml += next;
		}

		XMLDecoder dec = new XMLDecoder(new ByteArrayInputStream(xml.getBytes()));
		System.out.println(dec.readObject());
		}
		catch(IOException e) { System.err.println(e); }
		}
}
