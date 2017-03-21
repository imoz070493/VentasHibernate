
package Entity.dao;

import Entity.DetalleIngreso;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class DetalleIngresoDAO {
    public List<DetalleIngreso> obtenerDetalleIngresos(){
        List<DetalleIngreso> arreglo = new ArrayList<>();
        try{
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            //Aqui hacemos la magia
            
            //Query q = session.createQuery("from DetalleIngreso");
            arreglo = session.getNamedQuery("DetalleIngreso.findAll").list();
            //Aqui termina la magia
            tx.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return arreglo;
    }
    
    public void crearDetalleIngreso(DetalleIngreso detalleIngreso) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.merge(detalleIngreso);
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

    public void eliminarDetalleIngreso(String detalleIngresoId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            DetalleIngreso detalleIngreso = (DetalleIngreso) session.load(DetalleIngreso.class, detalleIngresoId);
            session.delete(detalleIngreso);
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

    public void updateDetalleIngreso(DetalleIngreso detalleIngreso) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(detalleIngreso);
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
    
    public DetalleIngreso findId(Long detalleIngresoId) {
        DetalleIngreso detalleIngreso = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
//            String queryString = "from DetalleIngreso where id = :id";
//            Query query = session.createQuery(queryString);
//            query.setString("id", detalleIngresoId);
//            detalleIngreso = (DetalleIngreso) query.uniqueResult();
              List<DetalleIngreso> lista = session.getNamedQuery("DetalleIngreso.findById")
                      .setParameter("id",detalleIngresoId).list();
              for(DetalleIngreso p : lista){
                  System.out.println(p);
              }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return detalleIngreso;
    }
}
