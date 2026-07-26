package org.trial.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.trial.inventory.entity.Menu;
import org.trial.inventory.entity.Stock;
import org.trial.inventory.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("getMenu")
    public List<Menu> getMenu() {
        return inventoryService.getMenuDetails();
    }
    @PostMapping("menuEntry")
    public List<Menu> setMenu(@RequestBody List<Menu> menu) {
        return inventoryService.saveMenu(menu);
    }
    @PostMapping("stock")
    public List<Stock> setStock(@RequestBody List<Stock> stockList) {
        return inventoryService.addStocks(stockList);
    }

}
