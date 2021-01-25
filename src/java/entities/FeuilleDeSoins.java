/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "FEUILLE_DE_SOINS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FeuilleDeSoins.findAll", query = "SELECT f FROM FeuilleDeSoins f")
    , @NamedQuery(name = "FeuilleDeSoins.findByIdf", query = "SELECT f FROM FeuilleDeSoins f WHERE f.idf = :idf")
    , @NamedQuery(name = "FeuilleDeSoins.findByDateconsultation", query = "SELECT f FROM FeuilleDeSoins f WHERE f.dateconsultation = :dateconsultation")
    , @NamedQuery(name = "FeuilleDeSoins.findByMotifconsultation", query = "SELECT f FROM FeuilleDeSoins f WHERE f.motifconsultation = :motifconsultation")
    , @NamedQuery(name = "FeuilleDeSoins.findByTension", query = "SELECT f FROM FeuilleDeSoins f WHERE f.tension = :tension")
    , @NamedQuery(name = "FeuilleDeSoins.findByPouls", query = "SELECT f FROM FeuilleDeSoins f WHERE f.pouls = :pouls")
    , @NamedQuery(name = "FeuilleDeSoins.findByFrequencecard", query = "SELECT f FROM FeuilleDeSoins f WHERE f.frequencecard = :frequencecard")
    , @NamedQuery(name = "FeuilleDeSoins.findByTaille", query = "SELECT f FROM FeuilleDeSoins f WHERE f.taille = :taille")
    , @NamedQuery(name = "FeuilleDeSoins.findByPoid", query = "SELECT f FROM FeuilleDeSoins f WHERE f.poid = :poid")
    , @NamedQuery(name = "FeuilleDeSoins.findByTemperature", query = "SELECT f FROM FeuilleDeSoins f WHERE f.temperature = :temperature")
    , @NamedQuery(name = "FeuilleDeSoins.findByDiaprincipal", query = "SELECT f FROM FeuilleDeSoins f WHERE f.diaprincipal = :diaprincipal")
    , @NamedQuery(name = "FeuilleDeSoins.findByDiadifferentiel", query = "SELECT f FROM FeuilleDeSoins f WHERE f.diadifferentiel = :diadifferentiel")
    , @NamedQuery(name = "FeuilleDeSoins.findByResume", query = "SELECT f FROM FeuilleDeSoins f WHERE f.resume = :resume")
    , @NamedQuery(name = "FeuilleDeSoins.findByPathologie", query = "SELECT f FROM FeuilleDeSoins f WHERE f.pathologie = :pathologie")
    , @NamedQuery(name = "FeuilleDeSoins.findByEtatgeneral", query = "SELECT f FROM FeuilleDeSoins f WHERE f.etatgeneral = :etatgeneral")
    , @NamedQuery(name = "FeuilleDeSoins.findByExamenphysique", query = "SELECT f FROM FeuilleDeSoins f WHERE f.examenphysique = :examenphysique")
    , @NamedQuery(name = "FeuilleDeSoins.findByDate", query = "SELECT f FROM FeuilleDeSoins f WHERE f.date = :date")})
