/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

import entity.ProfesorAsignatura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author pabloalvaradoruiz
 */
@Stateless
public class ProfesorAsignaturaFacade extends AbstractFacade<ProfesorAsignatura> {

    @PersistenceContext(unitName = "JPAWebApplicationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfesorAsignaturaFacade() {
        super(ProfesorAsignatura.class);
    }
    
}
