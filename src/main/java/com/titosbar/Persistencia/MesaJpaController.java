
package main.java.com.titosbar.Persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import main.java.com.titosbar.exceptions.NonexistentEntityException;
import main.java.com.titosbar.modelo.Mesa;


public class MesaJpaController implements Serializable {

    public MesaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
     
    private EntityManagerFactory emf = null;
    
    public MesaJpaController(){
    emf = Persistence.createEntityManagerFactory("titosBarPU");
}     

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mesa mesa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mesa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mesa mesa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mesa = em.merge(mesa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mesa.getIdMesa();
                if (findMesa(id) == null) {
                    throw new NonexistentEntityException("The mesa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mesa mesa;
            try {
                mesa = em.getReference(Mesa.class, id);
                mesa.getIdMesa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mesa with id " + id + " no longer exists.", enfe);
            }
            em.remove(mesa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mesa> findMesaEntities() {
        return findMesaEntities(true, -1, -1);
    }

    public List<Mesa> findMesaEntities(int maxResults, int firstResult) {
        return findMesaEntities(false, maxResults, firstResult);
    }

    private List<Mesa> findMesaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mesa.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Mesa findMesa(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mesa.class, id);
        } finally {
            em.close();
        }
    }

    public int getMesaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mesa> rt = cq.from(Mesa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    void destroy(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
