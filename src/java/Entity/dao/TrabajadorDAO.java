
package Entity.dao;

import Entity.Trabajador;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class TrabajadorDAO {
    public List<Trabajador> obtenerTrabajadors(){
        List<Trabajador> arreglo = new ArrayList<>();
        try{
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            //Aqui hacemos la magia
            
            //Query q = session.createQuery("from Trabajador");
            arreglo = session.getNamedQuery("Trabajador.findAll").list();
            //Aqui termina la magia
            tx.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return arreglo;
    }
    
    public void crearTrabajador(Trabajador trabajador) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.merge(trabajador);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void eliminarTrabajador(String trabajadorId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Trabajador trabajador = (Trabajador) session.load(Trabajador.class, trabajadorId);
            session.delete(trabajador);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void updateTrabajador(Trabajador trabajador) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(trabajador);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public Trabajador findId(Long trabajadorId) {
        Trabajador trabajador = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
//            String queryString = "from Trabajador where id = :id";
//            Query query = session.createQuery(queryString);
//            query.setString("id", trabajadorId);
//            trabajador = (Trabajador) query.uniqueResult();
              List<Trabajador> lista = session.getNamedQuery("Trabajador.findById")
                      .setParameter("id",trabajadorId).list();
              for(Trabajador p : lista){
                  System.out.println(p);
              }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return trabajador;
    }
}
