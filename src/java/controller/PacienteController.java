package controller;

import dao.PacienteDAO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Paciente;


@ManagedBean
@ViewScoped
public class PacienteController implements Serializable{
    PacienteDAO pacienteDAO;
    ArrayList<Paciente> pacientes;
    
    Paciente paciente;

    public PacienteController() {
        paciente = new Paciente();
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ArrayList<Paciente> getPacientes() {
        if(pacientes == null){
        pacienteDAO = new PacienteDAO();
        pacientes = pacienteDAO.listarPaciente();
        }
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    public String novo(){
      return "novo_paciente";
    }
   
    
    public String salvar(){
        pacienteDAO = new PacienteDAO();
        pacienteDAO.incluir(paciente);
 FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage("Sucesso", "Paciente Cadastrado!"));
        return "";
    }
    public String voltar(){
        return "listar_pacientes";
    }
    
    
}
