package modelo;

public class Consulta {
    
    private int codigo;
    private Paciente paciente;
    private Medico medico;
    //Construtor sobrecarregado
    public Consulta(Paciente paciente, Medico medico){
        this.paciente = paciente;
        this.medico = medico;
    }
    public Medico getMedico(){
        return medico;
    }
    //assessor * acessa
    public Paciente getPaciente(){
        return paciente;
    }
    // modificador
    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }
    
    public void verificaAgendamento(Medico medico){}
    public void verificaAgendamento(Medico medico, Paciente paciente){}
}
