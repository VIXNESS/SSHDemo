package dao.impl;

import dao.inf.StaffDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import pojo.StaffEntity;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Jiang
 */

@Repository(value = "staffDao")
public class StaffDaoImp implements StaffDaoI {

    private SessionFactory sessionFactory;//Hibernate SessionFactory via Spring DI

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //Methods implement
    @Override
    public List<StaffEntity> getAllStaff() {
        Session session = sessionFactory.getCurrentSession();//To obtain the Session object
        String hql = "from StaffEntity s";
        Query<StaffEntity> query = session.createQuery(hql);
        List<StaffEntity> staffEntityList = query.list();
        return staffEntityList;
    }

    @Override
    public List<StaffEntity> findAllStaffByConditions(Map<String, Object> conditions, Boolean... equalCondition) {
        //todo
        return null;
    }
}
