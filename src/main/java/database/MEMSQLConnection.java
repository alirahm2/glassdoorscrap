package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MEMSQLConnection {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://172.16.11.126:3306/repository","root","123a123A");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from TBL_CART");
            while(rs.next())
                System.out.println(rs.getObject(1));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

}
