package org.example;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Paso 2: Crear los parametros de conexion
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/hr";

        // Paso 1: Registrar el Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }

        //Paso 3: Establecer la conexion con MySQL
        try {
            Connection conn =   DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from countries");

            // Paso 4: Imprimir Resultados de ResultSet
            while(rs.next()){
                String idCountry = rs.getString(1);
                String pais = rs.getString(2);
                int idRegion = rs.getInt(3);

                System.out.println("ID_Pais: " + idCountry + " | País: " + pais + " | ID_Region: " + idRegion);

            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}