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
 * @author alejandra
 */
@FacesValidator(value = "validacionDocumento")
public class Documento implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String texto = String.valueOf(value);
        if (value == null) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Debe ingresar un Documento");
            throw new ValidatorException(msg);
        }
        Integer documento = Integer.parseInt(texto);
        if (documento < 10000 || documento > 2147483647) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "El documento debe estar entre el rango de 10.000 y 2.147.483.647");
            throw new ValidatorException(msg);
        }
    }
}
