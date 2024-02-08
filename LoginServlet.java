import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@jakarta.servlet.annotation.WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

       
        EmpDao dao = new EmpDao(); // Replace with your data access class
        Emp user = dao.login(email, password);

        if (user != null) {
           
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect("ViewServlet"); 
        } else {
          
            request.setAttribute("error", "Invalid email or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
