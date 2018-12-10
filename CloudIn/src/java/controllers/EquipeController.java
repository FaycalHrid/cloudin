/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import bean.Equipe;
import java.util.List;
import javax.ejb.EJB;
import services.EquipeFacade;


/**
 *
 * @author asus
 */
@Named(value = "equipeController")
@SessionScoped
public class EquipeController implements Serializable {

    private Equipe selected;
    private List<Equipe> items;
    @EJB
        private EquipeFacade ejbFacade;

    public Equipe getSelected() {
        return selected;
    }

    public void setSelected(Equipe selected) {
        this.selected = selected;
    }

    public List<Equipe> getItems() {
        items = ejbFacade.findAll();
        return items;
    }

    public EquipeFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(EquipeFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public void setItems(List<Equipe> items) {
        this.items = items;
    }
    
    
    public String getNombreEquipes()
    {
        Integer nbr = getItems().size();
        return nbr.toString();
    }
    /**
     * Creates a new instance of EquipeController
     */
    public EquipeController() {
    }
    
}
