
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class Paises {
    private String id;
    private String nombre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString(){
        return this.nombre;
    }
    
    public Vector<Paises> mostrarPaises(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion conn = new conexion();
        Connection con = conn.getConnection();
        


       Vector<Paises> datos = new Vector<Paises>();
       Paises dat = null;
        
        try{
            String sql = "SELECT * FROM Pais";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
//                    combo_pais.addItem("Selecciona el pais");
            dat = new Paises();
            dat.setId("");
            dat.setNombre("Selecciona el Pais");
            datos.add(dat);
//            datos.remove(dat);
            
            while(rs.next()){
//                combo_pais.addItem(rs.getString("id_pais")+"-"+rs.getString("nombre_pais"));
            dat = new Paises();
            dat.setId(rs.getString("id_pais"));
            dat.setNombre(rs.getString("id_pais")+"-"+rs.getString("nombre_pais"));
            datos.add(dat);
            }
            rs.close();
        }catch(SQLException ex){
            System.out.println("Error");
        }
        
        return datos;
    }
}
