package org.trial.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.trial.inventory.entity.Stock;

import java.util.Optional;

@Repository
public interface InventoryRepo extends MongoRepository<Stock, String> {

    Optional<Stock> findByItemName(String itemName);
}
