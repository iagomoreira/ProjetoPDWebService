package countryInfoFromIP;

import java.io.IOException;
import javax.servlet.http.*;

public class CountryIPServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println(( new CountryIPImpl()).getCapitalFromCountryIP("173.184.132.20"));
	}

}
