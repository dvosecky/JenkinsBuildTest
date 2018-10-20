

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoStuff
 */
public class DoStuff extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DoStuff() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CandyDao cd = new CandyDao();
//		cd.insertCandy(new Candy(null, "Ryan Kats", 2500, "Salty and Caramellicious"));
//		cd.insertCandy(new Candy(null, "Bobbert Cakes", 3750, "Sour and Caramellicious"));
//		int id = cd.insertCandy(new Candy(null, "Timber Pops", 12, "Woodchips and Caramellicious"));
//		
		System.out.println(cd.getAllCandys());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
