/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metiers;

import entities.EntityGestionPatient;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ppitbull
 */
public abstract class GestionPatienManager {
    @PersistenceContext(unitName = "GestionPatientPU")
    protected EntityManager em;

    public void create(EntityGestionPatient entity) {
        this.persist(entity);
    }

    public EntityGestionPatient update(EntityGestionPatient entity) {
        return em.merge(entity);
    }

    public void delete(EntityGestionPatient entity) {
        em.remove(entity);
    }
     public void persist(Object object) {
        em.persist(object);
    }
    abstract List<EntityGestionPatient> getAll();
    abstract EntityGestionPatient getById();
}
