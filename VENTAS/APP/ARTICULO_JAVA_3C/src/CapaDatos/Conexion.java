package CapaDatos;
import java.sql.*;

public class Conexion {

    private final String url = "jdbc:mysql://localhost:3306/ventas";
    private final String user = "root";
    private final String pass ="";

    public Conexion(){
    }

    public ResultSet Listar(String Cad){
     try {
         Connection cn = DriverManager.getConnection(url, user, pass);
         PreparedStatement da = cn.prepareStatement(Cad);
         ResultSet tbl = da.executeQuery();
         return tbl;
     } catch (SQLException e){
         javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
         return null;
     }
    }

    public String Ejecutar(String Cad){
        try{
            Connection cn = DriverManager.getConnection(url, user, pass);
            PreparedStatement da = cn.prepareStatement(Cad);
            int r = da.executeUpdate();
            return Validar(r);
        }catch(SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            return "Error " + e.getMessage();
        }
    }

    public String Validar(int r){
        if (r != 0){
            return "Se afectaron " + r + " filas";
        } else {
            return  "No se altero ninguna fila";
        }
    }
}
