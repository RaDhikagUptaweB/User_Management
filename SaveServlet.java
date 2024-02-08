import java.io.IOException;  
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String fname=request.getParameter("fname");  
        String lname=request.getParameter("lname");  
        String email=request.getParameter("email");  
        String password=request.getParameter("password"); 
        String confirm_password=request.getParameter("confirm_password"); 
        String cell_nos=request.getParameter("cell_nos"); 
        String Profession=request.getParameter("Profession");  
        
        Emp e = new Emp();
        e.setFirst_Name(fname);
        e.setLast_Name(lname);
        e.setEmail(email);
        e.setPassword(password);
        e.setConfirm_Password(confirm_password);
        e.setCell_Nos(cell_nos);
		e.setProfession(Profession);
        
        
        int status=EmpDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
        
        
    
}