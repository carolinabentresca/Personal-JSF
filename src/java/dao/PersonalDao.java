package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import pojo.Personal;

public class PersonalDao {

    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session ss = sf.openSession();

    //Ingresar
    public void ingresar(Personal p) {
        try {
            ss.beginTransaction();
            ss.save(p);
            ss.getTransaction().commit();
            ss.close();
        } catch (HibernateException e) {
            e.getMessage();
        }
    }

    //Modificar
    public void modificar(Personal p) {
        try {
            ss.beginTransaction();
            ss.update(p);
            ss.getTransaction().commit();
            ss.close();
        } catch (HibernateException e) {
            e.getMessage();
        }
    }

    //Eliminar
    public void eliminar(int id) {
        try {
            ss.beginTransaction();
            Personal p = (Personal) ss.get(Personal.class, id);
            if (p != null) {
                ss.delete(p);
            }
            ss.getTransaction().commit();
            ss.close();
        } catch (HibernateException e) {
            e.getMessage();
        }
    }

    //Mostrar
    public List<Personal> mostrar() {
        Query q = ss.createQuery("from Personal");
        List<Personal> lista = q.list();
        ss.close();
        return lista;
    }
}
