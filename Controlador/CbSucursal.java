package Controlador;

import Modelo.*; // esto se hace solo con paquetes creados por el programador 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CbSucursal {
    // consultar las sucursales dispobibles :SELECT => Statement y resulset
    // ResultSET, nos devuelve la lista
    // insert, update y delete -> statement 
    Connection connection;
    Conexion conexion = new Conexion();
    Statement st;  
    ResultSet rs;     

    public CbSucursal() {
    }
    /* es una funcion y hay que retornar
    cuando se declara la funcion le decimos que nos va a retornar un ArrayList
    String [] nombresSucursales = new String[3] tendria que saber cuales son los datos de antemano
    el arraylist nos permite almacenar dos valores y es dinamico, obtenemos el Id sucursal y el nombre sucursal */
    public ArrayList getListaSucursales(){
        System.out.println("Ingrese a la funcion getListaSucursales");
        ArrayList mListaSucursales = new ArrayList(); 
        Sucursal sucursal = null;
        String querySucursales = "SELECT idSucursal, nombreSucursal FROM `sucursal`;";
        try{
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(querySucursales);
            while(rs.next()){
                sucursal = new Sucursal();
                // el id Sucursal me devuelve la consulta select
                int idSucursal = rs.getInt("idSucursal");
                String nombreSucursal = rs.getString("nombreSucursal");
                // asignamos los valores que nos devuelve la BD a los atributos de la clase sucursal
                sucursal.setIdSucursal(idSucursal);
                sucursal.setNombreSucursal(nombreSucursal); 
                mListaSucursales.add(sucursal);
            }
        }catch(SQLException e){
            System.out.println(e);
            
        }
        System.out.println(mListaSucursales);
        return mListaSucursales;
    }
}
