/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Yonathan
 */
@FacesValidator(value="validacionNombre")
public class Nombres implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String texto = String.valueOf(value);
        if(texto.isEmpty()){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Error", "Debe ingresar un Nombre");
            throw new ValidatorException(msg);
        }
        for (int i = 0; i < texto.length(); i++)
	{
            char caracter = texto.toUpperCase().charAt(i);
            int valorASCII = (int)caracter;
            if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "El Nombre no debe contener Números o Caracteres especiales");
                throw new ValidatorException(msg);
            }
	}
        if(texto.length()>30){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Error", "El Nombre no puede contener más de 30 caracteres");
            throw new ValidatorException(msg);
        }
    }
}
