package org.trial.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.trial.inventory.entity.Order;

@Repository
public interface OrderRepo extends MongoRepository<Order, Long> {
}
