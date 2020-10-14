package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {
    
    Connection conn;
    
   public void conectar(){
        try {
            //Carregar o driver do banco mysql NA VERSÃO 5
            Class.forName("com.mysql.jdbc.Driver");
            // Para versão mais novas mudou ... com.mysql.cj.jdbc.Driver
            
            // Tenta conectar via jdbc
            String url = "jdbc:mysql://localhost/projeto_covid";
            String usuario = "root";
            String senha = "root";
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException ex) {
            // Deu zebra Não achou a classe
            ex.printStackTrace();
        } catch (SQLException e) {
             e.printStackTrace();
        }
   }
   public Connection getConexao(){
       return conn;
   }
   
   public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
   }
}