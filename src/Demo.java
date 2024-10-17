import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo
{
 public static void main(String args[])throws Exception
 {
     String sql="Select name from myDetails where Serial_No=1";
     String url="jdbc:mysql://localhost:3306/MyDatabase";
     String username="root";
     String password="root";

     Connection con= DriverManager.getConnection(url,username,password);
     Statement st=con.createStatement();
     ResultSet rs= st.executeQuery(sql);
     rs.next();
     String name = rs.getString(1);
     System.out.println("name:"+name);

     rs.close();
     st.close();
     con.close();
 }

}
