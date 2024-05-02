package com.nicolas.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.nicolas.course.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    private Integer status;
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();
    // private Payment payment;

    public Order(Long id, Instant moment, User client, OrderStatus status) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        this.setOrderStatus(status);
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(this.status);
    }

    public void setOrderStatus(OrderStatus status) {
        if (status != null) {
            this.status = status.getCode();
        }
    }
}
