
package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class Conectar {
    Connection connection = null;
    public Connection conexion()
    {
		try {
        // Abrir conexión a la base de datos
       // connection = DriverManager.getConnection("jdbc:sqlite:conexion.db");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpintegrador","root","Admin");
            System.out.println("conexion establecida");
      //JOptionPane.showMessageDialog(null,"Conectado");

        // Crear tabla "Pronosticotest1"
        Statement statement = connection.createStatement();
//id INTEGER PRIMARY KEY,
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Pronosticotest1 (participante TEXT, equipo1  TEXT,gana1 TEXT,empate TEXT,gana2 TEXT,equipo2 TEXT)");
//id INTEGER PRIMARY KEY,
        // Insertar un registro en la tabla "persona"
        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO Pronosticotest1 (participante, equipo1 ,gana1,empate,gana2 ,equipo2 ) VALUES (?,?,?,?,?,?)");


        insertStatement.setString(1,"Marina");
        insertStatement.setString(2,"Argentina");
        insertStatement.setString( 3,"X");
        insertStatement.setString(4,"-");
        insertStatement.setString(5,"-");
        insertStatement.setString(6,"Arabia");
        insertStatement.executeUpdate();

        // Eliminar el registro insertado anteriormente
        //PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM persona WHERE nombre = ?");
        //deleteStatement.setString(1, "Pedro");
        //deleteStatement.executeUpdate();

        // Consultar todos los registros de la tabla "persona"
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM  Pronosticotest1");
        while (resultSet.next()) {
           //int id = resultSet.getInt("id");
            String participante = resultSet.getString("Participante");
           String equipo1 = resultSet.getString("Equipo1");
            String gana1 = resultSet.getString("gana1");
            String empate = resultSet.getString("empate");
            String gana2 = resultSet.getString("gana2");
            String equipo2 = resultSet.getString("equipo2");
            System.out.println(/*"id: " + id  +*/  " Participante: " + participante + "Equipo1: " + equipo1+ "gana1" + gana1+ "empate"+ empate +"gana2" + gana2 + "equipo2"+ equipo2);
        }

        // Cerrar la conexión a la base de datos
        connection.close();
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
        return connection;
    }
}


