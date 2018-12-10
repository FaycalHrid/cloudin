/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import bean.Utilisateur;
import services.UtilisateurFacade;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author asus
 */
@Named(value = "utilisateurController")
@SessionScoped
public class UtilisateurController implements Serializable {
     
    private Utilisateur selected;
     private List<Utilisateur> items;
        private String conf_password;

    public String getConf_password() {
        return conf_password;
    }

    public void setConf_password(String conf_password) {
        this.conf_password = conf_password;
    }
        @EJB
        private UtilisateurFacade ejbFacade;
        
    public void initParam()
    {
        selected = new Utilisateur();
    }
    
     public String create() {
         if(!conf_password.equals(selected.getPassword()))
         {
             return null;
         }
        ejbFacade.create(selected);
        initParam();
        conf_password = "";
        return null;
    }

     public String deconnexion()
     {
         selected = null;
         return "login.xhtml?faces-redirect=true";
     }
     
     public String getFullName()
     {
         return selected.getPrenom() + " "+selected.getNom();
     }
     
     
     public String authenticate()
     {
         if(findbyUsername()==null)
             return "";
         else
             selected = findbyUsername();
         return "index.xhtml?faces-redirect=true";
     }
     
     public Utilisateur findbyUsername()
     {
         List<Utilisateur> liste = getItems();
         for(Utilisateur ut : liste)
         {
             if(ut.getUsername().equals(selected.getUsername())&&ut.getPassword().equals(selected.getPassword()))
                 return ut;
         }
         return null;
     }
    
     public void resetChamps()
     {
         selected.setNom("");
         selected.setPrenom("");
         selected.setPassword("");
         selected.setUsername("");
         conf_password = "";
         selected.setEmail("");
     }
     
    public Utilisateur getSelected() {
         if (selected == null) {
            selected = new Utilisateur();
        }
        return selected;
    }

    public void setSelected(Utilisateur selected) {
        this.selected = selected;
    }

    public List<Utilisateur> getItems() {
        items = ejbFacade.findAll();
        return items;
    }

    public void setItems(List<Utilisateur> items) {
        this.items = items;
    }

    public UtilisateurFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(UtilisateurFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }
       
    public UtilisateurController() {
       
    }
    
}
