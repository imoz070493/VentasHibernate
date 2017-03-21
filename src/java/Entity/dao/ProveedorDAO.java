
package Entity.dao;

import Entity.Proveedor;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class ProveedorDAO {
    public List<Proveedor> obtenerProveedors(){
        List<Proveedor> arreglo = new ArrayList<>();
        try{
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            //Aqui hacemos la magia
            
            //Query q = session.createQuery("from Proveedor");
            arreglo = session.getNamedQuery("Proveedor.findAll").list();
            //Aqui termina la magia
            tx.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return arreglo;
    }
    
    public void crearProveedor(Proveedor proveedor) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.merge(proveedor);
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

    public void eliminarProveedor(String proveedorId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Proveedor proveedor = (Proveedor) session.load(Proveedor.class, proveedorId);
            session.delete(proveedor);
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

    public void updateProveedor(Proveedor proveedor) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(proveedor);
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
    
    public Proveedor findId(Long proveedorId) {
        Proveedor proveedor = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
//            String queryString = "from Proveedor where id = :id";
//            Query query = session.createQuery(queryString);
//            query.setString("id", proveedorId);
//            proveedor = (Proveedor) query.uniqueResult();
              List<Proveedor> lista = session.getNamedQuery("Proveedor.findById")
                      .setParameter("id",proveedorId).list();
              for(Proveedor p : lista){
                  System.out.println(p);
              }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return proveedor;
    }
}
