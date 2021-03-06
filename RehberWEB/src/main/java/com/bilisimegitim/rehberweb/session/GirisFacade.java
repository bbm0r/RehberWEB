
package com.bilisimegitim.rehberweb.session;

import com.bilisimegitim.rehberweb.entity.Giris;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class GirisFacade extends AbstractFacade<Giris> {

    @PersistenceContext(unitName = "com.bilisimegitim_RehberWEB_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GirisFacade() {
        super(Giris.class);
    }
    
    public boolean girisKontrol(String p_username, String p_sifre)
    {
        Giris g = em.createNamedQuery("Giris.girisKontrol", Giris.class).setParameter("kullanici", p_username).setParameter("sifre", p_sifre).getSingleResult();
        
        if(g!=null)
        {
            return true;
        }
       else
        {
            return false;
        }
         
    }



}
