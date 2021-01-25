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
@Table(name = "MEDECIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medecin.findAll", query = "SELECT m FROM Medecin m")
    , @NamedQuery(name = "Medecin.findByMatemploye", query = "SELECT m FROM Medecin m WHERE m.matemploye = :matemploye")
    , @NamedQuery(name = "Medecin.findByTypecontrat", query = "SELECT m FROM Medecin m WHERE m.typecontrat = :typecontrat")
    , @NamedQuery(name = "Medecin.findByDernierdiplome", query = "SELECT m FROM Medecin m WHERE m.dernierdiplome = :dernierdiplome")
    , @NamedQuery(name = "Medecin.findByTypeuser", query = "SELECT m FROM Medecin m WHERE m.typeuser = :typeuser")
    , @NamedQuery(name = "Medecin.findByNoms", query = "SELECT m FROM Medecin m WHERE m.noms = :noms")
    , @NamedQuery(name = "Medecin.findByPrenoms", query = "SELECT m FROM Medecin m WHERE m.prenoms = :prenoms")
    , @NamedQuery(name = "Medecin.findByNumcni", query = "SELECT m FROM Medecin m WHERE m.numcni = :numcni")
    , @NamedQuery(name = "Medecin.findByDatenaiss", query = "SELECT m FROM Medecin m WHERE m.datenaiss = :datenaiss")
    , @NamedQuery(name = "Medecin.findByLieunaiss", query = "SELECT m FROM Medecin m WHERE m.lieunaiss = :lieunaiss")
    , @NamedQuery(name = "Medecin.findByVillagedeorig", query = "SELECT m FROM Medecin m WHERE m.villagedeorig = :villagedeorig")
    , @NamedQuery(name = "Medecin.findByAdresse", query = "SELECT m FROM Medecin m WHERE m.adresse = :adresse")
    , @NamedQuery(name = "Medecin.findByGenre", query = "SELECT m FROM Medecin m WHERE m.genre = :genre")
    , @NamedQuery(name = "Medecin.findByTelephone", query = "SELECT m FROM Medecin m WHERE m.telephone = :telephone")
    , @NamedQuery(name = "Medecin.findByStatutmat", query = "SELECT m FROM Medecin m WHERE m.statutmat = :statutmat")})
public class Medecin implements Serializable, EntityGestionPatient {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "MATEMPLOYE")
    private String matemploye;
    @Size(max = 32)
    @Column(name = "TYPECONTRAT")
    private String typecontrat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "DERNIERDIPLOME")
    private String dernierdiplome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "TYPEUSER")
    private String typeuser;
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
    @JoinColumn(name = "IDPERSONNE", referencedColumnName = "IDPERSONNE")
    @ManyToOne(optional = false)
    private Personnes idpersonne;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matemploye")
    private Collection<Specialiste> specialisteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matemploye")
    private Collection<Generaliste> generalisteCollection;

    public Medecin() {
    }

    public Medecin(String matemploye) {
        this.matemploye = matemploye;
    }

    public Medecin(String matemploye, String dernierdiplome, String typeuser, String noms, String prenoms, Date datenaiss, String lieunaiss, String villagedeorig, String adresse, String genre, String statutmat) {
        this.matemploye = matemploye;
        this.dernierdiplome = dernierdiplome;
        this.typeuser = typeuser;
        this.noms = noms;
        this.prenoms = prenoms;
        this.datenaiss = datenaiss;
        this.lieunaiss = lieunaiss;
        this.villagedeorig = villagedeorig;
        this.adresse = adresse;
        this.genre = genre;
        this.statutmat = statutmat;
    }

    public String getMatemploye() {
        return matemploye;
    }

    public void setMatemploye(String matemploye) {
        this.matemploye = matemploye;
    }

    public String getTypecontrat() {
        return typecontrat;
    }

    public void setTypecontrat(String typecontrat) {
        this.typecontrat = typecontrat;
    }

    public String getDernierdiplome() {
        return dernierdiplome;
    }

    public void setDernierdiplome(String dernierdiplome) {
        this.dernierdiplome = dernierdiplome;
    }

    public String getTypeuser() {
        return typeuser;
    }

    public void setTypeuser(String typeuser) {
        this.typeuser = typeuser;
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

    public Personnes getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(Personnes idpersonne) {
        this.idpersonne = idpersonne;
    }

    @XmlTransient
    public Collection<Specialiste> getSpecialisteCollection() {
        return specialisteCollection;
    }

    public void setSpecialisteCollection(Collection<Specialiste> specialisteCollection) {
        this.specialisteCollection = specialisteCollection;
    }

    @XmlTransient
    public Collection<Generaliste> getGeneralisteCollection() {
        return generalisteCollection;
    }

    public void setGeneralisteCollection(Collection<Generaliste> generalisteCollection) {
        this.generalisteCollection = generalisteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matemploye != null ? matemploye.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medecin)) {
            return false;
        }
        Medecin other = (Medecin) object;
        if ((this.matemploye == null && other.matemploye != null) || (this.matemploye != null && !this.matemploye.equals(other.matemploye))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Medecin[ matemploye=" + matemploye + " ]";
    }
    
}
