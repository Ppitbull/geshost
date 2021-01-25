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
@Table(name = "REMBOURSEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remboursement.findAll", query = "SELECT r FROM Remboursement r")
    , @NamedQuery(name = "Remboursement.findByIdr", query = "SELECT r FROM Remboursement r WHERE r.idr = :idr")
    , @NamedQuery(name = "Remboursement.findByMontant", query = "SELECT r FROM Remboursement r WHERE r.montant = :montant")})
public class Remboursement implements Serializable, EntityGestionPatient {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "IDR")
    private String idr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "MONTANT")
    private String montant;
    @JoinColumn(name = "IDF", referencedColumnName = "IDF")
    @ManyToOne(optional = false)
    private FeuilleDeSoins idf;

    public Remboursement() {
    }

    public Remboursement(String idr) {
        this.idr = idr;
    }

    public Remboursement(String idr, String montant) {
        this.idr = idr;
        this.montant = montant;
    }

    public String getIdr() {
        return idr;
    }

    public void setIdr(String idr) {
        this.idr = idr;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
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
        hash += (idr != null ? idr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remboursement)) {
            return false;
        }
        Remboursement other = (Remboursement) object;
        if ((this.idr == null && other.idr != null) || (this.idr != null && !this.idr.equals(other.idr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Remboursement[ idr=" + idr + " ]";
    }
    
}
