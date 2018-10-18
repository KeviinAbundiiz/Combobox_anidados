
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class Ciudades {
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
    
    public Vector<Ciudades> mostrarCiudades(String id_estado){
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion conn = new conexion();
        Connection con = conn.getConnection();
        


       Vector<Ciudades> datos = new Vector<Ciudades>();
       Ciudades dat = null;
        
        try{
            String sql = "SELECT * FROM Ciudad WHERE id_estado='"+id_estado+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            //        combo_pais.addItem("Selecciona el pais");
            dat = new Ciudades();
            dat.setId("");
            dat.setNombre("Selecciona la Ciudad");
            datos.add(dat);
//            datos.remove(dat);
            
            while(rs.next()){
//                combo_pais.addItem(rs.getString("id_pais")+"-"+rs.getString("nombre_pais"));
            dat = new Ciudades();
            dat.setId(rs.getString("id_ciudad"));
            dat.setNombre(rs.getString("id_ciudad")+"-"+rs.getString("nombre_ciudad"));
            datos.add(dat);
            }
            rs.close();
        }catch(SQLException ex){
            System.out.println("Error");
        }
        
        return datos;
    }
}
