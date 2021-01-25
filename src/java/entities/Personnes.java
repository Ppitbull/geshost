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
@Table(name = "PERSONNES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personnes.findAll", query = "SELECT p FROM Personnes p")
    , @NamedQuery(name = "Personnes.findByIdpersonne", query = "SELECT p FROM Personnes p WHERE p.idpersonne = :idpersonne")
    , @NamedQuery(name = "Personnes.findByNoms", query = "SELECT p FROM Personnes p WHERE p.noms = :noms")
    , @NamedQuery(name = "Personnes.findByPrenoms", query = "SELECT p FROM Personnes p WHERE p.prenoms = :prenoms")
    , @NamedQuery(name = "Personnes.findByNumcni", query = "SELECT p FROM Personnes p WHERE p.numcni = :numcni")
    , @NamedQuery(name = "Personnes.findByDatenaiss", query = "SELECT p FROM Personnes p WHERE p.datenaiss = :datenaiss")
    , @NamedQuery(name = "Personnes.findByLieunaiss", query = "SELECT p FROM Personnes p WHERE p.lieunaiss = :lieunaiss")
    , @NamedQuery(name = "Personnes.findByVillagedeorig", query = "SELECT p FROM Personnes p WHERE p.villagedeorig = :villagedeorig")
    , @NamedQuery(name = "Personnes.findByAdresse", query = "SELECT p FROM Personnes p WHERE p.adresse = :adresse")
    , @NamedQuery(name = "Personnes.findByGenre", query = "SELECT p FROM Personnes p WHERE p.genre = :genre")
    , @NamedQuery(name = "Personnes.findByTelephone", query = "SELECT p FROM Personnes p WHERE p.telephone = :telephone")
    , @NamedQuery(name = "Personnes.findByStatutmat", query = "SELECT p FROM Personnes p WHERE p.statutmat = :statutmat")})
public class Personnes implements Serializable, EntityGestionPatient {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPERSONNE")
    private Integer idpersonne;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonne")
    private Collection<Medecin> medecinCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonne")
    private Collection<Patient> patientCollection;

    public Personnes() {
    }

    public Personnes(Integer idpersonne) {
        this.idpersonne = idpersonne;
    }

    public Personnes(Integer idpersonne, String noms, String prenoms, Date datenaiss, String lieunaiss, String villagedeorig, String adresse, String genre, String statutmat) {
        this.idpersonne = idpersonne;
        this.noms = noms;
        this.prenoms = prenoms;
        this.datenaiss = datenaiss;
        this.lieunaiss = lieunaiss;
        this.villagedeorig = villagedeorig;
        this.adresse = adresse;
        this.genre = genre;
        this.statutmat = statutmat;
    }

    public Integer getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(Integer idpersonne) {
        this.idpersonne = idpersonne;
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

    @XmlTransient
    public Collection<Medecin> getMedecinCollection() {
        return medecinCollection;
    }

    public void setMedecinCollection(Collection<Medecin> medecinCollection) {
        this.medecinCollection = medecinCollection;
    }

    @XmlTransient
    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersonne != null ? idpersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnes)) {
            return false;
        }
        Personnes other = (Personnes) object;
        if ((this.idpersonne == null && other.idpersonne != null) || (this.idpersonne != null && !this.idpersonne.equals(other.idpersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Personnes[ idpersonne=" + idpersonne + " ]";
    }
    
}
