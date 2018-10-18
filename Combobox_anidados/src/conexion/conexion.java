package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

  static String bd = "PEC"; // Nombre de la base de datos
   static String login = "sa";   // Usuario root de la base
   static String password = "123";  // Password de root
   static String url = "jdbc:sqlserver://localhost:1433;databaseName="+bd;//+"[sa on dbo]";  // Donde se localiza la base de datos
   int contador;
   Connection conn = null;
   
   
   
   
     public  conexion(){
         
        try{
         //obtenemos el driver de para mysql
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         
         //Hacemos la conexión a la base de datos
         conn = DriverManager.getConnection(url,login,password);

         if (conn!=null){
//             contador++;
//             if(contador>1){
//                 
//             }
//             else{
//                 System.out.println("Conexión a base de datos "+bd+" OK");
//             }
            
         }
         
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
       
            
   }
         
         
    /**Permite retornar la conexió
     * @return n*/
   public Connection getConnection(){
      return conn;
   }
   // Termina la transacción de SQL
   public void commit() throws SQLException{
       
       conn.commit();
       
   }
   // Finaliza la conexión a la base de datos
   public void desconectar(){
      conn = null;
      if(conn == null){
             System.out.println("Conexion terminada");
             
        }
   }
}
