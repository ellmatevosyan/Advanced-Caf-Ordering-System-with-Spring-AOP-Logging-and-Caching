package com.picsart.java.dao;

import com.picsart.java.models.Bill;
import com.picsart.java.models.MenuItem;
import com.picsart.java.models.Order;
import com.picsart.java.models.OrderDetail;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

@Service
public class BillDAO {
    private final SessionFactory sessionFactory;
    private static final Double TAX = 0.2;
    private static final Double FEE = 0.1;
    private static final Double TIP = 0.1;

    public BillDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(Order order){
        Session session = sessionFactory.getCurrentSession();
        Bill billing = new Bill();
        OrderDetail orderItem = session.get(OrderDetail.class,order.getOrderId());
        MenuItem menuItem = session.get(MenuItem.class,orderItem.getItemId());
        billing.setOrder(order);
        billing.setTax(menuItem.getPrice()*TAX*orderItem.getQuantity());
        billing.setTip(menuItem.getPrice()*TIP*orderItem.getQuantity());
        billing.setServiceFee(menuItem.getPrice()*FEE*orderItem.getQuantity());
        billing.setTotal(menuItem.getPrice()*(TAX+FEE+TIP)+ menuItem.getPrice()*orderItem.getQuantity());
        session.persist(billing);
    }


    @Transactional
    public Bill view(Long orderId){
        Session session = sessionFactory.getCurrentSession();
        String sql = "FROM Bill WHERE order.orderId = :orderId";
        Query query = session.createQuery(sql);
        query.setParameter("orderId",orderId);
        return (Bill) query.uniqueResult();
    }

    @Transactional
    public void delete(Long orderId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "DELETE FROM Bill WHERE order.orderId = :orderId";
        session.createQuery(sql).setParameter("orderId",orderId).executeUpdate();

    }

}
