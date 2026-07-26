package org.trial.inventory.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.trial.inventory.entity.Menu;
import org.trial.inventory.entity.Stock;
import org.trial.inventory.repository.InventoryRepo;
import org.trial.inventory.repository.MenuRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final MenuRepo menuRepo;
    private final InventoryRepo inventoryRepo;

    public List<Menu> getMenuDetails() {
        return menuRepo.findAll();
    }

    public List<Menu> saveMenu(List<Menu> menuList) {
        return menuRepo.saveAll(menuList);
    }

    public List<Stock> addStocks(List<Stock> stockList) {
        return inventoryRepo.saveAll(stockList);
    }
}
