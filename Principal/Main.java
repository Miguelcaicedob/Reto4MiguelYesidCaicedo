package Principal;
import vistas.*;
import Modelo.*;

public class Main {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.getConnection();
        
        Login login = new Login();
        login.setVisible(true); 
    }
    
}
