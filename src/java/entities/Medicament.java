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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "MEDICAMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicament.findAll", query = "SELECT m FROM Medicament m")
    , @NamedQuery(name = "Medicament.findByIdtraitement", query = "SELECT m FROM Medicament m WHERE m.idtraitement = :idtraitement")
    , @NamedQuery(name = "Medicament.findByMedicament", query = "SELECT m FROM Medicament m WHERE m.medicament = :medicament")
    , @NamedQuery(name = "Medicament.findByPosologie", query = "SELECT m FROM Medicament m WHERE m.posologie = :posologie")})
public class Medicament implements Serializable, EntityGestionPatient {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTRAITEMENT")
    private Integer idtraitement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MEDICAMENT")
    private String medicament;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "POSOLOGIE")
    private String posologie;
    @JoinColumn(name = "IDF", referencedColumnName = "IDF")
    @ManyToOne(optional = false)
    private FeuilleDeSoins idf;

    public Medicament() {
    }

    public Medicament(Integer idtraitement) {
        this.idtraitement = idtraitement;
    }

    public Medicament(Integer idtraitement, String medicament, String posologie) {
        this.idtraitement = idtraitement;
        this.medicament = medicament;
        this.posologie = posologie;
    }

    public Integer getIdtraitement() {
        return idtraitement;
    }

    public void setIdtraitement(Integer idtraitement) {
        this.idtraitement = idtraitement;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
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
        hash += (idtraitement != null ? idtraitement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicament)) {
            return false;
        }
        Medicament other = (Medicament) object;
        if ((this.idtraitement == null && other.idtraitement != null) || (this.idtraitement != null && !this.idtraitement.equals(other.idtraitement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Medicament[ idtraitement=" + idtraitement + " ]";
    }
    
}
