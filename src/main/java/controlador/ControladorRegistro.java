/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import modelo.Candidato;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Yonathan
 */
@ManagedBean
@SessionScoped
public class ControladorRegistro implements Serializable {

    private static List<Candidato> listaCandidatos;
    private Candidato candidato;

    /**
     * Creates a new instance of Registro
     */
    public ControladorRegistro() {
        listaCandidatos = new ArrayList();
        candidato = new Candidato();
    }

    public List<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }

    public static void setListaCandidatos(List<Candidato> listaCandidatos) {
        ControladorRegistro.listaCandidatos = listaCandidatos;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public void cargarImagen(FileUploadEvent event) {
        try {
            candidato.setFoto(guardarImagen(event.getFile().getFileName(), event.getFile().getInputstream()));
        } catch (IOException e) {
        }
    }

    public String guardarImagen(String fileName, InputStream in) {
        String nombreA = "";
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext scontext = (ServletContext) context.getExternalContext().getContext();
            String ruta = scontext.getRealPath("\\") + "/resources/";
            try (OutputStream out = new FileOutputStream(new File(ruta + fileName))) {
                int read = 0;
                byte[] bytes = new byte[1024];
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                in.close();
                out.flush();
            }

            DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
            Date date = new Date();
            String ruta1 = ruta + fileName;
            String ruta2 = ruta + dateFormat.format(date) + fileName;
            File archivo = new File(ruta1);
            archivo.renameTo(new File(ruta2));
            nombreA = dateFormat.format(date) + fileName;
            FacesMessage msg = new FacesMessage("Imagen Cargada");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return nombreA;
    }

    public void agregarCandidato() {
        listaCandidatos.add(new Candidato(candidato.getDocumento(), candidato.getNombres(), candidato.getApellidos(), candidato.getFoto(), candidato.getFechaNacimiento(), candidato.getDescripcionHojaVida()));
        FacesMessage msg = new FacesMessage("Candidato", candidato.getNombres() + " " + candidato.getApellidos() + " agregado satisfactoriamente.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
