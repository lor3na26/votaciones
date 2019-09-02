/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Candidato;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.PieChartModel;



/**
 *
 * @author Yonathan
 */
@ManagedBean
@RequestScoped
public class ControladorVotar implements Serializable {

    @ManagedProperty("#{controladorRegistro}")
    private ControladorRegistro registro;
    private Candidato candidatoSeleccionado;
    private PieChartModel grafica;

    /**
     * Creates a new instance of Votar
     */
    public ControladorVotar() {
        grafica = new PieChartModel();
    }

    public ControladorRegistro getRegistro() {
        return registro;
    }

    public void setRegistro(ControladorRegistro registro) {
        this.registro = registro;
    }

    public Candidato getCandidatoSeleccionado() {
        return candidatoSeleccionado;
    }

    public void setCandidatoSeleccionado(Candidato candidatoSeleccionado) {
        this.candidatoSeleccionado = candidatoSeleccionado;
    }

    public PieChartModel getGrafica() {
        for (Candidato candidato : registro.getListaCandidatos()) {
            grafica.set(candidato.getNombres()+" "+candidato.getApellidos(), candidato.getVotos());
        }
        grafica.setTitle("Porcentajes de Votación");
        grafica.setLegendPosition("e");
        grafica.setFill(false);
        grafica.setShowDataLabels(true);
        grafica.setDiameter(300);
        grafica.setShadow(false);
        return grafica;
    }

    public void setGrafica(PieChartModel grafica) {
        this.grafica = grafica;
    }

    public void onRowSelect(SelectEvent event) {
        for (Candidato candidato : registro.getListaCandidatos()) {
            if(candidato.getDocumento().equals(((Candidato) event.getObject()).getDocumento())){
                candidato.setVotos(candidato.getVotos()+1);
                FacesMessage msg = new FacesMessage("Votó por el candidato ", ((Candidato) event.getObject()).getNombres());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }
}
