
package Entity.dao;

import Entity.Ingreso;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class IngresoDAO {
    public List<Ingreso> obtenerIngresos(){
        List<Ingreso> arreglo = new ArrayList<>();
        try{
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            //Aqui hacemos la magia
            
            //Query q = session.createQuery("from Ingreso");
            arreglo = session.getNamedQuery("Ingreso.findAll").list();
            //Aqui termina la magia
            tx.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return arreglo;
    }
    
    public void crearIngreso(Ingreso ingreso) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.merge(ingreso);
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

    public void eliminarIngreso(String ingresoId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Ingreso ingreso = (Ingreso) session.load(Ingreso.class, ingresoId);
            session.delete(ingreso);
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

    public void updateIngreso(Ingreso ingreso) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(ingreso);
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
    
    public Ingreso findId(Long ingresoId) {
        Ingreso ingreso = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
//            String queryString = "from Ingreso where id = :id";
//            Query query = session.createQuery(queryString);
//            query.setString("id", ingresoId);
//            ingreso = (Ingreso) query.uniqueResult();
              List<Ingreso> lista = session.getNamedQuery("Ingreso.findById")
                      .setParameter("id",ingresoId).list();
              for(Ingreso p : lista){
                  System.out.println(p);
              }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return ingreso;
    }
}
