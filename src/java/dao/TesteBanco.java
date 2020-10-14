package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import modelo.Paciente;

/**
 *
 * @author vinicius
 */
public class TesteBanco {
  public static void main(String[] args){
      Conexao conexao = new Conexao();
      conexao.conectar(); // Já está tratado..
      try {
String SQL = "insert into PESSOA(id_pessoa, nome, cpf , rg, data_nasc, endereco, telefone)"
        + "values(?, ?, ? , ?, ? , ?, ?)";
        
       PreparedStatement ps =  conexao.getConexao().prepareStatement(SQL);
       //Preenche a instrução SQL
       ps.setInt(1, 9);
       ps.setString(2, "RHUAN");
       ps.setString(3, "123123");
       ps.setString(4, "123123");
       ps.setDate(5, new java.sql.Date(new Date().getTime()));
       ps.setString(6, "RUA X");
       ps.setString(7, "88888888");
       //Realiza
       ps.execute();
       
    String selectPessoa = "select * from PESSOA";
    PreparedStatement psSelectPessoa = conexao.getConexao().prepareStatement(selectPessoa);
    //Retorna os dados da tabela no formato conjunto
    ResultSet rs = psSelectPessoa.executeQuery();
    ArrayList<Paciente> lista = new ArrayList<>();
    Paciente paciente;
    while(rs.next()){
    // Pega os dados da linha na tabela
    String nome = rs.getString("nome");
    String telefone = rs.getString("telefone");
    String email = rs.getString("email");
    paciente = new Paciente(nome, email, telefone);
    
    lista.add(paciente);
    System.out.println("Nome " + nome);
    System.out.println("Tel " + telefone);
    System.out.println("----------------");
    }
       } catch (SQLException ex) {
           ex.printStackTrace();
      }
   }    
}
