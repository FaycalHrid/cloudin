/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import bean.Projet;
import java.util.List;
import javax.ejb.EJB;
import services.ProjetFacade;
/**
 *
 * @author asus
 */
@Named(value = "projetController")
@SessionScoped
public class ProjetController implements Serializable {
    
    private Projet selected;
    private List<Projet> items;
    @EJB
    private ProjetFacade ejbFacade;

    public Projet getSelected() {
        return selected;
    }

    public void setSelected(Projet selected) {
        this.selected = selected;
    }

    public List<Projet> getItems() {
        items = ejbFacade.findAll();
        return items;
    }

    public void setItems(List<Projet> items) {
        this.items = items;
    }

    public ProjetFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(ProjetFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }
    
     public String getNombreProjets()
    {
        Integer nbr = getItems().size();
        return nbr.toString();
    }
    
    /**
     * Creates a new instance of ProjetController
     */
    public ProjetController() {
    }
    
}
