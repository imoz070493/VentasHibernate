
package Entity.dao;

import Entity.Cliente;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class ClienteDAO {
    public List<Cliente> obtenerClientes(){
        List<Cliente> arreglo = new ArrayList<>();
        try{
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            //Aqui hacemos la magia
            
            //Query q = session.createQuery("from Cliente");
            arreglo = session.getNamedQuery("Cliente.findAll").list();
            //Aqui termina la magia
            tx.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return arreglo;
    }
    
    public void crearCliente(Cliente cliente) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.merge(cliente);
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

    public void eliminarCliente(String clienteId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Cliente cliente = (Cliente) session.load(Cliente.class, clienteId);
            session.delete(cliente);
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

    public void updateCliente(Cliente cliente) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(cliente);
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
    
    public Cliente findId(Long clienteId) {
        Cliente cliente = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
//            String queryString = "from Cliente where id = :id";
//            Query query = session.createQuery(queryString);
//            query.setString("id", clienteId);
//            cliente = (Cliente) query.uniqueResult();
              List<Cliente> lista = session.getNamedQuery("Cliente.findById")
                      .setParameter("id",clienteId).list();
              for(Cliente p : lista){
                  System.out.println(p);
              }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return cliente;
    }
}
