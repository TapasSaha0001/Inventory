package org.trial.inventory.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.trial.inventory.entity.Menu;

@Repository
public interface MenuRepo extends MongoRepository<Menu, String> {
}
