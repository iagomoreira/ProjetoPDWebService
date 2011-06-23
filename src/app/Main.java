package app;

public class Main {
	public static void main(String[] args) {
		AppImpl app = new AppImpl();
		System.out.println( app.getCapitalFromCountryIP("173.142.186.20"));
	}
}
