/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baglanti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Okcen
 */
public class baglan {
    public Connection baglan() throws ClassNotFoundException{
     Connection conn;
     
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
              
      conn=null;
      String dburl="jdbc:sqlserver://localhost:1433;databaseName=Sorular;user=admin;password=123456";
      try{
    
        conn=DriverManager.getConnection(dburl);
        System.out.println("baglanti basarili");
      }
      catch(SQLException e)
      {
          System.out.println(e);
      }
      return conn;
     
         
      
      
  }
}
