package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Kata5 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
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
        String nameFile = "C:\\Users\\usuario\\Desktop\\mail.txt";
        BufferedReader reader = new BufferedReader(new FileReader(new File(nameFile)));
        String mail;
        while((mail = reader.readLine()) != null){
            if(!mail.contains("@")) continue;
            query = "INSERT INTO MAILS (MAIL) VALUES ('"+mail+"')";
            state.executeUpdate(query);
        }
        conecta.commit();
        
        resultado.close();
        state.close();
        conecta.close();
    }
}
