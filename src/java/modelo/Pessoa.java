package modelo;

/**
 *
 * @author vinicius
 */
public abstract class Pessoa {
    private Long codigo;
    private String nome;
    private String email;
    private String telefone;
    
    public Long getCodigo(){ return codigo; }
    
    public void setCodigo(long codigo){
        this.codigo = codigo;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setNome(String nome){
    this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    
    public abstract boolean isMedico();
}
