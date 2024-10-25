import java.sql.Connection;
import java.sql.DriverManager;

public class ConProvider{
public static Connection con=null;
    public static Connection getConnection(){
  if (con==null){

    try{
            
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
          System.out.println("Connection Prepared"); 
          return con; 
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    return con;
                    }
                }
                    else
                        return con;
                    }
             
    
          }
