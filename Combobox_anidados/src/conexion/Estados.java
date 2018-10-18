
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class Estados {
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
    
    public Vector<Estados> mostrarEstados(String id_pais){
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion conn = new conexion();
        Connection con = conn.getConnection();
        


       Vector<Estados> datos = new Vector<Estados>();
       Estados dat = null;
        
        try{
            String sql = "SELECT * FROM Estado WHERE id_pais='"+id_pais+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            //        combo_pais.addItem("Selecciona el pais");
            dat = new Estados();
            dat.setId("");
            dat.setNombre("Selecciona el Estado");
            datos.add(dat);
//            datos.remove(dat);
            
            while(rs.next()){
//                combo_pais.addItem(rs.getString("id_pais")+"-"+rs.getString("nombre_pais"));
            dat = new Estados();
            dat.setId(rs.getString("id_estado"));
            dat.setNombre(rs.getString("id_estado")+"-"+rs.getString("nombre_estado"));
            datos.add(dat);
            }
            rs.close();
        }catch(SQLException ex){
            System.out.println("Error");
        }
        
        return datos;
    }
}
