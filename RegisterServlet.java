import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/save.servlet")
public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");

        if (password.equals(confirm_password)) {
        	String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            String cell_nos = request.getParameter("cell_nos");
            String profession = request.getParameter("Profession"); // Note: Case-sensitive

            // You can now use these values to insert into the database or perform other actions
            // For simplicity, I'll just print them here
            System.out.println("First_Name: " + fname);
            System.out.println("Last_Name: " + lname);
            System.out.println("Email: " + email);
            System.out.println("Cell_Numbers: " + cell_nos);
            System.out.println("Profession: " + profession);
        } else {
            // Passwords do not match, set an error message
            request.setAttribute("error", "Passwords do not match");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
