/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import bean.Repo;
import java.util.List;
import javax.ejb.EJB;
import services.RepoFacade;


/**
 *
 * @author asus
 */
@Named(value = "repoController")
@SessionScoped
public class RepoController implements Serializable {

    private Repo selected;
    private List<Repo> items;
    @EJB
    private RepoFacade ejbFacade;

    public RepoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(RepoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public Repo getSelected() {
        return selected;
    }

    public void setSelected(Repo selected) {
        this.selected = selected;
    }
    
    public List<Repo> getItems() {
        items = ejbFacade.findAll();
        return items;
    }

    public void setItems(List<Repo> items) {
        this.items = items;
    }
    
     public String getNombreRepos()
    {
        Integer nbr = getItems().size();
        return nbr.toString();
    }
    
    
    /**
     * Creates a new instance of RepoController
     */
    public RepoController() {
    }
    
}
