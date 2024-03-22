package com.picsart.java.dao;

import com.picsart.java.models.OrderDetail;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailDAO {
    private final SessionFactory sessionFactory;

    public OrderDetailDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    public void update(Long order_item_id,OrderDetail orderItemUpdate){
        Session session = sessionFactory.getCurrentSession();
        OrderDetail orderItem = session.get(OrderDetail.class,order_item_id);
        orderItem.setItemId(orderItemUpdate.getItemId());
        orderItem.setQuantity(orderItemUpdate.getQuantity());
    }

    @Transactional
    public OrderDetail viewOI(Long order_item_id){
        Session session = sessionFactory.getCurrentSession();
        return  session.get(OrderDetail.class,order_item_id);
    }
    @Transactional
    public void delete(Long order_item_id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "DELETE FROM OrderDetail WHERE order.orderId = :orderId";
        session.createQuery(hql).setParameter("orderId", order_item_id).executeUpdate();
    }
}
