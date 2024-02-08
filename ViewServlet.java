import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;  
  
 
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Employee List</title>");
        out.println("<style>");
        out.println("#header { display: inline; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        // Your menu/header content
        out.println("<div id='header'>");
        out.println("<h1>TelioLabs</h1>");
        out.println("<ul>");
        out.println("<li><a href='home.jsp'>Home</a></li>");
        out.println("<li><a href='#'>Admin</a></li>");
        out.println("<li><a href='#'>Reports</a></li>");
        out.println("<li><a href='index.jsp'>MyProfile</a></li>");
        out.println("<li><a href='#'>Logout</a></li>");
        out.println("</ul>");
        out.println("</div>");
        out.println("<a href='index.jsp'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<Emp> list=EmpDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>First_Name</th><th>Last_Name</th><th>Email</th><th>Password</th><th>Confirm_Password</th><th>Cell_Nos</th><th>Profession</th><th>Edit</th><th>Delete</th></tr>");  
        for(Emp e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getFirst_Name()+"</td><td>"+e.getLast_Name()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPassword()+"</td><td>"+e.getConfirm_Password()+"</td><td>"+e.getCell_Nos()+"</td><td>"+e.getProfession()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  