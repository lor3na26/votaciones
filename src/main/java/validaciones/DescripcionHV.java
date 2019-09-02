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
@FacesValidator(value="validacionDescripcion")
public class DescripcionHV implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String texto = String.valueOf(value);
        if(texto.isEmpty()){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Error", "Debe ingresar una descripcion de la HV");
            throw new ValidatorException(msg);
        }
        for (int i = 0; i < texto.length(); i++)
	{
            char caracter = texto.charAt(i);
            int valorASCII = (int)caracter;
            if (valorASCII != 209 && valorASCII != 241  && (valorASCII < 65 || valorASCII > 90) && (valorASCII < 97 || valorASCII > 122) && (valorASCII < 48 || valorASCII > 57) && valorASCII != 32){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "La descripción no debe contener Caracteres especiales");
                throw new ValidatorException(msg);
            }
	}
    }
}
