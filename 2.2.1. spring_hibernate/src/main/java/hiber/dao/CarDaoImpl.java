package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.lang.model.element.TypeParameterElement;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CarDaoImpl implements CarDao{
    @Override
    public void add(Car car) {

    }

    @Override
    public List<Car> listCar() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car ");
        return query.getResultList();
    }
    @Autowired
    private SessionFactory sessionFactory;

}
