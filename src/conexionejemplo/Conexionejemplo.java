/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexionejemplo;

/**
 *
 * @author USUARIO
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conexionejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/datosudb";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = java.sql.DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("select * from usuario");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //insertar datos
            statement.execute("INSERT INTO `usuario` (`Id`, `nombre`, `password`, `correo`) VALUES (NULL, 'CARMEN', '5315', 'carmen@gmail.com');");
             System.out.println("");
            rs = statement.executeQuery("select * from usuario");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            //actulizar datos
            statement.execute("UPDATE `usuario` SET `nombre` = 'bonita' WHERE `usuario`.`Id` = 5;");
             System.out.println("");
            rs = statement.executeQuery("select * from usuario");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //eliminacion
            statement.execute("DELETE FROM `usuario` WHERE `usuario`.`Id` = 8;");
             System.out.println("");
            rs = statement.executeQuery("select * from usuario");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexionejemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
    }
    
}
   
