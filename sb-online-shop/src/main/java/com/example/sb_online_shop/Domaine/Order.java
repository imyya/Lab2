package com.example.sb_online_shop.Domaine;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name ="Orders")
public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long Id;
        private Double total;

        @ManyToOne(fetch =FetchType.EAGER)
        @JoinColumn(name = "customer_id")
        private Customer customer ;


        public Order(){}

        public Order(double total , Customer customer){
            super();
            this.total=total;
            this.customer=customer;
        }

        public Long getId() {
            return Id;
        }

        public Double getTotal() {
            return total;
        }

        public void setId(Long id) {
            Id = id;
        }

        public void setTotal(Double total) {
            this.total = total;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }


    
}
