package org.trial.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.trial.inventory.entity.Stock;

@Repository
public interface InventoryRepo extends MongoRepository<Stock, String> {
}
