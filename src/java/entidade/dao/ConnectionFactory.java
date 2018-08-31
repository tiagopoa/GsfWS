package entidade.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    private final static String DRIVER = "org.postgresql.Driver";
    private final static String URL = "jdbc:postgresql://localhost:5432/gunshotdb";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "1234";
    
    /*private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/gunshotdb";
    private final static String USERNAME = "tiago";
    private final static String PASSWORD = "tiago919";*/
    
    public static Connection getConnection()throws SQLException {
        try {
            System.out.println(URL);
            Class.forName(DRIVER);
            System.out.println("Conectando ao banco...");
            Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return conexao;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nao foi possivel conectar ao banco de dados.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
