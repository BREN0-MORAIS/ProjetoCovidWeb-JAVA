package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginController {
    
    public String efetuarLogin(){
        return "listar_pacientes";
    }
}
