package kata5;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Kata5 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        //Connection conecta = DriverManager.getConnection("jdbc:oracle:thin:10.22.143.90:1521:orcl","system","orcl");
        Class.forName("org.sqlite.JDBC");
        Connection conecta = DriverManager.getConnection("jdbc:sqlite:Kata5.DB");
        
        Statement state = conecta.createStatement();
        String query = "SELECT * FROM PEOPLE";
        ResultSet resultado = state.executeQuery(query);
        while (resultado.next()){
            System.out.println("ID = "+resultado.getInt("ID"));
            System.out.println("Name = "+resultado.getString("NAME"));
        }
    }
}
