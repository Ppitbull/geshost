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
@Table(name = "GENERALISTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Generaliste.findAll", query = "SELECT g FROM Generaliste g")
    , @NamedQuery(name = "Generaliste.findByIdg", query = "SELECT g FROM Generaliste g WHERE g.idg = :idg")
    , @NamedQuery(name = "Generaliste.findByTypecontrat", query = "SELECT g FROM Generaliste g WHERE g.typecontrat = :typecontrat")
    , @NamedQuery(name = "Generaliste.findByDernierdiplome", query = "SELECT g FROM Generaliste g WHERE g.dernierdiplome = :dernierdiplome")
    , @NamedQuery(name = "Generaliste.findByTypeuser", query = "SELECT g FROM Generaliste g WHERE g.typeuser = :typeuser")
    , @NamedQuery(name = "Generaliste.findByNoms", query = "SELECT g FROM Generaliste g WHERE g.noms = :noms")
    , @NamedQuery(name = "Generaliste.findByPrenoms", query = "SELECT g FROM Generaliste g WHERE g.prenoms = :prenoms")
    , @NamedQuery(name = "Generaliste.findByNumcni", query = "SELECT g FROM Generaliste g WHERE g.numcni = :numcni")
    , @NamedQuery(name = "Generaliste.findByDatenaiss", query = "SELECT g FROM Generaliste g WHERE g.datenaiss = :datenaiss")
    , @NamedQuery(name = "Generaliste.findByLieunaiss", query = "SELECT g FROM Generaliste g WHERE g.lieunaiss = :lieunaiss")
    , @NamedQuery(name = "Generaliste.findByVillagedeorig", query = "SELECT g FROM Generaliste g WHERE g.villagedeorig = :villagedeorig")
    , @NamedQuery(name = "Generaliste.findByAdresse", query = "SELECT g FROM Generaliste g WHERE g.adresse = :adresse")
    , @NamedQuery(name = "Generaliste.findByGenre", query = "SELECT g FROM Generaliste g WHERE g.genre = :genre")
    , @NamedQuery(name = "Generaliste.findByTelephone", query = "SELECT g FROM Generaliste g WHERE g.telephone = :telephone")
    , @NamedQuery(name = "Generaliste.findByStatutmat", query = "SELECT g FROM Generaliste g WHERE g.statutmat = :statutmat")})
public class Generaliste implements Serializable, EntityGestionPatient {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "IDG")
    private String idg;
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
    @OneToMany(mappedBy = "idg")
    private Collection<Patient> patientCollection;
    @JoinColumn(name = "MATEMPLOYE", referencedColumnName = "MATEMPLOYE")
    @ManyToOne(optional = false)
    private Medecin matemploye;

    public Generaliste() {
    }

    public Generaliste(String idg) {
        this.idg = idg;
    }

    public Generaliste(String idg, String dernierdiplome, String typeuser, String noms, String prenoms, Date datenaiss, String lieunaiss, String villagedeorig, String adresse, String genre, String statutmat) {
        this.idg = idg;
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

    public String getIdg() {
        return idg;
    }

    public void setIdg(String idg) {
        this.idg = idg;
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

    @XmlTransient
    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }

    public Medecin getMatemploye() {
        return matemploye;
    }

    public void setMatemploye(Medecin matemploye) {
        this.matemploye = matemploye;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idg != null ? idg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Generaliste)) {
            return false;
        }
        Generaliste other = (Generaliste) object;
        if ((this.idg == null && other.idg != null) || (this.idg != null && !this.idg.equals(other.idg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Generaliste[ idg=" + idg + " ]";
    }
    
}
