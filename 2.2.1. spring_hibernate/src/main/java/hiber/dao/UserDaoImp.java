package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findUser(String car_model, int car_series) {
        TypedQuery<User> findaQuery = sessionFactory.getCurrentSession().createQuery("from User where car.model=:car_model and  car.series =:car_series")
                .setParameter("car_model", car_model)
                .setParameter("car_series", car_series);
        return findaQuery.getSingleResult();

    }


}


