package modelo;

import java.io.Serializable;


public class Paciente extends Pessoa implements Serializable{
   private Exame exame;

    public Paciente() {
    }
   
   
   
   public Paciente(String nome, String email, String telefone){
       super.setNome(nome);
       super.setEmail(email);
       super.setTelefone(telefone);     
   }
   
   @Override
   public String getNome(){
       if(super.getNome() == null){
         return "Paciente";
       }
       return super.getNome();
   }
 
   public Exame getExame(){
       return exame;
   }
   public void setExame(Exame exame){
       this.exame = exame;
   }

    @Override
    public boolean isMedico() {
        return false;
    }
    
   
}
