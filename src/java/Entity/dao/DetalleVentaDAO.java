
package Entity.dao;

import Entity.DetalleVenta;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class DetalleVentaDAO {
    public List<DetalleVenta> obtenerDetalleVentas(){
        List<DetalleVenta> arreglo = new ArrayList<>();
        try{
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            //Aqui hacemos la magia
            
            //Query q = session.createQuery("from DetalleVenta");
            arreglo = session.getNamedQuery("DetalleVenta.findAll").list();
            //Aqui termina la magia
            tx.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return arreglo;
    }
    
    public void crearDetalleVenta(DetalleVenta detalleVenta) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.merge(detalleVenta);
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

    public void eliminarDetalleVenta(String detalleVentaId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            DetalleVenta detalleVenta = (DetalleVenta) session.load(DetalleVenta.class, detalleVentaId);
            session.delete(detalleVenta);
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

    public void updateDetalleVenta(DetalleVenta detalleVenta) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(detalleVenta);
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
    
    public DetalleVenta findId(Long detalleVentaId) {
        DetalleVenta detalleVenta = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
//            String queryString = "from DetalleVenta where id = :id";
//            Query query = session.createQuery(queryString);
//            query.setString("id", detalleVentaId);
//            detalleVenta = (DetalleVenta) query.uniqueResult();
              List<DetalleVenta> lista = session.getNamedQuery("DetalleVenta.findById")
                      .setParameter("id",detalleVentaId).list();
              for(DetalleVenta p : lista){
                  System.out.println(p);
              }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return detalleVenta;
    }
}
