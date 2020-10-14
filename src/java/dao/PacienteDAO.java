package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Paciente;


public class PacienteDAO {
    Conexao conexao;
    String SQL = "insert into PESSOA(NOME_PESSOA, telefone, email)"
                    + "values(?, ?, ?)";  
    String sqlSelectPaciente = "select * from PESSOA";
    String sqlUpdatePaciente = "update PESSOA set nome=?, email=?, telefone=? where ID_PESSOA = ?";
    String sqlDeletePaciente = "delete from PESSOA where ID_PESSOA = ?";
    PreparedStatement psSelectPessoa, psInsertPessoa, psUpdatePessoa, psDeletePessoa;
    public PacienteDAO(){
        try {
            //Conectar no banco
            conexao = new Conexao();
            conexao.conectar();
     psInsertPessoa =  conexao.getConexao().prepareStatement(SQL);
     psSelectPessoa = conexao.getConexao().prepareStatement(sqlSelectPaciente);
     psUpdatePessoa = conexao.getConexao().prepareStatement(sqlUpdatePaciente);
     psDeletePessoa = conexao.getConexao().prepareStatement(sqlDeletePaciente);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void incluir(Paciente paciente){
     try {
            //Preenche a instrução SQL
          //  psInsertPessoa.setInt(1, 50);
            psInsertPessoa.setString(1, paciente.getNome());
            psInsertPessoa.setString(2, paciente.getTelefone());
            psInsertPessoa.setString(3, paciente.getEmail());
//            psInsertPessoa.setDate(5, new java.sql.Date(new Date().getTime()));
//            psInsertPessoa.setString(6, "RUA X");
//            psInsertPessoa.setString(7, "");
            //Realiza
            psInsertPessoa.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     
    
    }
    public void alterar(Paciente paciente){
        try{
           psUpdatePessoa.setString(1, paciente.getNome());
           psUpdatePessoa.setString(2, paciente.getEmail());
           psUpdatePessoa.setString(3, paciente.getTelefone());
           psUpdatePessoa.setInt(4, paciente.getCodigo().intValue());
           
           psUpdatePessoa.executeUpdate();
        }catch(SQLException ex){
        ex.printStackTrace();
        }
    
    
    }
    
    public Paciente getPaciente(int codigo){
    return new Paciente("", "", "");
    }
    //Exclusão lógica
    public void desativar(Paciente paciente){
        try {
            psDeletePessoa.setInt(1, paciente.getCodigo().intValue());
            psDeletePessoa.executeUpdate();
        } catch (SQLException ex) {
              ex.printStackTrace();
        }
    }
    
    public ArrayList<Paciente> listarPaciente(){
       ArrayList<Paciente> lista = new ArrayList<>();
        try {
            ResultSet rs = psSelectPessoa.executeQuery();            
            Paciente paciente;
            while(rs.next()){
                // Pega os dados da linha na tabela
                int id = rs.getInt("id_pessoa");
                String nome = rs.getString("nome_pessoa");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                paciente = new Paciente(nome, email, telefone);
                paciente.setCodigo(id);
                
                lista.add(paciente);
                System.out.println("Nome " + nome);
                System.out.println("Tel " + telefone);
                System.out.println("----------------");
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return lista;
        }
    }
}

