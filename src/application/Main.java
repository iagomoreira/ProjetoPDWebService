package application;

public class Main {
	public static void main(String[] args) {
		ApplicationImpl app = new ApplicationImpl();
		System.out.println( app.getCapitalFromCountryIP("173.142.186.20"));
	}
}
