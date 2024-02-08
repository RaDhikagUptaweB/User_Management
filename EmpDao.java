 import java.util.*;
import java.sql.*;


public class EmpDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teliolabs", "root", "T#9758@qlphr");
	        
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public static int save(Emp e) {
		int status = 0;
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into emp(fname,lname,email,password,confirm_password,cell_nos,Profession) values (?,?,?,?,?,?,?)");
			ps.setString(1, e.getFirst_Name());
			ps.setString(2, e.getLast_Name());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPassword());
			ps.setString(5, e.getConfirm_Password());
			ps.setString(6, e.getCell_Nos());
			ps.setString(7, e.getProfession());
			
			status=ps.executeUpdate();
			con.close();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps= con.prepareStatement( "update emp set fname=?,lname=?,email=?,password=?,confirm_password=?,cell_nos=?, Profession=? where id=?");
            ps.setString(1,e.getFirst_Name());  
            ps.setString(2,e.getLast_Name());  
            ps.setString(3,e.getEmail());
            ps.setString(4,e.getPassword());
            ps.setString(5, e.getConfirm_Password());
            ps.setString(6, e.getCell_Nos());
            ps.setString(7,e.getProfession());  
            ps.setInt(8,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from emp where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();  
            
          con.close();  
      }catch(Exception e){e.printStackTrace();}  
        
      return status;  
  }  
  public static Emp getEmployeeById(int id){  
      Emp e=new Emp();  
        
      try{  
          Connection con=EmpDao.getConnection();
          PreparedStatement ps=con.prepareStatement("select * from emp where id=?");  
          ps.setInt(1,id);  
          ResultSet rs=ps.executeQuery();  
          if(rs.next()){  
              e.setId(rs.getInt(1));  
              e.setFirst_Name(rs.getString(2)); 
              e.setLast_Name(rs.getString(3)); 
              e.setEmail(rs.getString(4));  
              e.setPassword(rs.getString(5)); 
              e.setConfirm_Password(rs.getString(6));
              e.setCell_Nos(rs.getString(7));
              e.setProfession(rs.getString(8));
		}
          con.close();
	}
      catch(Exception ex) {
    	  ex.printStackTrace();
      }
      return e;
  }
    		  public static List<Emp> getAllEmployees(){  
          List<Emp> list=new ArrayList<Emp>();  
            
          try{  
              Connection con=EmpDao.getConnection();  
              PreparedStatement ps=con.prepareStatement("select * from emp");  
              ResultSet rs=ps.executeQuery();  
              while(rs.next()){  
                  Emp e=new Emp();  
                  e.setId(rs.getInt(1)); 
                  e.setFirst_Name(rs.getString(2));  
                  e.setLast_Name(rs.getString(3)); 
                  e.setEmail(rs.getString(4));  
                  e.setPassword(rs.getString(5)); 
                  e.setConfirm_Password(rs.getString(6));
                  e.setCell_Nos(rs.getString(7));
                  e.setProfession(rs.getString(8));  
                  list.add(e);  
              }  
              con.close();  
          }catch(Exception e){e.printStackTrace();}  
            
          return list;
    		  }
          
          public static Emp login(String email, String password) {
        	    Emp emp = null;
        	    try {
        	        Connection con = getConnection();
        	        String query = "SELECT * FROM emp WHERE email = ? AND password = ?";
        	        PreparedStatement ps = con.prepareStatement(query);
        	        ps.setString(1, email);
        	        ps.setString(2, password);

        	        ResultSet rs = ps.executeQuery();
        	        if (rs.next()) {
        	            emp = new Emp();
        	            emp.setId(rs.getInt(1));
        	            emp.setFirst_Name(rs.getString(2));
        	            emp.setLast_Name(rs.getString(3));
        	            emp.setEmail(rs.getString(4));
        	            emp.setPassword(rs.getString(5));
        	            emp.setConfirm_Password(rs.getString(6));
        	            emp.setCell_Nos(rs.getString(7));
        	            emp.setProfession(rs.getString(8));
        	        }
        	        con.close();
        	    } catch (Exception ex) {
        	        ex.printStackTrace();
        	    }
        	    return emp;
    		  }
}