public class FeuilleDeSoins implements Serializable, EntityGestionPatient {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDF")
    private Integer idf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATECONSULTATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateconsultation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "MOTIFCONSULTATION")
    private String motifconsultation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "TENSION")
    private String tension;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "POULS")
    private String pouls;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "FREQUENCECARD")
    private String frequencecard;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAILLE")
    private BigDecimal taille;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POID")
    private BigDecimal poid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEMPERATURE")
    private BigDecimal temperature;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DIAPRINCIPAL")
    private String diaprincipal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DIADIFFERENTIEL")
    private String diadifferentiel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RESUME")
    private String resume;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PATHOLOGIE")
    private String pathologie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ETATGENERAL")
    private String etatgeneral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EXAMENPHYSIQUE")
    private String examenphysique;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idf")
    private Collection<Remboursement> remboursementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idf")
    private Collection<Medicament> medicamentCollection;
    @JoinColumn(name = "IDPATIENT", referencedColumnName = "IDPATIENT")
    @ManyToOne(optional = false)
    private Patient idpatient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idf")
    private Collection<Examen> examenCollection;

    public FeuilleDeSoins() {
    }

    public FeuilleDeSoins(Integer idf) {
        this.idf = idf;
    }

    public FeuilleDeSoins(Integer idf, Date dateconsultation, String motifconsultation, String tension, String pouls, String frequencecard, BigDecimal taille, BigDecimal poid, BigDecimal temperature, String diaprincipal, String diadifferentiel, String resume, String pathologie, String etatgeneral, String examenphysique, Date date) {
        this.idf = idf;
        this.dateconsultation = dateconsultation;
        this.motifconsultation = motifconsultation;
        this.tension = tension;
        this.pouls = pouls;
        this.frequencecard = frequencecard;
        this.taille = taille;
        this.poid = poid;
        this.temperature = temperature;
        this.diaprincipal = diaprincipal;
        this.diadifferentiel = diadifferentiel;
        this.resume = resume;
        this.pathologie = pathologie;
        this.etatgeneral = etatgeneral;
        this.examenphysique = examenphysique;
        this.date = date;
    }

    public Integer getIdf() {
        return idf;
    }

    public void setIdf(Integer idf) {
        this.idf = idf;
    }

    public Date getDateconsultation() {
        return dateconsultation;
    }

    public void setDateconsultation(Date dateconsultation) {
        this.dateconsultation = dateconsultation;
    }

    public String getMotifconsultation() {
        return motifconsultation;
    }

    public void setMotifconsultation(String motifconsultation) {
        this.motifconsultation = motifconsultation;
    }

    public String getTension() {
        return tension;
    }

    public void setTension(String tension) {
        this.tension = tension;
    }

    public String getPouls() {
        return pouls;
    }

    public void setPouls(String pouls) {
        this.pouls = pouls;
    }

    public String getFrequencecard() {
        return frequencecard;
    }

    public void setFrequencecard(String frequencecard) {
        this.frequencecard = frequencecard;
    }

    public BigDecimal getTaille() {
        return taille;
    }

    public void setTaille(BigDecimal taille) {
        this.taille = taille;
    }

    public BigDecimal getPoid() {
        return poid;
    }

    public void setPoid(BigDecimal poid) {
        this.poid = poid;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public String getDiaprincipal() {
        return diaprincipal;
    }

    public void setDiaprincipal(String diaprincipal) {
        this.diaprincipal = diaprincipal;
    }

    public String getDiadifferentiel() {
        return diadifferentiel;
    }

    public void setDiadifferentiel(String diadifferentiel) {
        this.diadifferentiel = diadifferentiel;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getPathologie() {
        return pathologie;
    }

    public void setPathologie(String pathologie) {
        this.pathologie = pathologie;
    }

    public String getEtatgeneral() {
        return etatgeneral;
    }

    public void setEtatgeneral(String etatgeneral) {
        this.etatgeneral = etatgeneral;
    }

    public String getExamenphysique() {
        return examenphysique;
    }

    public void setExamenphysique(String examenphysique) {
        this.examenphysique = examenphysique;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public Collection<Remboursement> getRemboursementCollection() {
        return remboursementCollection;
    }

    public void setRemboursementCollection(Collection<Remboursement> remboursementCollection) {
        this.remboursementCollection = remboursementCollection;
    }

    @XmlTransient
    public Collection<Medicament> getMedicamentCollection() {
        return medicamentCollection;
    }

    public void setMedicamentCollection(Collection<Medicament> medicamentCollection) {
        this.medicamentCollection = medicamentCollection;
    }

    public Patient getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Patient idpatient) {
        this.idpatient = idpatient;
    }

    @XmlTransient
    public Collection<Examen> getExamenCollection() {
        return examenCollection;
    }

    public void setExamenCollection(Collection<Examen> examenCollection) {
        this.examenCollection = examenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idf != null ? idf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FeuilleDeSoins)) {
            return false;
        }
        FeuilleDeSoins other = (FeuilleDeSoins) object;
        if ((this.idf == null && other.idf != null) || (this.idf != null && !this.idf.equals(other.idf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FeuilleDeSoins[ idf=" + idf + " ]";
    }
    
}
