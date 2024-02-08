import java.io.IOException;  
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;  
   
 
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
			 throws ServletException, IOException {  
        response.setContentType("text/jsp");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String fname=request.getParameter("fname");  
        String lname=request.getParameter("lname");  
        String email=request.getParameter("email");  
        String password=request.getParameter("password");
        String confirm_password=request.getParameter("confirm_password");  
        String cell_nos =request.getParameter("cell_nos");  
        String profession=request.getParameter("profession");  
          
        Emp e=new Emp();  
        e.setId(id);  
        e.setFirst_Name(fname);  
        e.setLast_Name(lname);  
        e.setEmail(email);  
        e.setPassword(password);  
        e.setConfirm_Password(confirm_password);  
        e.setCell_Nos(cell_nos);  
		e.setProfession(profession);  
          
        int status=EmpDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  	