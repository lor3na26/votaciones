/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Candidato;

/**
 *
 * @author Yonathan
 */
@ManagedBean
@SessionScoped
public class ControladorFinalizar implements Serializable{

    @ManagedProperty("#{controladorRegistro}")
    private ControladorRegistro registro;
    private Candidato candidato;
    /**
     * Creates a new instance of ControladorFinalizar
     */
    public ControladorFinalizar() {
    }

    public ControladorRegistro getRegistro() {
        return registro;
    }

    public void setRegistro(ControladorRegistro registro) {
        this.registro = registro;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    public void candidatoGanador(){
        for(Candidato candidatoL : registro.getListaCandidatos()){
            if(this.candidato != null){
                if(this.candidato.getVotos()<candidatoL.getVotos()){
                    this.candidato=candidatoL;
                }
            }else{
                this.candidato = candidatoL;
            }
        }
    }
    
    public void volverInicio() throws IOException{
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().redirect("registro.xhtml");
    }
}
