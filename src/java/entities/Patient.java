/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ppitbull
 */
@Entity
@Table(name = "PATIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
    , @NamedQuery(name = "Patient.findByIdpatient", query = "SELECT p FROM Patient p WHERE p.idpatient = :idpatient")
    , @NamedQuery(name = "Patient.findByNoms", query = "SELECT p FROM Patient p WHERE p.noms = :noms")
    , @NamedQuery(name = "Patient.findByPrenoms", query = "SELECT p FROM Patient p WHERE p.prenoms = :prenoms")
    , @NamedQuery(name = "Patient.findByNumcni", query = "SELECT p FROM Patient p WHERE p.numcni = :numcni")
    , @NamedQuery(name = "Patient.findByDatenaiss", query = "SELECT p FROM Patient p WHERE p.datenaiss = :datenaiss")
    , @NamedQuery(name = "Patient.findByLieunaiss", query = "SELECT p FROM Patient p WHERE p.lieunaiss = :lieunaiss")
    , @NamedQuery(name = "Patient.findByVillagedeorig", query = "SELECT p FROM Patient p WHERE p.villagedeorig = :villagedeorig")
    , @NamedQuery(name = "Patient.findByAdresse", query = "SELECT p FROM Patient p WHERE p.adresse = :adresse")
    , @NamedQuery(name = "Patient.findByGenre", query = "SELECT p FROM Patient p WHERE p.genre = :genre")
    , @NamedQuery(name = "Patient.findByTelephone", query = "SELECT p FROM Patient p WHERE p.telephone = :telephone")
    , @NamedQuery(name = "Patient.findByStatutmat", query = "SELECT p FROM Patient p WHERE p.statutmat = :statutmat")})
public class Patient implements Serializable, EntityGestionPatient {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPATIENT")
    private Integer idpatient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "NOMS")
    private String noms;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PRENOMS")
    private String prenoms;
    @Size(max = 32)
    @Column(name = "NUMCNI")
    private String numcni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATENAISS")
    @Temporal(TemporalType.DATE)
    private Date datenaiss;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "LIEUNAISS")
    private String lieunaiss;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "VILLAGEDEORIG")
    private String villagedeorig;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ADRESSE")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "GENRE")
    private String genre;
    @Size(max = 128)
    @Column(name = "TELEPHONE")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "STATUTMAT")
    private String statutmat;
    @JoinColumn(name = "IDG", referencedColumnName = "IDG")
    @ManyToOne
    private Generaliste idg;
    @JoinColumn(name = "IDPERSONNE", referencedColumnName = "IDPERSONNE")
    @ManyToOne(optional = false)
    private Personnes idpersonne;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpatient")
    private Collection<FeuilleDeSoins> feuilleDeSoinsCollection;

    public Patient() {
    }

    public Patient(Integer idpatient) {
        this.idpatient = idpatient;
    }

    public Patient(Integer idpatient, String noms, String prenoms, Date datenaiss, String lieunaiss, String villagedeorig, String adresse, String genre, String statutmat) {
        this.idpatient = idpatient;
        this.noms = noms;
        this.prenoms = prenoms;
        this.datenaiss = datenaiss;
        this.lieunaiss = lieunaiss;
        this.villagedeorig = villagedeorig;
        this.adresse = adresse;
        this.genre = genre;
        this.statutmat = statutmat;
    }

    public Integer getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Integer idpatient) {
        this.idpatient = idpatient;
    }

    public String getNoms() {
        return noms;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getNumcni() {
        return numcni;
    }

    public void setNumcni(String numcni) {
        this.numcni = numcni;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public String getLieunaiss() {
        return lieunaiss;
    }

    public void setLieunaiss(String lieunaiss) {
        this.lieunaiss = lieunaiss;
    }

    public String getVillagedeorig() {
        return villagedeorig;
    }

    public void setVillagedeorig(String villagedeorig) {
        this.villagedeorig = villagedeorig;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatutmat() {
        return statutmat;
    }

    public void setStatutmat(String statutmat) {
        this.statutmat = statutmat;
    }

    public Generaliste getIdg() {
        return idg;
    }

    public void setIdg(Generaliste idg) {
        this.idg = idg;
    }

    public Personnes getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(Personnes idpersonne) {
        this.idpersonne = idpersonne;
    }

    @XmlTransient
    public Collection<FeuilleDeSoins> getFeuilleDeSoinsCollection() {
        return feuilleDeSoinsCollection;
    }

    public void setFeuilleDeSoinsCollection(Collection<FeuilleDeSoins> feuilleDeSoinsCollection) {
        this.feuilleDeSoinsCollection = feuilleDeSoinsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpatient != null ? idpatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.idpatient == null && other.idpatient != null) || (this.idpatient != null && !this.idpatient.equals(other.idpatient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Patient[ idpatient=" + idpatient + " ]";
    }
    
}
