package org.zeroclub.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zeroclub.ecom.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}