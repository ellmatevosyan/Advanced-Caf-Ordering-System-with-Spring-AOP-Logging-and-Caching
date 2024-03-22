package com.picsart.java.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long orderId;
    @Min(value = 1)
    @Column(name = "quantity",nullable = false)
    private Integer quantity;
    @Min(value = 1)
    @Column(name = "item_id")
    private Long itemId;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;

    public OrderDetail() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
