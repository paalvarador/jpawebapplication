/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

import entity.EstudianteAsignatura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author pabloalvaradoruiz
 */
@Stateless
public class EstudianteAsignaturaFacade extends AbstractFacade<EstudianteAsignatura> {

    @PersistenceContext(unitName = "JPAWebApplicationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteAsignaturaFacade() {
        super(EstudianteAsignatura.class);
    }
    
}
