package bean;

import dao.PersonalDao;
import java.util.List;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.Personal;

@ManagedBean
@SessionScoped
public class PersonalBean {

    private Personal personal;
    private List<Personal> listaPersonal = new ArrayList();

    public PersonalBean() {
        personal = new Personal();
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public List<Personal> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(List<Personal> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    //Mostrar Personal
    public List<Personal> mostrar() {
        PersonalDao dao = new PersonalDao();
        listaPersonal = dao.mostrar();
        return listaPersonal;
    }

    //IngresarPersonal
    public void ingresar() {
        try {
            PersonalDao dao = new PersonalDao();
            dao.ingresar(personal);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //Modificar Personal
    public void modificar() {
        try {
            PersonalDao dao = new PersonalDao();
            dao.modificar(personal);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //Eliminar Personal
    public void eliminar(int id) {
        try {
            PersonalDao dao = new PersonalDao();
            dao.eliminar(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
