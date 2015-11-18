package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MailListReaderDDBB {

    public static ArrayList<String> read(String nameFile) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException{
        ArrayList <String> mailList = new ArrayList <>();
        Class.forName("org.sqlite.JDBC");
        Connection conecta = DriverManager.getConnection("jdbc:sqlite:Kata5.DB");
        Statement state = conecta.createStatement();
        BufferedReader fileMail = new BufferedReader(new FileReader(new File(nameFile)));
        
        String mail;
        String query = "SELECT * FROM MAILS";

        ResultSet resultado = state.executeQuery(query);
        while (resultado.next()){
            mail = resultado.getString("MAIL");
            if (!mail.contains("@")) continue;
            mailList.add(mail);
        }
        
        resultado.close();
        state.close();
        conecta.close();
        
        return mailList;
    }
    
}
