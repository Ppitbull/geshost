/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ppitbull
 */
@Entity
@Table(name = "EXAMEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e")
    , @NamedQuery(name = "Examen.findByIdpara", query = "SELECT e FROM Examen e WHERE e.idpara = :idpara")
    , @NamedQuery(name = "Examen.findByCategorie", query = "SELECT e FROM Examen e WHERE e.categorie = :categorie")
    , @NamedQuery(name = "Examen.findByNom", query = "SELECT e FROM Examen e WHERE e.nom = :nom")})
public class Examen implements Serializable, EntityGestionPatient {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPARA")
    private Long idpara;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "CATEGORIE")
    private String categorie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "NOM")
    private String nom;
    @JoinColumn(name = "IDF", referencedColumnName = "IDF")
    @ManyToOne(optional = false)
    private FeuilleDeSoins idf;

    public Examen() {
    }

    public Examen(Long idpara) {
        this.idpara = idpara;
    }

    public Examen(Long idpara, String categorie, String nom) {
        this.idpara = idpara;
        this.categorie = categorie;
        this.nom = nom;
    }

    public Long getIdpara() {
        return idpara;
    }

    public void setIdpara(Long idpara) {
        this.idpara = idpara;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public FeuilleDeSoins getIdf() {
        return idf;
    }

    public void setIdf(FeuilleDeSoins idf) {
        this.idf = idf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpara != null ? idpara.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.idpara == null && other.idpara != null) || (this.idpara != null && !this.idpara.equals(other.idpara))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Examen[ idpara=" + idpara + " ]";
    }
    
}
