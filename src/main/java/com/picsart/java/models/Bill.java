package com.picsart.java.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId;
    @Column(name = "service_fee")
    private Double serviceFee;
    @Column(name = "tax")
    private Double tax;
    @Column(name = "tip")
    private Double tip;
    @Min(value = 1)
    @Column(name = "total")
    private  Double total;
    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;

    public Bill() {
    }

    public Bill(Double serviceFee, Double tax, Double tip, Double total, Order order) {
        this.serviceFee = serviceFee;
        this.tax = tax;
        this.tip = tip;
        this.total = total;
        this.order = order;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTip() {
        return tip;
    }

    public void setTip(Double tip) {
        this.tip = tip;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
