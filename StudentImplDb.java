import java.util.Scanner;
import java.sql.*;
public class StudentImplDb {

  void add(){
     try{
   Connection con=ConProvider.getConnection();
   Scanner sc= new Scanner(System.in);
   System.out.println("Enter the Roll no.");
   int Roll_No=sc.nextInt();
   Boolean Status=search(Roll_No);
   if(Status==false){
       System.out.println("Enter the Name");
       String Name=sc.next();
       System.out.println("Enter the Father_Name");
       String Father_Name=sc.next();
       System.out.println("Enter the Course");
       String Course=sc.next();
       System.out.println("Enter the Fees");
       int Fees=sc.nextInt();
      
       
PreparedStatement ps=con.prepareStatement("Insert into Student(Roll_No,Name,Father_Name,Course,Fees) values(?,?,?,?,?)");
 
ps.setInt(1,Roll_No);
ps.setString(2,Name);
ps.setString(3,Father_Name);
ps.setString(4,Course);
ps.setInt(5,Fees);

ps.executeUpdate();
}else
{
    System.out.println("Roll no. already exists");
}
     }
    
     catch(Exception e){
         System.out.println(e);
     }
 }   
 Boolean search(int Roll_No){

     try{
         Connection con=ConProvider.getConnection();
         PreparedStatement ps=con.prepareStatement("Select * From Student where Roll_NO=?");
         ps.setInt(1, Roll_No);
         ResultSet rs=ps.executeQuery();
         return rs.next();


     }

     catch(Exception e){
         System.out.println(e);
         return false;
     }
 }
 void Display(){
     try{

        Connection con=ConProvider.getConnection();
        PreparedStatement ps=con.prepareStatement("Select * FRom Student");
        ResultSet rs=ps.executeQuery();
        System.out.println("Student record are as follows");
        while(rs.next()){
            System.out.println("Roll:"+rs.getInt(1)+"Name:"+rs.getString(2)+"Father_Name:"+rs.getString(3)+"Course:"+rs.getString(4)+"Fees:"+rs.getString(5));
        }
        System.out.println("");
        con.close();
     }catch(Exception e){
         System.out.println(e);
     }
 }
 void Update(int Roll_No){
Boolean s=search(Roll_No);
if(s){
try{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the Name");
    String name=sc.next();
    System.out.println("Enter the Father name");
    String Father_Name=sc.next();
    System.out.println("Enter the Course ");
    String Course=sc.next();
    System.out.println("Enter the Fees");
    int Fees=sc.nextInt();
    Connection con=ConProvider.getConnection();
PreparedStatement ps=con.prepareStatement("update Student set Name=?,course=?,fees=? ,Father_Name=? where Roll_No=?");
ps.setString(1, name);
ps.setString(2, Course);
ps.setInt(3, Fees);
ps.setString(4, Father_Name);
ps.setInt(5, Roll_No);
ps.executeUpdate();
System.out.println("Record Updated Successfully");

}
     
     catch(Exception e){
         e.printStackTrace();
     }
 }

else{
    System.out.println("Roll no . doesn't Exist");
}
 }
 void UpdateName(int Roll_No){
    Boolean s=search(Roll_No);
    if (s){
        try{
            Connection con=ConProvider.getConnection();
           Scanner sc= new Scanner(System.in);
            System.out.println("Enter the Name");
            String Name=sc.next();
PreparedStatement ps=con.prepareStatement("update Student set Name=? where Roll_No=?");
ps.setString(1,Name);
ps.setInt(2,Roll_No);
ps.executeUpdate();
System.out.println("Updated Name Successfully");


        }catch(Exception e){
            System.out.println(e);
        }
    }
    else{
        System.out.println("roll no. does not EXist") ;
    }
}
void UpdateFees(int Roll_NO){
    Boolean s=search(Roll_NO);
    if (s){
        try{
            Connection con=ConProvider.getConnection();

            Scanner sc= new Scanner(System.in);
            System.out.println("Enter the Fees");
            int Fees=sc.nextInt();
PreparedStatement ps=con.prepareStatement("update Student set Fees=? where Roll_No=?");
ps.setInt(1, Fees);
ps.setInt(2,Roll_No);
ps.executeUpdate();
System.out.println("Updated Fees Successfully");


        }catch(Exception e){
            System.out.println(e);
        }
    }
    else{
        System.out.println("roll no. does not EXist") ;
    }
}

void UpdateFather_Name(int Roll_NO){
    Boolean s=search(Roll_NO);
    if (s){
        try{
            Connection con=ConProvider.getConnection();

            Scanner sc= new Scanner(System.in);
            System.out.println("Enter the Father  Name");
            String Father_Name=sc.next();
PreparedStatement ps=con.prepareStatement("update Student set Father_Name=? where Roll_No=?");
ps.setString(1,Father_Name);
ps.setInt(2,Roll_No);
ps.executeUpdate();
System.out.println("Updated Father Name Successfully");


        }catch(Exception e){
            System.out.println(e);
        }
    }
    else{
        System.out.println("roll no. does not EXist") ;
    }
}


void Delete(int Roll_No){
     Boolean Status=search(Roll_No);
     if(Status){
         try{
             Connection con=ConProvider.getConnection();
             PreparedStatement ps=con.prepareStatement("Delete From Student where Roll_No=?");
             ps.setInt(1,Roll_No);
             ps.executeUpdate();
             System.out.println("Record Deleted Succesfully");

         }
         catch(Exception e){
             e.printStackTrace();
         }
     }else{
         System.out.println("Roll no. does not exist");
     }

 }
public static void main(String[] args) {
StudentImplDb DB1=new StudentImplDb();
int choice;
Scanner sc=new Scanner(System.in);
while(true){
System.out.println("1.Exit the Student Record");
System.out.println("2 For Add the record");
System.out.println("3.For Display the record");
System.out.println("4.Update the record");
System.out.println("5.Delete the Record");
choice=sc.nextInt();
switch(choice){
    case 1:
    {
        System.exit(0);
    }
    case 2:{
        DB1.add();
        break;
    }
    case 3:{
        DB1.Display();
        break;
    }
    case 4:{
      //  System.out.println("Enter the roll if you want to update record");
//int Roll_No=sc.nextInt();
System.out.println("Would you like to change");
System.out.println("Press 6 if you want to change Name");
System.out.println("press 7 if you want to change Father Name");
System.out.println("PRESS 8 if you want to change Fees");

//DB1.Update(Roll_No);
        break;
    }
    case 5:{
        System.out.println("Enter the roll no. if you want to delete");
int Roll_No=sc.nextInt();
DB1.Delete(Roll_No);
break;
    }
    case 6:{
        System.out.println("Enter the Roll no.");
        int Roll_No=sc.nextInt();
        
        //System.out.println("Enter the Name");
        //String name=sc.next();
        DB1.UpdateName(Roll_No);

        break;
    }
    
    case 7:{
        System.out.println("Enter the Roll no.");
        int Roll_No=sc.nextInt();
        
        //System.out.println("Enter the Father Name");
        //String Father_name=sc.next();
        DB1.UpdateFather_Name(Roll_No);

        break;
    }
    case 8:{
        System.out.println("Enter the Roll no.");
        int Roll_No=sc.nextInt();
    //    System.out.println("Enter the Fees");
      //  int Fees=sc.nextInt();
        DB1.UpdateFees(Roll_No);

        break;
    }
    
    default:{
System.out.println("invalid input");
    }
}    
}
}
}

