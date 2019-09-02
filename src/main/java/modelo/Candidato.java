/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Yonathan
 */
public class Candidato implements Serializable{
    private Integer documento;
    private String nombres;
    private String apellidos;
    private String foto;
    private Date fechaNacimiento;
    private String descripcionHojaVida;
    private int votos;

    public Candidato(Integer documento, String nombres, String apellidos, String foto, Date fechaNacimiento, String descripcionHojaVida) {
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.foto = foto;
        this.fechaNacimiento = fechaNacimiento;
        this.descripcionHojaVida = descripcionHojaVida;
    }

    public Candidato() {
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDescripcionHojaVida() {
        return descripcionHojaVida;
    }

    public void setDescripcionHojaVida(String descripcionHojaVida) {
        this.descripcionHojaVida = descripcionHojaVida;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    
}
