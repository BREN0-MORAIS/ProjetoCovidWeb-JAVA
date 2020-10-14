package modelo;

/**
 *
 * @author vinicius
 * Usando herança de Pessoa
 */
public class Medico extends Pessoa{

    @Override
    public boolean isMedico() {
        return true;
    }
    
}
