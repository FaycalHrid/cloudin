/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author asus
 */
@Entity
public class Repo implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Long id;
    private String nom;
    private String description;
    @OneToOne
    private Tache tache;
    @OneToMany(mappedBy = "Repo")
    private List<Solution> Solutions;
    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public List<Solution> getSolutions() {
        return Solutions;
    }

    public void setSolutions(List<Solution> Solutions) {
        this.Solutions = Solutions;
    }
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repo)) {
            return false;
        }
        Repo other = (Repo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Hub[ id=" + id + " ]";
    }
    
}
