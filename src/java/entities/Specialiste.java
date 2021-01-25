/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ppitbull
 */
@Entity
@Table(name = "SPECIALISTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specialiste.findAll", query = "SELECT s FROM Specialiste s")
    , @NamedQuery(name = "Specialiste.findByIds", query = "SELECT s FROM Specialiste s WHERE s.ids = :ids")
    , @NamedQuery(name = "Specialiste.findByTypecontrat", query = "SELECT s FROM Specialiste s WHERE s.typecontrat = :typecontrat")
    , @NamedQuery(name = "Specialiste.findByDernierdiplome", query = "SELECT s FROM Specialiste s WHERE s.dernierdiplome = :dernierdiplome")
    , @NamedQuery(name = "Specialiste.findByTypeuser", query = "SELECT s FROM Specialiste s WHERE s.typeuser = :typeuser")
    , @NamedQuery(name = "Specialiste.findByNoms", query = "SELECT s FROM Specialiste s WHERE s.noms = :noms")
    , @NamedQuery(name = "Specialiste.findByPrenoms", query = "SELECT s FROM Specialiste s WHERE s.prenoms = :prenoms")
    , @NamedQuery(name = "Specialiste.findByNumcni", query = "SELECT s FROM Specialiste s WHERE s.numcni = :numcni")
    , @NamedQuery(name = "Specialiste.findByDatenaiss", query = "SELECT s FROM Specialiste s WHERE s.datenaiss = :datenaiss")
    , @NamedQuery(name = "Specialiste.findByLieunaiss", query = "SELECT s FROM Specialiste s WHERE s.lieunaiss = :lieunaiss")
    , @NamedQuery(name = "Specialiste.findByVillagedeorig", query = "SELECT s FROM Specialiste s WHERE s.villagedeorig = :villagedeorig")
    , @NamedQuery(name = "Specialiste.findByAdresse", query = "SELECT s FROM Specialiste s WHERE s.adresse = :adresse")
    , @NamedQuery(name = "Specialiste.findByGenre", query = "SELECT s FROM Specialiste s WHERE s.genre = :genre")
    , @NamedQuery(name = "Specialiste.findByTelephone", query = "SELECT s FROM Specialiste s WHERE s.telephone = :telephone")
    , @NamedQuery(name = "Specialiste.findByStatutmat", query = "SELECT s FROM Specialiste s WHERE s.statutmat = :statutmat")})
public class Specialiste implements Serializable, EntityGestionPatient {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "IDS")
    private String ids;
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
    @JoinColumn(name = "MATEMPLOYE", referencedColumnName = "MATEMPLOYE")
    @ManyToOne(optional = false)
    private Medecin matemploye;

    public Specialiste() {
    }

    public Specialiste(String ids) {
        this.ids = ids;
    }

    public Specialiste(String ids, String dernierdiplome, String typeuser, String noms, String prenoms, Date datenaiss, String lieunaiss, String villagedeorig, String adresse, String genre, String statutmat) {
        this.ids = ids;
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

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
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

    public Medecin getMatemploye() {
        return matemploye;
    }

    public void setMatemploye(Medecin matemploye) {
        this.matemploye = matemploye;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ids != null ? ids.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specialiste)) {
            return false;
        }
        Specialiste other = (Specialiste) object;
        if ((this.ids == null && other.ids != null) || (this.ids != null && !this.ids.equals(other.ids))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Specialiste[ ids=" + ids + " ]";
    }
    
}
